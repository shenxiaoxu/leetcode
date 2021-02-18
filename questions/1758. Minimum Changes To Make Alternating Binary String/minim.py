'''
You are given a string s consisting only of the characters '0' and '1'. In one operation, you can change any '0' to '1' or vice versa.

The string is called alternating if no two adjacent characters are equal. For example, the string "010" is alternating, while the string "0100" is not.

Return the minimum number of operations needed to make s alternating.
'''
class Solution:
    def minOperations(self, s: str) -> int:
        t1, t2 = "", ""
        for i in range(len(s)):
            if i % 2 == 0:
                t1 += "0" 
                t2 += "1"
            else:
                t1 += "1"
                t2 += "0"
        d1, d2 = 0, 0
        for i in range(len(s)):
            if t1[i] != s[i]:
                d1 += 1
            if t2[i] != s[i]:
                d2 += 1
        return min(d1, d2)