'''
50. Pow(x, n)
Implement pow(x, n), which calculates x raised to the power n (i.e. xn).

 

Example 1:

Input: x = 2.00000, n = 10
Output: 1024.00000
'''
from functools import lru_cache
class Solution:
	def pow(self, x, n):
		if n == 0: return 1
		if x == 0: return 0
		signx = 1 if x > 0 else -1# 1 means postive, -1 means negative
		signn = 1 if n > 0 else -1# 1 means postive, -1 means negative
		@lru_cache#don't need lru_cache
		def dfs(x, n):
			if n == 1:
				return x
			res = dfs(x, n//2)*dfs(x, n//2)#don't use dfs twice, store in temp value
			return res*x if n%2==1 else res
		res = dfs(abs(x), abs(n))
		if signx == 1:#don't need to record signx, because x if n times.
			if signn == 1:
				return res
			else:
				return 1/res
		else:
			if signn == 1:
				return -res if n % 2 == 1 else res
			else:
				return -1/res if n % 2== 1 else 1/res
	def powOptimize(self, x, n):
		if not n:
			return 1
		if n < 0:
			return 1/self.powOptimize(x,-n)
		if n%2:
			return x*self.powOptimize(x, n - 1)
		return self.powOptimize(x*x, n/2)
if __name__ == "__main__":
	o = Solution()
	print(o.pow(2, 10))
	print(o.pow(-2, 10))
	print(o.pow(-2, -10))
	print(o.pow(2, -10))
	print(o.powOptimize(2, 10))
	print(o.powOptimize(-2, 10))
	print(o.powOptimize(-2, -10))
	print(o.powOptimize(2, -10))