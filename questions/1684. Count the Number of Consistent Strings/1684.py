'''
You are given a string allowed consisting of distinct characters and an array of strings words. 
A string is consistent if all characters in the string appear in the string allowed.

Return the number of consistent strings in the array words.

 

Example 1:

Input: allowed = "ab", words = ["ad","bd","aaab","baa","badab"]
Output: 2
Explanation: Strings "aaab" and "baa" are consistent since they only contain characters 'a' and 'b'.
'''
class Solution(object):
	def allow(self, allowed, words):
		s, res = set(), 0
		for i in allowed:
			s.add(i)
		for word in words:
			appear = True
			for i in word:
				if i not in s:
					appear = False
					break
			if appear:
				res += 1
		return res
if __name__ == "__main__":
	allowed = "ab"
	words = ["ad","bd","aaab","baa","badab"]
	o = Solution()
	print(o.allow(allowed, words))