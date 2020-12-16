'''
34. Find First and Last Position of Element in Sorted Array
Medium

Given an array of integers nums sorted in ascending order, find the starting and ending position of a given target value.

If target is not found in the array, return [-1, -1].

Follow up: Could you write an algorithm with O(log n) runtime complexity?
'''
class Solution:
	def find(self, nums, target):
		start, end = 0, len(nums) - 1

		while start < end:
			mid = start + (end - start)//2
			if nums[mid] < target:
				start = mid + 1
			else:
				end = mid
		s = start
		if s == len(nums) or nums[s] != target: 
			return [-1,-1]
		start, end = 0, len(nums) - 1
		while start < end:
			mid = start + (end - start)//2
			if nums[mid] <= target:
				start = mid + 1
			else:
				end = mid
		e = start - 1 if nums[start] != target else start
		return [s,e]
	def findTwo(self, nums, target):
		start, end, res = 0, len(nums) - 1,[-1,-1]
		if len(nums) == 0: return res
		while start < end:
			mid = start + (end - start)//2
			if nums[mid] < target:
				start = mid + 1
			else:
				end = mid
		
		if nums[start] != target: 
			return res
		res[0] = start
		end = len(nums) - 1
		while start < end:
			mid = start + (end - start)//2 + 1
			if nums[mid] > target:
				end = mid - 1
			else:
				start = mid
		res[1] = end
		return res		
if __name__ == "__main__":
	nums1 = [7,7,7,7,7]
	o = Solution()
	print(o.find(nums1, 7))
	nums2 = [1,1,7,7,7,7,7,8]
	print(o.find(nums2, 7))	
	print(o.findTwo(nums1, 7))	
	print(o.findTwo(nums2, 7))	

