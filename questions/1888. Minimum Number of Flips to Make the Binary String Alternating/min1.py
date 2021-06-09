'''
You are given a binary string s. You are allowed to perform two types of operations on the string in any sequence:

Type-1: Remove the character at the start of the string s and append it to the end of the string.
Type-2: Pick any character in s and flip its value, i.e., if its value is '0' it becomes '1' and vice-versa.
Return the minimum number of type-2 operations you need to perform such that s becomes alternating.

The string is called alternating if no two adjacent characters are equal.

For example, the strings "010" and "1010" are alternating, while the string "0100" is not.
'''
class Solution:
    def minFlips(self, s: str) -> int:
        n1 = len(s)
        s = s+s
        n = len(s)
        s1,s2 = "",""
        ans1,ans2,ans = 0,0,float('inf')
        for i in range(n):
            s1 += '0' if i % 2 else '1'
            s2 += '1' if i % 2 else '0'
        #print(s1)
        #print(s2)
        for i in range(n):
            if s1[i] != s[i]: ans1 += 1
            if s2[i] != s[i]: ans2 += 1
            if i >= n1:
                if s1[i - n1] != s[i - n1]:
                    ans1 -= 1
                if s2[i - n1] != s[i - n1]:
                    ans2 -= 1
            if i >= n1 - 1:
                ans = min(ans, ans1, ans2)
        return ans
            