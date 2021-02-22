'''
You are given an integer matrix isWater of size m x n that represents a map of land and water cells.

If isWater[i][j] == 0, cell (i, j) is a land cell.
If isWater[i][j] == 1, cell (i, j) is a water cell.
You must assign each cell a height in a way that follows these rules:

The height of each cell must be non-negative.
If the cell is a water cell, its height must be 0.
Any two adjacent cells must have an absolute height difference of at most 1. A cell is adjacent to another cell if the former is directly north, east, south, or west of the latter (i.e., their sides are touching).
Find an assignment of heights such that the maximum height in the matrix is maximized.

Return an integer matrix height of size m x n where height[i][j] is cell (i, j)'s height. If there are multiple solutions, return any of them.
'''
class Solution:
    def highestPeak(self, isWater: List[List[int]]) -> List[List[int]]:
        q = collections.deque()
        res = [[0]*len(isWater[0]) for _ in range(len(isWater))]
        visited = [[0]*len(isWater[0]) for _ in range(len(isWater))]
        for i in range(len(isWater)):
            for j in range(len(isWater[0])):
                if isWater[i][j] == 1:
                    visited[i][j] = 1
                    q.append([i, j, 0])
        while q:
            size = len(q)
            for i in range(size):
                row, col, val = q.popleft()
                for ri, ci in [[1,0],[-1,0],[0,1],[0,-1]]:
                    nr, nc = row + ri, col + ci
                    if 0<=nr< len(isWater) and 0<=nc<len(isWater[0]) and visited[nr][nc] == 0:
                        res[nr][nc] = val + 1
                        visited[nr][nc] = 1
                        q.append([nr, nc, val + 1])
        return res
                        