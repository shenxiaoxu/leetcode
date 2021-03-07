'''
Given an integer n, return true if it is possible to represent n as the sum of distinct powers of three. Otherwise, return false.

An integer y is a power of three if there exists an integer x such that y == 3x.
'''
class Solution:
    def checkPowersOfThree(self, n: int) -> bool:
        while n > 1 and n %3 != 2:
            if n % 3 == 0:
                n /= 3
            else:
                n -= 1
        return n == 1
        