'''
977. Squares of a Sorted Array

Given an integer array nums sorted in non-decreasing order, return an array of the squares of each number sorted in non-decreasing order.

 

Example 1:

Input: nums = [-4,-1,0,3,10]
Output: [0,1,9,16,100]
Explanation: After squaring, the array becomes [16,1,0,9,100].
After sorting, it becomes [0,1,9,16,100].
'''
class Solution:
	def square(self, nums):
		start, end, p_res = 0, len(nums) - 1, len(nums) - 1
		res = [0]*len(nums)
		while start <= end:
			if abs(nums[start]) < abs(nums[end]):
				res[p_res] = pow(abs(nums[end]),2)
				end -= 1
			else:
				res[p_res] = pow(abs(nums[start]),2)
				start += 1
			p_res -= 1
		return res
if __name__ == "__main__":
	nums = [-4,-1,0,3,10]
	o = Solution()
	print(o.square(nums))