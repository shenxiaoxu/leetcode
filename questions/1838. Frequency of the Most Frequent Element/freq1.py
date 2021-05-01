class Solution:
    def maxFrequency(self, nums: List[int], k: int) -> int:
        nums.sort()
        i, j = 0, 0
        res = 0
        sum_num = 0
        for i in range(len(nums)):
            sum_num += nums[i]
            while j <= i and sum_num + k < (i - j + 1)*nums[i]:
                sum_num -= nums[j]
                j += 1
            res = max(res, i - j + 1)
        return res