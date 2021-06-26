'''
Given an undirected tree consisting of n vertices numbered from 0 to n-1, which has some apples in their vertices. You spend 1 second to walk over one edge of the tree. Return the minimum time in seconds you have to spend to collect all apples in the tree, starting at vertex 0 and coming back to this vertex.

The edges of the undirected tree are given in the array edges, where edges[i] = [ai, bi] means that exists an edge connecting the vertices ai and bi. Additionally, there is a boolean array hasApple, where hasApple[i] = true means that vertex i has an apple; otherwise, it does not have any apple.
'''
class Solution:
    def minTime(self, n: int, edges: List[List[int]], hasApple: List[bool]) -> int:
        graph = collections.defaultdict(list)
        for e in edges:
            graph[e[0]].append(e[1])
            graph[e[1]].append(e[0])
        def dfs(node, pre):
            f_dis = 0
            f_e = hasApple[node]
            for nei in graph[node]:
                if nei == pre: continue
                subdis, exist = dfs(nei, node)
                f_e = f_e or exist
                f_dis += subdis
            return [f_dis + 2,f_e] if f_e else [0,0]
        res = dfs(0,-1)
        return res[0] - 2 if res[1] else 0
                