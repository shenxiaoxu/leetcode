# -*- coding: utf-8 -*-
'''
312. Burst Balloons

Given n balloons, indexed from 0 to n-1. Each balloon is painted with a number on it represented by array nums. You are asked to burst all the balloons. 
If the you burst balloon i you will get nums[left] * nums[i] * nums[right] coins. Here left and right are adjacent indices of i.
 After the burst, the left and right then becomes adjacent.

Find the maximum coins you can collect by bursting the balloons wisely.

Note:

You may imagine nums[-1] = nums[n] = 1. They are not real therefore you can not burst them.
0 ≤ n ≤ 500, 0 ≤ nums[i] ≤ 100
Example:

Input: [3,1,5,8]
Output: 167 
Explanation: nums = [3,1,5,8] --> [3,5,8] -->   [3,8]   -->  [8]  --> []
             coins =  3*1*5      +  3*5*8    +  1*3*8      + 1*8*1   = 167
'''
class Solution(object):
	def burst(self, nums):
		new_nums = [1]*(len(nums) + 2)
		n = 1
		for i in nums:
			if i > 0:
				new_nums[n] = i
				n += 1
		n += 1
		#print(n)
		memo = [[0]*n for _ in range(n)]
		#print(memo)
		def dfs(new_nums, left, right, memo):

			if left + 1 == right:
				return 0
			if memo[left][right] > 0:
				return memo[left][right]
			ans = 0
			for i in range(left + 1, right):
				ans = max(ans, new_nums[i] * new_nums[left] * new_nums[right] + dfs(new_nums, left, i, memo) + dfs(new_nums, i, right, memo))
			memo[left][right] = ans
			
			return ans
		res = dfs(new_nums, 0, n - 1, memo)
		return res
if __name__ == "__main__":
	nums = [3,1,5,8]
	o = Solution()
	print(o.burst(nums))
