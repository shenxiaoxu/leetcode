'''
Given an integer array nums (0-indexed) and two integers target and start, find an index i such that nums[i] == target and abs(i - start) is minimized. Note that abs(x) is the absolute value of x.

Return abs(i - start).

It is guaranteed that target exists in nums.
'''
class Solution:
    def getMinDistance(self, nums: List[int], target: int, start: int) -> int:
        
        n = len(nums)
        dis = max(n - start, start)
        for i in range(dis + 1):
            if start - i >= 0 and nums[start - i] == target:
                return i
            if start + i < n and nums[start + i] == target:
                return i
        return -1