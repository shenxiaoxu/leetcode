'''
140. Word Break II

Given a non-empty string s and a dictionary wordDict containing a list of non-empty words, 
add spaces in s to construct a sentence where each word is a valid dictionary word. Return all such possible sentences.

Note:

The same word in the dictionary may be reused multiple times in the segmentation.
You may assume the dictionary does not contain duplicate words.
Example 1:

Input:
s = "catsanddog"
wordDict = ["cat", "cats", "and", "sand", "dog"]
Output:
[
  "cats and dog",
  "cat sand dog"
]
'''
from functools import lru_cache
class Solution(object):
	def wordbreak(self, s, wordDict):
		wordset = set(wordDict)
		result = []
		def dfs(s, path, result):
			if not s:
				sub = " ".join(path)
				result.append(sub)
				return
			for i in range(1, len(s) + 1):
				word = s[:i]
				if word in wordset:
					path.append(word)
					dfs(s[i:], path, result)
					path.pop()
		dfs(s, [], result)
		return result
	def wordbreakOne(self, s, wordDict):
		def dfs(string, memo, wordDict):
			if string in memo:
				return memo[string]
			if not string:
				return []
			res = []
			for word in wordDict:
				if not string.startswith(word):
					continue
				if len(word) == len(string):
					res.append(word)
				else:
					nextLevel = dfs(string[len(word):], memo, wordDict)
					for sub in nextLevel:
						res.append(word + " " + sub)
			memo[string] = res
			return res
		return dfs(s, {}, wordDict)
	def wordbreakTwo(self, s, wordDict):
		@lru_cache
		
		def dfs(i):
			res = []
			for word in wordDict:
				if s[i:i + len(word)] != word:
					continue
				elif len(word) == len(s[i:]):
					res.append(word)
				else:
					for sub in dfs(i + len(word)):
						res.append(word + " " + sub)
			return res
		return dfs(0)

if __name__ == "__main__":
	s = "catsanddog"
	wordDict = ["cat", "cats", "and", "sand", "dog"]
	o = Solution()
	print(o.wordbreak(s, wordDict))
	print(o.wordbreakOne(s, wordDict))
	print(o.wordbreakTwo(s, wordDict))






