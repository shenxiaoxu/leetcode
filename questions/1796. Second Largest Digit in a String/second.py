'''
Given an alphanumeric string s, return the second largest numerical digit that appears in s, or -1 if it does not exist.

An alphanumeric string is a string consisting of lowercase English letters and digits.
'''
class Solution:
    def secondHighest(self, s: str) -> int:
        res = []
        for c in s:
            if '0' <= c <= '9' and c not in res:
                res.append(c)
        res.sort()
        print(res)
        return -1 if len(res) < 2 else res[-2]