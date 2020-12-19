'''
334. Increasing Triplet Subsequence
Medium

Given an integer array nums, return true if there exists a triple of indices (i, j, k) 
such that i < j < k and nums[i] < nums[j] < nums[k]. If no such indices exists, return false.

 

Example 1:

Input: nums = [1,2,3,4,5]
Output: true
Explanation: Any triplet where i < j < k is valid.
'''
class Solution:
	def increasingTriplet(self, nums):
		dp = [1]*len(nums)
		for i in range(1,len(nums)):
			for j in range(0, i):
				if nums[i] > nums[j]:
					dp[i] = max(dp[i],dp[j] + 1)
					if dp[i] == 3:
						return True
		return False
	def increasingTripletTwo(self, nums):
		a, b = float('inf'), float('inf')
		for n in nums:
			if n <= a:
				a = n
			elif n <= b:
				b = n
			else:
				return True
		return False		
if __name__ == "__main__":
	nums = [1,2,3,4,5]
	nums1 = [1,2,3,1,2,1]
	o = Solution()
	print(o.increasingTriplet(nums))
	print(o.increasingTriplet(nums1))
	print(o.increasingTripletTwo(nums))
	print(o.increasingTripletTwo(nums1))		