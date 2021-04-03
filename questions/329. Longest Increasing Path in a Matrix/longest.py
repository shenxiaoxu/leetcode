'''
Given an m x n integers matrix, return the length of the longest increasing path in matrix.

From each cell, you can either move in four directions: left, right, up, or down. You may not move diagonally or move outside the boundary (i.e., wrap-around is not allowed).
'''
class Solution:
    def longestIncreasingPath(self, matrix: List[List[int]]) -> int:
        if not len(matrix) or not len(matrix[0]):
            return 0
        m, n = len(matrix), len(matrix[0])
        
        dp = [[0]*n for _ in range(m)]
        def dfs(x, y):
            if not dp[x][y]:
                val = matrix[x][y]
                dp[x][y] = 1 + max(
                    dfs(x - 1, y) if x and val > matrix[x - 1][y] else 0,
                    dfs(x + 1, y) if x < m - 1 and val > matrix[x + 1][y] else 0,
                    dfs(x, y + 1) if y < n - 1 and val > matrix[x][y + 1] else 0,
                    dfs(x, y - 1) if y and val > matrix[x][y - 1] else 0
                )
            return dp[x][y]
        return max(dfs(x, y) for x in range(m) for y in range(n))