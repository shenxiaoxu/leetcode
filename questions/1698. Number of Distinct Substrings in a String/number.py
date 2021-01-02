'''
Given a string s, return the number of distinct substrings of s.

A substring of a string is obtained by deleting any number of characters (possibly zero) from 
the front of the string and any number (possibly zero) from the back of the string.
'''
class Node:
	def __init__(self, val = ""):
		self.val = val
		self.children = {}
class Solution:
	def number(self, s:str)->int:
		root = Node(-1)
		res = 0
		for i in range(len(s)):
			node = root
			for j in range(i, len(s)):
				if s[j] not in node.children:
					node.children[s[j]] = Node(s[j])
					res += 1
				node = node.children[s[j]]
		return res
	def rolling(self, s:str)->int:
		unique_set = set()
		hash_val,base,res = 0, 1, 0
		for i in range(len(s)):
			hash_val = hash_val + ord(s[i])*base
			res += 1
			unique_set.add(hash_val)
			base = base * 26
			val = hash_val
			for j in range(0, i):
				val = (val - ord(s[j]))//26
				if val not in unique_set:
					unique_set.add(val)
					res += 1
		return res


if __name__ == "__main__":
	s = "aabbaba"
	o = Solution()
	print(o.number(s))
	print(o.rolling(s))
	s = "abcdefg"
	print(o.number(s))
	print(o.rolling(s))

