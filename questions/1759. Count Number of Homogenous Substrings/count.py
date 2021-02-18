'''
Given a string s, return the number of homogenous substrings of s. Since the answer may be too large, return it modulo 109 + 7.

A string is homogenous if all the characters of the string are the same.

A substring is a contiguous sequence of characters within a string.
'''
class Solution:
    def countHomogenous(self, s: str) -> int:
        m, res, i = 1_000_000_007, 0, 0
        while i < len(s):
            start = i
            while i + 1 < len(s) and s[i + 1] == s[i]:
                i += 1
            l = i - start + 1
            res = (res + l*(l+1)//2)%m
            i += 1
        return res
            