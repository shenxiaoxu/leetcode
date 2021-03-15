'''
You are given an array of integers nums (0-indexed) and an integer k.

The score of a subarray (i, j) is defined as min(nums[i], nums[i+1], ..., nums[j]) * (j - i + 1). A good subarray is a subarray where i <= k <= j.

Return the maximum possible score of a good subarray.
'''
class Solution:
    def maximumScore(self, nums: List[int], k: int) -> int:
        res, min_num = nums[k], nums[k]
        start, end, n = k, k, len(nums)
        while start > 0 or end < n - 1:
            if (nums[start - 1] if start else 0) >= (nums[end + 1] if end < n - 1 else 0):
                start = start - 1
            else:
                end = end + 1
            min_num = min(min_num, nums[start], nums[end])
            res = max(res, min_num * (end - start + 1))
        return res