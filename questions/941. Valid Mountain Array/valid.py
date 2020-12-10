'''
941. Valid Mountain Array
Given an array of integers arr, return true if and only if it is a valid mountain array.

Recall that arr is a mountain array if and only if:

arr.length >= 3
There exists some i with 0 < i < arr.length - 1 such that:
arr[0] < arr[1] < ... < arr[i - 1] < A[i]
arr[i] > arr[i + 1] > ... > arr[arr.length - 1]
'''
class Solution(object):
	def valid(self, nums):
		if len(nums) < 3:
			return False
		i, j = 0, len(nums) - 1
		while i < j and nums[i + 1] > nums[i]:
			i += 1
		while j > i and nums[j - 1] > nums[j]:
			j -= 1
		return i== j and i != 0 and j != len(nums) - 1
if __name__ == "__main__":
	nums = [1,3,5,7,9,7,5,4,3,1]
	nums1 = [1,3,5,7,9]
	nums2 = [9,7,5,4,3,1]
	o = Solution()
	print(o.valid(nums))
	print(o.valid(nums1))
	print(o.valid(nums2))
