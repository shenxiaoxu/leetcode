'''
The frequency of an element is the number of times it occurs in an array.

You are given an integer array nums and an integer k. In one operation, you can choose an index of nums and increment the element at that index by 1.

Return the maximum possible frequency of an element after performing at most k operations.
'''
class Solution:
    def maxFrequency(self, nums: List[int], k: int) -> int:
        nums.sort()
        max_freq = 0
        res = 0
        for i in range(len(nums)):
            count = k
            idx = i - 1
            freq = 1
            while count > 0 and idx >= 0:
                count -= nums[i] - nums[idx]
                if count >= 0:
                    freq += 1
                    idx -= 1
            res = max(res, freq)
        return res