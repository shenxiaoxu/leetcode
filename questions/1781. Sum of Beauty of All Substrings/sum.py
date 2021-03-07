'''
The beauty of a string is the difference in frequencies between the most frequent and least frequent characters.

For example, the beauty of "abaacc" is 3 - 1 = 2.
Given a string s, return the sum of beauty of all of its substrings.
'''
class Solution:
    def beautySum(self, s: str) -> int:
        ans = 0
        for i in range(len(s)):
            freq = [0]*26
            for j in range(i, len(s)):
                freq[ord(s[j]) - ord('a')] += 1
                ans += max(freq) - min(x for x in freq if x)
        return ans