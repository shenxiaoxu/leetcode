 # coding: utf-8
'''
1681. Minimum Incompatibility

You are given an integer array nums​​​ and an integer k. You are asked to distribute this array into k subsets of equal size 
such that there are no two equal elements in the same subset.

A subset's incompatibility is the difference between the maximum and minimum elements in that array.

Return the minimum possible sum of incompatibilities of the k subsets after distributing the array optimally, or return -1 if it is not possible.

A subset is a group integers that appear in the array with no particular order.

 

Example 1:

Input: nums = [1,2,1,4], k = 2
Output: 4
Explanation: The optimal distribution of subsets is [1,2] and [1,4].
The incompatibility is (2-1) + (4-1) = 4.
Note that [1,1] and [2,4] would result in a smaller sum, but the first subset contains 2 equal elements.
'''
from itertools import permutations
from itertools import combinations

class Solution(object):
	def minimumIncompatibility(self, nums, x):
		if x == len(nums): return 0
		nums.sort()
		n = len(nums)
		dp = [[float('inf')]*n for _ in range(1<<n)]
		for i in range(n):
			dp[1<<i][i] = 0
		for mask in range(1<<n):
			p_bit = [len(bin(mask)) - p - 1 for p, c in enumerate(bin(mask)) if c == "1"]
			print(p_bit)
			if len(p_bit)%(n//x) == 1:
				for k, l in permutations(p_bit, 2):
					dp[mask][k] = min(dp[mask][k], dp[mask ^ (1 << k)][l])
			else:
				for k, l in combinations(p_bit, 2):
					if nums[k] != nums[l]:
						dp[mask][k] = min(dp[mask][k], dp[mask ^ (1 << k)][l] + nums[k] - nums[l])
		print(dp)
		return min(dp[-1]) if min(dp[-1]) != float('inf') else -1
if __name__ == "__main__":
	nums = [1,2]
	k = 2
	o = Solution()
	print(o.min(nums, k))		

'''
l = [3,2,1]
l2 = [[3,2,1],[1,2,3]]
l.sort()
p = permutations(l,2)
c = combinations(l, 2)
print(list(c))
print(l2[-1])
'''
