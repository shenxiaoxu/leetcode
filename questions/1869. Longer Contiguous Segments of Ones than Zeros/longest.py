'''
Given a binary string s, return true if the longest contiguous segment of 1s is strictly longer than the longest contiguous segment of 0s in s. Return false otherwise.

For example, in s = "110100010" the longest contiguous segment of 1s has length 2, and the longest contiguous segment of 0s has length 3.
Note that if there are no 0s, then the longest contiguous segment of 0s is considered to have length 0. The same applies if there are no 1s.
'''
class Solution:
    def checkZeroOnes(self, s: str) -> bool:
        cur1, res1 = 0, 0
        cur2, res2 = 0, 0
        for i in range(len(s)):
            if s[i] == '1':
                cur1 += 1
                res1 = max(cur1, res1)
                cur2 = 0
            else:
                cur1 = 0
                cur2 += 1
                res2 = max(cur2, res2)
        return res1 > res2