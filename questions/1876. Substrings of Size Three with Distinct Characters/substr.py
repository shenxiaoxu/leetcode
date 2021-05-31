'''

A string is good if there are no repeated characters.

Given a string s​​​​​, return the number of good substrings of length three in s​​​​​​.

Note that if there are multiple occurrences of the same substring, every occurrence should be counted.

A substring is a contiguous sequence of characters in a string.
'''
class Solution:
    def countGoodSubstrings(self, s: str) -> int:
        res = 0
        for i in range(len(s) - 2):
            sub = s[i:i + 3]
            m = Counter(sub)
            found = True
            for k, v in m.items():
                if v != 1:
                    found = False
            if found:
                res += 1
        return res
            