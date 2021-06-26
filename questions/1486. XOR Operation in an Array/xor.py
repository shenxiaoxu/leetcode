'''
Given an integer n and an integer start.

Define an array nums where nums[i] = start + 2*i (0-indexed) and n == nums.length.

Return the bitwise XOR of all elements of nums.
'''
class Solution:
    def xorOperation(self, n: int, start: int) -> int:
        res = start
        while n - 1:
            start += 2
            res = res^start
            n -=1
        return res