'''
91. Decode Ways
Medium
A message containing letters from A-Z is being encoded to numbers using the following mapping:

'A' -> 1
'B' -> 2
...
'Z' -> 26
Given a non-empty string containing only digits, determine the total number of ways to decode it.

The answer is guaranteed to fit in a 32-bit integer.
'''
from functools import lru_cache
class Solution:
	@lru_cache
	def topdown(self, s:str)->int:
		if len(s) == 0:
			return 1
		if s[0] == '0':
			return 0
		res = self.topdown(s[1:])
		if len(s) >= 2 and (s[0] == '1' or (s[0] == '2' and s[1] < '7')):
			res += self.topdown(s[2:])
		return res
	def bottomup(self, s:str)->int:
		if len(s) == 0: return 0
		dp = [0]*(len(s)+1)
		dp[0] = 1
		for i in range(1, len(s) + 1):
			dp[i] = dp[i - 1] if s[i - 1] != '0' else 0
			if i >= 2 and (s[i - 2] == '1' or (s[i - 2] == '2' and s[i - 1] < '7')):
				dp[i] += dp[i - 2]
		return dp[len(s)]
if __name__ == "__main__":
	s = "226"
	o = Solution()
	print(o.topdown(s))
	print(o.bottomup(s))
	s = "206"
	print(o.topdown(s))
	print(o.bottomup(s))
	s = "0"
	print(o.topdown(s))
	print(o.bottomup(s))
	s = "1"	
	print(o.topdown(s))
	print(o.bottomup(s))


		