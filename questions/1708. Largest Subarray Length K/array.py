'''
An array A is larger than some array B if for the first index i where A[i] != B[i], A[i] > B[i].

For example, consider 0-indexing:

[1,3,2,4] > [1,2,2,4], since at index 1, 3 > 2.
[1,4,4,4] < [2,1,1,1], since at index 0, 1 < 2.
A subarray is a contiguous subsequence of the array.

Given an integer array nums of distinct integers, return the largest subarray of nums of length k.
'''
from typing import List
class Solution:
	def distinct(self, nums: List[int], k:int)->List[int]:
		res = None
		for i in range(len(nums) - k + 1):
			if res and self.check(res, nums[i: i + k]):
				continue
			res = nums[i: i + k]
		return res
	def check(self, res: List[int], nums: List[int]):
		for i in range(len(res)):
			if res[i] > nums[i]:
				return True
			elif res[i] < nums[i]:
				return False
		return False
	def distinctTwo(self, nums: List[int], k:int)->List[int]:
		idx, max_v = 0, float('-inf')
		for i in range(len(nums) - k + 1):
			if nums[i] > max_v:
				max_v = nums[i]
				idx = i
		return nums[idx: idx + k]
	def distinctThree(self, nums: List[int], k:int)->List[int]:
		i, j, d, n = 0, 1, 0, len(nums)
		while j + k - 1 < n:
			if nums[i + d] == nums[j + d] and d < k:
				d += 1
				continue
			if nums[i + d] < nums[j + d]:
				i = max(i + d + 1, j)
				j = i + 1
			else:
				j = j + d + 1
			d = 0
		return nums[i: i + k]

if __name__ == "__main__":
	nums = [1,3,2,4]
	o = Solution()
	print(o.distinct(nums, 2))
	print(o.distinctTwo(nums, 2))
	nums = [1,3,3,2,2,4,3,2]
	print(o.distinct(nums, 2))
	print(o.distinctThree(nums, 2))
