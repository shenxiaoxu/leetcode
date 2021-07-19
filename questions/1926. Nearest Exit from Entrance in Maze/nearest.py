'''
You are given an m x n matrix maze (0-indexed) with empty cells (represented as '.') and walls (represented as '+'). You are also given the entrance of the maze, where entrance = [entrancerow, entrancecol] denotes the row and column of the cell you are initially standing at.

In one step, you can move one cell up, down, left, or right. You cannot step into a cell with a wall, and you cannot step outside the maze. Your goal is to find the nearest exit from the entrance. An exit is defined as an empty cell that is at the border of the maze. The entrance does not count as an exit.

Return the number of steps in the shortest path from the entrance to the nearest exit, or -1 if no such path exists.
'''
class Solution:
    def nearestExit(self, maze: List[List[str]], entrance: List[int]) -> int:
        m, n = len(maze), len(maze[0])
        v = [[0]*n for _ in range(m)]
        q = collections.deque()
        q.append((entrance[0], entrance[1]))
        v[entrance[0]][entrance[1]] = 1
        step = 0
        found = False
        while q:
            s = len(q)
            for _ in range(s):
                i, j = q.popleft()
                
                #print(i,j,"ori")
                for r,c in [[0,1],[1,0],[-1,0],[0,-1]]:
                    ni = r+i
                    nj = c+j
                    #print(ni,nj,step)
                    if i == entrance[0] and j == entrance[1] and (ni >= m or ni < 0 or nj >= n or nj < 0):
                        continue
                    if ni >= m or ni < 0 or nj >= n or nj < 0:
                        return step
                    if v[ni][nj] or maze[ni][nj] == '+': continue
                    #print(ni,nj) 
                    v[ni][nj] = 1
                    q.append([ni, nj])
            step += 1
                
        return step if found else -1
                    
                