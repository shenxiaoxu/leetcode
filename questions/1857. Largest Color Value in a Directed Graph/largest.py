'''
There is a directed graph of n colored nodes and m edges. The nodes are numbered from 0 to n - 1.

You are given a string colors where colors[i] is a lowercase English letter representing the color of the ith node in this graph (0-indexed). You are also given a 2D array edges where edges[j] = [aj, bj] indicates that there is a directed edge from node aj to node bj.

A valid path in the graph is a sequence of nodes x1 -> x2 -> x3 -> ... -> xk such that there is a directed edge from xi to xi+1 for every 1 <= i < k. The color value of the path is the number of nodes that are colored the most frequently occurring color along that path.

Return the largest color value of any valid path in the given graph, or -1 if the graph contains a cycle.
'''
class Solution:
    def largestPathValue(self, colors: str, edges: List[List[int]]) -> int:
        dict_map = collections.defaultdict(list)
        queue = collections.deque()
        degree_map = collections.defaultdict(int)
        color_info = [[0]*26 for _ in range(len(colors))]
        for edge in edges:
            dict_map[edge[0]].append(edge[1])
            degree_map[edge[1]] += 1
        
        for i in range(len(colors)):
            if degree_map[i] == 0:
                queue.append(i)
                color_info[i][ord(colors[i]) - ord('a')] = 1
        
        seen, ans = 0, 0
        while queue:
            
            node = queue.popleft()
                #print(color_info)
            ans = max(ans, max(color_info[node]))
            seen += 1
            for nei in dict_map[node]:
                for j in range(26):
                    color_info[nei][j] = max(color_info[nei][j], color_info[node][j] + (1 if j == (ord(colors[nei]) - ord('a')) else 0))
                degree_map[nei] -= 1
                if degree_map[nei] == 0:
                    queue.append(nei)
        
        return ans if seen == len(colors) else -1
                    
            
                
            
            
        
        
            