'''
The Fibonacci numbers, commonly denoted F(n) form a sequence, called the Fibonacci sequence, 
such that each number is the sum of the two preceding ones, starting from 0 and 1. That is,

F(0) = 0, F(1) = 1
F(n) = F(n - 1) + F(n - 2), for n > 1.
Given n, calculate F(n).
'''

from functools import lru_cache
class Solution:
	def fib(self, n):
		@lru_cache
		def dfs(i):
			if i == 0:
				return 0
			if i == 1:
				return 1
			res = dfs(i - 1) + dfs(i - 2)
			return res
		return dfs(n)
if __name__ == "__main__":
	o = Solution()
	print(o.fib(6))
