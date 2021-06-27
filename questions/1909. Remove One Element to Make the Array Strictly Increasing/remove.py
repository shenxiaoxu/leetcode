'''
Given a 0-indexed integer array nums, return true if it can be made strictly increasing after removing exactly one element, or false otherwise. If the array is already strictly increasing, return true.

The array nums is strictly increasing if nums[i - 1] < nums[i] for each index (1 <= i < nums.length).
'''
class Solution:
    def canBeIncreasing(self, nums: List[int]) -> bool:
        for i in range(len(nums)):
            tmp = nums.copy()
            tmp.pop(i)
            so = True
            for j in range(1, len(tmp)):
                if tmp[j] <= tmp[j - 1]:
                    so = False
                    break
            if so:
                return True
        return False