'''
There are n unique candies (labeled 1 through n) and k bags. 
You are asked to distribute all the candies into the bags such that every bag has at least one candy.

There can be multiple ways to distribute the candies. Two ways are considered different 
if the candies in one bag in the first way are not all in the same bag in the second way. 
The order of the bags and the order of the candies within each bag do not matter.

For example, (1), (2,3) and (2), (1,3) are considered different because candies 2 and 3 in the bag (2,3) in the first way are not in the same bag 
in the second way (they are split between the bags (2) and (1,3)). However, (1), (2,3) and (3,2), (1) are considered the same 
because the candies in each bag are all in the same bags in both ways.

Given two integers, n and k, return the number of different ways to distribute the candies. As the answer may be too large, return it modulo 109 + 7.
'''
from functools import lru_cache
class Solution:
	def count(self, n:int, k:int)->int:
		mod = 10**9 + 7
		@lru_cache(None)
		def dfs(n, k):
			if  n == 0 or k == 0:
				return 0
			if k == n:
				return 1
			return (k*dfs(n - 1, k) + dfs(n - 1, k - 1))%mod
		return dfs(n, k)
	
	def countTwo(self, n:int, k:int)->int:
		dp = [[0]* (n + 1)for _ in range(k + 1)]
		mod = 10**9 + 7
		for i in range(k + 1):
			dp[i][i] = 1
		for i in range(1, k + 1):
			for j in range(i + 1, n + 1):
				dp[i][j] = (i * dp[i][j - 1] + dp[i - 1][j - 1])%mod
		return dp[k][n]

if __name__ == "__main__":
	o = Solution()
	print(o.count(4,2))
	print(o.countTwo(4,2))
