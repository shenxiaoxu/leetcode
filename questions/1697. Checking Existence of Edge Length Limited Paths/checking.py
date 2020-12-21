'''
An undirected graph of n nodes is defined by edgeList, where edgeList[i] = [ui, vi, disi] denotes an edge between nodes ui and vi with distance disi. 
Note that there may be multiple edges between two nodes.

Given an array queries, where queries[j] = [pj, qj, limitj], your task is to determine for each queries[j] whether 
there is a path between pj and qj such that each edge on the path has a distance strictly less than limitj .

Return a boolean array answer, where answer.length == queries.length and the jth value of answer is true if there is a path for queries[j] is true, 
and false otherwise.
'''
class UnionFind:
	def __init__(self, n):
		self.p = [0]*n
		for i in range(n):
			self.p[i] = i
	def find(self,x):
		if self.p[x] != x:
			self.p[x] = self.find(self.p[x])
		return self.p[x]
	def union(self, x, y):
		px = self.find(x)
		py = self.find(y)
		self.p[px] = py
	
class Solution:
	def checking(self, n, edgeList, queries):
		uf = UnionFind(n)
		edgeList = sorted((w, u, v) for u, v, w in edgeList)
		queries = sorted((w, u, v, i) for i, (u, v, w) in enumerate(queries))
		res = [0]*len(queries)
		ii = 0
		for w, u, v, i in queries:
			while ii < len(edgeList) and  edgeList[ii][0] < w:
				uf.union(edgeList[ii][1], edgeList[ii][2])
				ii += 1
			res[i] = uf.find(u) == uf.find(v)
		return res
if __name__ == "__main__":
	o = Solution()
	edgeList1 = [[0,1,2],[1,2,4],[2,0,8],[1,0,16]]
	queries1 = [[0,1,2],[0,2,5]]
	print(o.checking(edgeList1, 3, queries1))










