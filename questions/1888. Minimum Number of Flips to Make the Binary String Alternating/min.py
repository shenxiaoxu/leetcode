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
        def count(s):
            v1,v2,v3,v4 = 0,0,0,0
            for i in range(len(s)):
                if s[i] == '0':
                    if i % 2 ==0:
                        v1 += 1
                    else:
                        v2 += 1
                else:
                    if i % 2 == 0:
                        v3 += 1
                    else:
                        v4 += 1
            return [v1,v2,v3,v4]
        min_flip = float('inf')
        
        for i in range(len(s)):
            v1,v2,v3,v4 = count(s)
            #print((v1,v2,v3,v4))
            min_flip = min(min_flip, min(v1 + v4, v2 + v3))
            s = s[1:] + s[0]
        return min_flip
            