'''
Given an integer n (in base 10) and a base k, return the sum of the digits of n after converting n from base 10 to base k.

After converting, each digit should be interpreted as a base 10 number, and the sum should be returned in base 10.
'''
class Solution:
    def sumBase(self, n: int, k: int) -> int:
        res = ""
        while n:
            count = 0
            tmp = 1
            while tmp <= n:
                tmp = (k**count)
                count += 1
            tmp /= k
            divisor = n//tmp
            n -= divisor*tmp
            res += str(int(divisor))
        
        #print(res)
        return sum(int(i) for i in res)
