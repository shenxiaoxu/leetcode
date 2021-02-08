'''
You are given an integer array nums. The absolute sum of a subarray [numsl, numsl+1, ..., numsr-1, numsr] is abs(numsl + numsl+1 + ... + numsr-1 + numsr).

Return the maximum absolute sum of any (possibly empty) subarray of nums.

Note that abs(x) is defined as follows:

If x is a negative integer, then abs(x) = -x.
If x is a non-negative integer, then abs(x) = x.
'''
class Solution:
    def maxAbsoluteSum(self, nums: List[int]) -> int:
        max_add, min_add = 0,0
        local_max, local_min = 0, 0
        for i in range(len(nums)):
            local_max += nums[i]
            if local_max > 0:
                max_add = max(max_add, local_max)
            else:
                local_max = 0
        for i in range(len(nums)):
            local_min += nums[i]
            if local_min < 0:
                min_add = min(min_add, local_min)
            else:
                local_min = 0
        return max(abs(min_add), max_add)