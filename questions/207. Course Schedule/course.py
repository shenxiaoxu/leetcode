'''
There are a total of numCourses courses you have to take, labeled from 0 to numCourses - 1. You are given an array prerequisites where prerequisites[i] = [ai, bi] indicates that you must take course bi first if you want to take course ai.

For example, the pair [0, 1], indicates that to take course 0 you have to first take course 1.
Return true if you can finish all courses. Otherwise, return false.
'''
class Solution:
    def canFinish(self, n: int, prerequisites: List[List[int]]) -> bool:
        graph = collections.defaultdict(list)
        degree = [0]*n
        queue = collections.deque()
        res = []
        for i in range(len(prerequisites)):
            first, second = prerequisites[i][0], prerequisites[i][1]
            graph[second].append(first)    
            degree[first]+=1
        for i in range(n):
            if degree[i] == 0:
                queue.append(i)
        while queue:
            cur = queue.popleft()
            res.append(cur)
            if cur in graph:
                for nei in graph[cur]:
                    degree[nei] -= 1
                    if degree[nei] == 0:
                        queue.append(nei)
        return len(res) == n