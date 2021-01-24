'''
You are starving and you want to eat food as quickly as possible. You want to find the shortest path to arrive at any food cell.

You are given an m x n character matrix, grid, of these different types of cells:

'*' is your location. There is exactly one '*' cell.
'#' is a food cell. There may be multiple food cells.
'O' is free space, and you can travel through these cells.
'X' is an obstacle, and you cannot travel through these cells.
You can travel to any adjacent cell north, east, south, or west of your current location if there is not an obstacle.

Return the length of the shortest path for you to reach any food cell. If there is no path for you to reach food, return -1.
'''
class Solution:
    def getFood(self, grid: List[List[str]]) -> int:
        m, n = len(grid), len(grid[0])
        q = collections.deque()
        found = False
        visited = [[0]*n for _ in range(m)]
        for i in range(m):
            for j in range(n):
                if grid[i][j] == '*':
                    found = True
                    q.append((i, j, 0))
                    visited[i][j] = 1
                    break
            if found:
                break
        while q:
            size = len(q)
            for i in range(size):
                r, c, length = q.popleft()
                #print(r,c)
                for j in [[-1,0],[1,0],[0,-1],[0,1]]:
                    nr = r + j[0]
                    nc = c + j[1]
                    if nr >= m or nr < 0 or nc >= n or nc < 0 or grid[nr][nc] == 'X' or visited[nr][nc] == 1:
                        continue
                    if grid[nr][nc] == '#':
                        return length + 1
                    visited[nr][nc] = 1
                    q.append((nr, nc, length + 1))
        return -1
        