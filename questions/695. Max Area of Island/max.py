'''
Given a non-empty 2D array grid of 0's and 1's, an island is a group of 1's (representing land) connected 4-directionally (horizontal or vertical.) You may assume all four edges of the grid are surrounded by water.

Find the maximum area of an island in the given 2D array. (If there is no island, the maximum area is 0.)
'''
class Solution:
    def maxAreaOfIsland(self, grid: List[List[int]]) -> int:
        if not grid or not grid[0]:
            return 0
        m, n = len(grid), len(grid[0])
        visited = [[0]*n for _ in range(m)]
        max_area = 0
        
        def dfs(x,y):
            if x < 0 or x >= m or y < 0 or y >= n or visited[x][y] or (not grid[x][y]):
                return 0
            
            res = 1
            visited[x][y] = 1
            return res + dfs(x + 1, y) + dfs(x - 1, y) + dfs(x, y - 1) + dfs(x, y + 1)
        
        for i in range(m):
            for j in range(n):
                if (not visited[i][j]) and grid[i][j]:
                    max_area = max(max_area, dfs(i, j))
        return max_area
        