'''
There is a country of n cities numbered from 0 to n - 1 where all the cities are connected by bi-directional roads. The roads are represented as a 2D integer array edges where edges[i] = [xi, yi, timei] denotes a road between cities xi and yi that takes timei minutes to travel. There may be multiple roads of differing travel times connecting the same two cities, but no road connects a city to itself.

Each time you pass through a city, you must pay a passing fee. This is represented as a 0-indexed integer array passingFees of length n where passingFees[j] is the amount of dollars you must pay when you pass through city j.

In the beginning, you are at city 0 and want to reach city n - 1 in maxTime minutes or less. The cost of your journey is the summation of passing fees for each city that you passed through at some moment of your journey (including the source and destination cities).

Given maxTime, edges, and passingFees, return the minimum cost to complete your journey, or -1 if you cannot complete it within maxTime minutes.
'''
class Solution:
    def minCost(self, maxTime: int, edges: List[List[int]], pF: List[int]) -> int:
        n = len(pF)
        g = collections.defaultdict(list)
        res = float('inf')
        for s,d,t in edges:
            g[s].append((d,t))
            g[d].append((s,t))
        
        def dfs(s, c, mask, cur_t):
            nonlocal n, res
            if c > res:
                return
            if s == n - 1:
                res = min(res, c)
                return
            for nei, t in g[s]:
                if mask & (1 << nei): continue
                if t + cur_t > maxTime: continue
                ori = mask
                mask |= 1 << nei
                c += pF[nei]
                dfs(nei, c, mask, t + cur_t)
                mask = ori
                c -= pF[nei]

        dfs(0, pF[0], 0, 0)
        return res if res != float('inf') else -1