'''
There is a rooted tree consisting of n nodes numbered 0 to n - 1. Each node's number denotes its unique genetic value (i.e. the genetic value of node x is x). The genetic difference between two genetic values is defined as the bitwise-XOR of their values. You are given the integer array parents, where parents[i] is the parent for node i. If node x is the root of the tree, then parents[x] == -1.

You are also given the array queries where queries[i] = [nodei, vali]. For each query i, find the maximum genetic difference between vali and pi, where pi is the genetic value of any node that is on the path between nodei and the root (including nodei and the root). More formally, you want to maximize vali XOR pi.

Return an array ans where ans[i] is the answer to the ith query.
'''
class TrieNode:
    def __init__(self):
        self.children = {}
        self.go = 0#num of ele going through this node
    def increase(self, number, d):
        cur = self
        for i in range(17,-1,-1):
            bit = (number >> i)&1
            if bit not in cur.children: cur.children[bit] = TrieNode()
            cur = cur.children[bit]
            cur.go += d
    def getMax(self, number):
        cur = self
        ans = 0
        for i in range(17,-1,-1):
            bit = (number >> i)&1
            if 1 - bit in cur.children and cur.children[1-bit].go > 0:
                cur = cur.children[1 - bit]
                ans = (1 << i)|ans
            else:
                cur = cur.children[bit]
        return ans
    
class Solution:
    def maxGeneticDifference(self, parents: List[int], queries: List[List[int]]) -> List[int]:
        n = len(parents)
        m = len(queries)
        res = [0]*m
        graph = [[] for _ in range(n)]
        queryByNode = [[] for _ in range(n)]
        root = -1
        trieNode = TrieNode()
        for i, p in enumerate(parents):
            if p == -1: 
                root = i
            else:
                graph[p].append(i)
        for i, q in enumerate(queries):
            queryByNode[q[0]].append([q[1], i])
            
        def dfs(u):
            trieNode.increase(u, 1)
            for val, idx in queryByNode[u]:
                res[idx] = trieNode.getMax(val)
            for v in graph[u]:
                dfs(v)
            trieNode.increase(u, -1)
        dfs(root)
        return res    
            
            
            
        