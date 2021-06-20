'''
You are given two m x n binary matrices grid1 and grid2 containing only 0's (representing water) and 1's (representing land). An island is a group of 1's connected 4-directionally (horizontal or vertical). Any cells outside of the grid are considered water cells.

An island in grid2 is considered a sub-island if there is an island in grid1 that contains all the cells that make up this island in grid2.

Return the number of islands in grid2 that are considered sub-islands.
'''
class Solution:
    def countSubIslands(self, B: List[List[int]], A: List[List[int]]) -> int:
        m, n = len(A), len(A[0])
        def dfs(i, j):
            if not (0<=i < m and 0<=j < n and A[i][j] == 1): return 1
            res = B[i][j]
            A[i][j] = 0
            for di, dj in [[0,1],[1,0],[0,-1],[-1,0]]:
                res &= dfs(di + i, dj + j)
            return res
        return sum(dfs(i, j) for i in range(m) for j in range(n) if A[i][j])