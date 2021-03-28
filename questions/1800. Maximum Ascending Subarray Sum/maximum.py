'''
Given an array of positive integers nums, return the maximum possible sum of an ascending subarray in nums.

A subarray is defined as a contiguous sequence of numbers in an array.

A subarray [numsl, numsl+1, ..., numsr-1, numsr] is ascending if for all i where l <= i < r, numsi < numsi+1. Note that a subarray of size 1 is ascending.
'''
class Solution:
    def maxAscendingSum(self, nums: List[int]) -> int:
        if not nums:
            return 0
        res, res_max = nums[0], nums[0]
        for i in range(len(nums) - 1):
            if nums[i + 1] > nums[i]:
                res += nums[i + 1]
            else:           
                res = nums[i + 1]
            res_max = max(res, res_max)
        res_max = max(res_max, nums[-1])
        return res_max