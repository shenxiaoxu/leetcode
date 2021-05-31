'''
Given a binary string s, return the minimum number of character swaps to make it alternating, or -1 if it is impossible.

The string is called alternating if no two adjacent characters are equal. For example, the strings "010" and "1010" are alternating, while the string "0100" is not.

Any two characters may be swapped, even if they are not adjacent.
'''
class Solution:
    def minSwaps(self, s: str) -> int:
        num0, num1 = 0, 0
        for i in range(len(s)):
            if s[i] == '0':
                num0 += 1
            else:
                num1 += 1
        if abs(num0 - num1) > 1:
            return -1
        
        s1 = ['10']*(min(num0,num1))
        str1 = ''.join(s1)
        s2 = ['01']*(min(num0,num1))
        str2 = ''.join(s2)
        
        if num0 > num1:
            str2 += '0'
        if num1 > num0:
            str1 += '1'
        
        strf = str1 if len(str1) > len(str2) else str2
        
        if len(str1) == len(str2):
            diff1, diff2 = 0, 0
            for i in range(len(str1)):
                if s[i] != str1[i]:
                    diff1 += 1
                if s[i] != str2[i]:
                    diff2 += 1
            return min(diff1, diff2)//2
        else:
            diff1 = 0
            for i in range(len(strf)):
                if s[i] != strf[i]:
                    diff1 += 1
                
            return diff1//2            
            