'''
Given a string s consisting only of characters 'a', 'b', and 'c'. You are asked to apply the following algorithm on the string any number of times:

Pick a non-empty prefix from the string s where all the characters in the prefix are equal.
Pick a non-empty suffix from the string s where all the characters in this suffix are equal.
The prefix and the suffix should not intersect at any index.
The characters from the prefix and suffix must be the same.
Delete both the prefix and the suffix.
Return the minimum length of s after performing the above operation any number of times (possibly zero times).
'''
class Solution:
    def minimumLength(self, s: str) -> int:
        start, end = 0, len(s) - 1
        while start < end and s[start] == s[end]:
            c = s[start]
            while start < end and s[start] == c:
                start += 1
            while start <= end and s[end] == c:
                end -= 1
        if end < start: 
            return 0
        return end - start + 1