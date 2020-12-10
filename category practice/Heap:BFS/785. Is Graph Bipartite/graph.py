'''
785. Is Graph Bipartite?

Given an undirected graph, return true if and only if it is bipartite.

Recall that a graph is bipartite if we can split its set of nodes into two independent subsets A and B, 
such that every edge in the graph has one node in A and another node in B.

The graph is given in the following form: graph[i] is a list of indexes j for which the edge between nodes i and j exists.  
Each node is an integer between 0 and graph.length - 1.  
There are no self edges or parallel edges: graph[i] does not contain i, and it doesn't contain any element twice.
'''
import collections
class Solution(object):
	def isBipartite(self, graph):
		q = collections.deque()
		v = [-1]*len(graph)
		
		for idx in range(len(graph)):
			if v[idx]== -1 and len(graph[idx]) != 0:
				q.append((idx, 0))
			while len(q):
				s = len(q)
				for i in range(s):
					node, status = q.popleft()
					for nei in graph[node]:
						if v[nei] == -1:
							opposite = 1 if status == 0 else 0
							q.append((nei, opposite))
							v[nei] = opposite
						elif v[nei] == status:
							return False

		return True
if __name__ == "__main__":
	graph = [[],[2,4,6],[1,4,8,9],[7,8],[1,2,8,9],[6,9],[1,5,7,8,9],[3,6,9],[2,3,4,6,9],[2,4,5,6,7,8]]
	graph1 = [[4],[],[4],[4],[0,2,3]]
	graph2 = [[2,4],[2,3,4],[0,1],[1],[0,1],[7],[9],[5],[],[6],[12,14],[],[10],[],[10],[19],[18],[],[16],[15],[23],[23],[],[20,21],[],[],[27],[26],[],[],[34],[33,34],[],[31],[30,31],[38,39],[37,38,39],[36],[35,36],[35,36],[43],[],[],[40],[],[49],[47,48,49],[46,48,49],[46,47,49],[45,46,47,48]]
	o = Solution()
	print(o.isBipartite(graph))
	print(o.isBipartite(graph1))
	print(o.isBipartite(graph2))
