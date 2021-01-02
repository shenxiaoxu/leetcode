'''
You are given an array nums consisting of non-negative integers. You are also given a queries array, where queries[i] = [xi, mi].

The answer to the ith query is the maximum bitwise XOR value of xi and any element of nums that does not exceed mi. 
In other words, the answer is max(nums[j] XOR xi) for all j such that nums[j] <= mi. If all elements in nums are larger than mi, then the answer is -1.

Return an integer array answer where answer.length == queries.length and answer[i] is the answer to the ith query.
'''
from typing import List
class Trie:
	def __init__(self):
		self.root = {}
	def insert(self, val:int):
		p = self.root
		for i in range(31, -1, -1):
			cur = (val >> i)&1
			if cur not in p:
				p[cur] = {}
			p = p[cur]
	def query(self, num:int)->int:
		if not self.root:
			return -1
		p = self.root
		ans = 0
		for i in range(31, -1, -1):
			cur = (num >> i)&1
			if 1 - cur in p:
				ans |= (1<<i) 
				p = p[1 - cur]
			else:
				p = p[cur]
		return ans
class Solution:
	def maximum(self, nums:List[int], queries:List[int])->List[int]:
		ans = [-1]*len(queries)
		nums.sort()
		queries_n = sorted(enumerate(queries), key =lambda x: x[1][1])
		#print(queries_n[0][0])
		j = 0
		t = Trie()
		for i, (x,m) in queries_n:
			while j < len(nums) and nums[j] <= m:
				t.insert(nums[j])
				j += 1
			ans[i] = t.query(x)
		return ans
if __name__ == "__main__":
	nums = [5,2,4,6,6,3]
	queries = [[12,4],[8,1],[6,3]]
	o = Solution()
	print(o.maximum(nums, queries))

	