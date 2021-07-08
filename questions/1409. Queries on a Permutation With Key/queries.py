'''
Given the array queries of positive integers between 1 and m, you have to process all queries[i] (from i=0 to i=queries.length-1) according to the following rules:

In the beginning, you have the permutation P=[1,2,3,...,m].
For the current i, find the position of queries[i] in the permutation P (indexing from 0) and then move this at the beginning of the permutation P. Notice that the position of queries[i] in P is the result for queries[i].
Return an array containing the result for the given queries.
'''
class Fenwick:
    def __init__(self, n):
        sz = 1
        while sz <= n:
            sz *= 2
        self.size = sz
        self.data = [0]*sz
    
    def add(self, i, x):
        while i < self.size:
            self.data[i] += x
            i += i&-i
            
    def sum(self, i):
        s = 0
        while i > 0:            
            s += self.data[i]
            i -= i &-i
        return s

class Solution:
    def processQueries(self, queries: List[int], m: int) -> List[int]:
        fenw = Fenwick(2*m)
        vmap = {}
        ans = []
        for i in range(1, m + 1):
            fenw.add(i + m, 1)
            vmap[i] = i + m
        cur = m
        for q in queries:
            i = vmap.pop(q)
            rank = fenw.sum(i - 1)
            ans.append(rank)
            vmap[q] = cur
            fenw.add(i, -1)
            fenw.add(cur, 1)
            cur -= 1
        
        return ans
        