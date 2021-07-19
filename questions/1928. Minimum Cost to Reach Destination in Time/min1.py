'''
There is a country of n cities numbered from 0 to n - 1 where all the cities are connected by bi-directional roads. The roads are represented as a 2D integer array edges where edges[i] = [xi, yi, timei] denotes a road between cities xi and yi that takes timei minutes to travel. There may be multiple roads of differing travel times connecting the same two cities, but no road connects a city to itself.

Each time you pass through a city, you must pay a passing fee. This is represented as a 0-indexed integer array passingFees of length n where passingFees[j] is the amount of dollars you must pay when you pass through city j.

In the beginning, you are at city 0 and want to reach city n - 1 in maxTime minutes or less. The cost of your journey is the summation of passing fees for each city that you passed through at some moment of your journey (including the source and destination cities).

Given maxTime, edges, and passingFees, return the minimum cost to complete your journey, or -1 if you cannot complete it within maxTime minutes.
'''
class Solution:
    def minCost(self, maxTime: int, edges: List[List[int]], pF: List[int]) -> int:
        n = len(pF)
        costs = [float('inf')]*n
        times = [float('inf')]*n
        costs[0] = pF[0]
        times[0] = 0
        pq = []
        heapq.heappush(pq, (0,costs[0],0))#t,c,v
        g = collections.defaultdict(list)
        for s,d,t in edges:
            g[s].append((d, t, pF[d]))
            g[d].append((s, t, pF[s]))
        
        while pq:
            t, c, v = heapq.heappop(pq)
            for nei,nei_t, nei_c in g[v]:
                #print(nei,nei_t,nei_c)
                if nei_t + t > maxTime:
                    continue
                if costs[nei] > c + nei_c:
                    costs[nei] = c + nei_c
                    heapq.heappush(pq, (nei_t + t, costs[nei], nei))
                elif times[nei] > t + nei_t:
                    times[nei] = t + nei_t
                    heapq.heappush(pq,(times[nei], nei_c + c, nei))
        return costs[n - 1] if costs[n-1] != float(inf) else -1
        