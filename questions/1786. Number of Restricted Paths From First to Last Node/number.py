'''
There is an undirected weighted connected graph. You are given a positive integer n which denotes that the graph has n nodes labeled from 1 to n, and an array edges where each edges[i] = [ui, vi, weighti] denotes that there is an edge between nodes ui and vi with weight equal to weighti.

A path from node start to node end is a sequence of nodes [z0, z1, z2, ..., zk] such that z0 = start and zk = end and there is an edge between zi and zi+1 where 0 <= i <= k-1.

The distance of a path is the sum of the weights on the edges of the path. Let distanceToLastNode(x) denote the shortest distance of a path between node n and node x. A restricted path is a path that also satisfies that distanceToLastNode(zi) > distanceToLastNode(zi+1) where 0 <= i <= k-1.

Return the number of restricted paths from node 1 to node n. Since that number may be too large, return it modulo 109 + 7.
'''
class Solution:
    def countRestrictedPaths(self, n: int, edges: List[List[int]]) -> int:
        if n == 1: return 0
        graph_dict = collections.defaultdict(list)
        lastnode_dis = [float('inf')]*(n+1)
        lastnode_dis[n] = 0 
        for u, v, w in edges:
            graph_dict[u].append((v, w))
            graph_dict[v].append((u, w))
        heap = [(0, n)]
        while heap:
            dis, cur = heappop(heap)
            if dis > lastnode_dis[cur]:
                continue
            for nei, dis in graph_dict[cur]:
                if lastnode_dis[nei] > lastnode_dis[cur] + dis:
                    lastnode_dis[nei] = lastnode_dis[cur] + dis
                    heappush(heap, (lastnode_dis[nei], nei))
        #print(lastnode_dis)
        @lru_cache(None)
        def dfs(src):
            if src == n:
                return 1
            ans = 0
            for v, _ in graph_dict[src]:
                if lastnode_dis[src] > lastnode_dis[v]:
                    ans = (ans + dfs(v))%1000000007
            return ans
        return dfs(1)