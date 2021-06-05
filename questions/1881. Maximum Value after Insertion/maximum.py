'''
You are given a very large integer n, represented as a string,​​​​​​ and an integer digit x. The digits in n and the digit x are in the inclusive range [1, 9], and n may represent a negative number.

You want to maximize n's numerical value by inserting x anywhere in the decimal representation of n​​​​​​. You cannot insert x to the left of the negative sign.

For example, if n = 73 and x = 6, it would be best to insert it between 7 and 3, making n = 763.
If n = -55 and x = 2, it would be best to insert it before the first 5, making n = -255.
Return a string representing the maximum value of n​​​​​​ after the insertion.
'''
class Solution:
    def maxValue(self, n: str, x: int) -> str:
        sign = True
        if n[0] == '-': 
            sign = False
        if sign:
            for i in range(len(n)):
                if x > int(n[i]):
                    return n[:i] + str(x) + n[i:]
            return n + str(x)
        
        else:
            n = n[1:]
            for i in range(len(n)):
                if x < int(n[i]):
                    return "-" + n[:i] + str(x) + n[i:]
            return "-" + n + str(x)