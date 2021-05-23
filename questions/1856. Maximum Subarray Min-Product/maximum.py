'''
The min-product of an array is equal to the minimum value in the array multiplied by the array's sum.

For example, the array [3,2,5] (minimum value is 2) has a min-product of 2 * (3+2+5) = 2 * 10 = 20.
Given an array of integers nums, return the maximum min-product of any non-empty subarray of nums. Since the answer may be large, return it modulo 109 + 7.

Note that the min-product should be maximized before performing the modulo operation. Testcases are generated such that the maximum min-product without modulo will fit in a 64-bit signed integer.

A subarray is a contiguous part of an array.
'''
class Solution:
    def maxSumMinProduct(self, nums: List[int]) -> int:
        presum = [0]*(len(nums)+1)
        res = 0
        for i in range(1, len(nums) + 1):
            presum[i] = presum[i - 1] + nums[i - 1]
        
        deque = collections.deque()
        deque.append(-1)
        for idx, num in enumerate(nums):
            while len(deque) > 1 and nums[idx] < nums[deque[-1]]:
                ele_idx = deque.pop()
                #print(ele_idx)
                res = max(res, (presum[idx] - presum[deque[-1] + 1])*nums[ele_idx])
                #print(res)
            deque.append(idx)
        
        while len(deque) > 1:
            ele_idx = deque.pop()
            #print(ele_idx)
            res = max(res, (presum[len(nums)] - presum[deque[-1] + 1])*nums[ele_idx])
            #print(res)
        return res%1000000007