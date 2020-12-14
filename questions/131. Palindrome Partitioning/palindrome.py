'''
Given a string s, partition s such that every substring of the partition is a palindrome. 
Return all possible palindrome partitioning of s.

A palindrome string is a string that reads the same backward as forward.

 

Example 1:

Input: s = "aab"
Output: [["a","a","b"],["aa","b"]]
'''
class Solution(object):
	def partition(self, s):
		res = []
		def dfs(string, path, res):
			if not string:
				return res.append(path)
			for i in range(1, len(string) + 1):
				word = string[:i]
				if self.check(word):
					dfs(string[i:], path + [word], res)
			return res

		dfs(s, [],res)
		return res
	def check(self, string):
		return string == string[::-1]
if __name__ == "__main__":
	s = "aab"
	s1 = "abba"
	o = Solution()
	print(o.palindrome(s))
	print(o.palindrome(s1))