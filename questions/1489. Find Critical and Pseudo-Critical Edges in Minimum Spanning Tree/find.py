'''
Given a weighted undirected connected graph with n vertices numbered from 0 to n - 1, and an array edges where edges[i] = [ai, bi, weighti] represents a bidirectional and weighted edge between nodes ai and bi. A minimum spanning tree (MST) is a subset of the graph's edges that connects all vertices without cycles and with the minimum possible total edge weight.

Find all the critical and pseudo-critical edges in the given graph's minimum spanning tree (MST). An MST edge whose deletion from the graph would cause the MST weight to increase is called a critical edge. On the other hand, a pseudo-critical edge is that which can appear in some MSTs but not all.

Note that you can return the indices of the edges in any order.
'''
class UnionFind:
    def __init__(self,n):
        self.p = [0]*n
        for i in range(n):
            self.p[i] = i
    def find(self, x):
        if self.p[x] != x:
            self.p[x] = self.find(self.p[x])
        return self.p[x]
    def union(self, x, y):
        px = self.find(x)
        py = self.find(y)
        self.p[px] = py
        
class Solution:
    
    def findCriticalAndPseudoCriticalEdges(self, n: int, edges: List[List[int]]) -> List[List[int]]:
        critical = []
        noncritical = []
        for i in range(len(edges)):
            edges[i].append(i)
        
        edges = [(w, s, e, p) for s,e,w,p in edges]
        edges.sort()
        
        def kruskal(edges, blockedge, preedge):
            
            uf = UnionFind(n)
            res = 0
            if preedge != -1:
                res += edges[preedge][0]
                uf.union(edges[preedge][1], edges[preedge][2])
                
            for i, (w, s, e, p) in enumerate(edges):
                if i == blockedge: continue
                ps = uf.find(s)
                pe = uf.find(e)
                if ps != pe:
                    uf.union(s, e)
                    res += w
                    
            for i in range(n):
                if uf.find(i) != uf.find(0): return 1000000007
            
            return res
        original = kruskal(edges, -1, -1)
        #print(original)
        for i, edge in enumerate(edges):
            #print(change)
            if kruskal(edges, i, -1) > original:
                critical.append(edge[3])
            elif kruskal(edges, -1, i) == original:
                noncritical.append(edge[3])
        
        return [critical, noncritical]
        