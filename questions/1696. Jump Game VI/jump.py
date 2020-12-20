'''
You are given a 0-indexed integer array nums and an integer k.

You are initially standing at index 0. In one move, you can jump at most k steps forward without going outside the boundaries of the array. 
That is, you can jump from index i to any index in the range [i + 1, min(n - 1, i + k)] inclusive.

You want to reach the last index of the array (index n - 1). Your score is the sum of all nums[j] for each index j you visited in the array.

Return the maximum score you can get.
'''
import collections
class Solution:
	def jump(self, nums, k):
		dp = [nums[0]] + [-float('inf')]*(len(nums)-1)
		for i in range(0, len(nums)):
			for j in range(1, k + 1):
				if i + j < len(nums):
					dp[i + j] = max(dp[i + j], dp[i] + nums[i + j])
		#print(dp)
		return dp[len(nums) - 1]
	def jump1(self, nums, k):
		q = collections.deque()
		for i in range(len(nums)):
			max = nums[q[0]] if q else 0
			nums[i] = nums[i] + max
			while q and nums[q[-1]] < nums[i]:
				q.pop()
			q.append(i)
			if i - q[0] + 1 > k:
				q.popleft()
		return nums[len(nums) - 1]

if __name__ == "__main__":
	nums = [10,-5,-2,4,0,3]
	nums1 = [1,-1,-2,4,-7,3]
	nums2 = [1,-5,-20,4,-1,3,-6,-3]
	o = Solution()
	print(o.jump1(nums, 3))
	print(o.jump1(nums1, 2))
	print(o.jump1(nums2, 2))