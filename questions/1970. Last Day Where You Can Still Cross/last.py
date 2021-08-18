'''
There is a 1-based binary matrix where 0 represents land and 1 represents water. You are given integers row and col representing the number of rows and columns in the matrix, respectively.

Initially on day 0, the entire matrix is land. However, each day a new cell becomes flooded with water. You are given a 1-based 2D array cells, where cells[i] = [ri, ci] represents that on the ith day, the cell on the rith row and cith column (1-based coordinates) will be covered with water (i.e., changed to 1).

You want to find the last day that it is possible to walk from the top to the bottom by only walking on land cells. You can start from any cell in the top row and end at any cell in the bottom row. You can only travel in the four cardinal directions (left, right, up, and down).

Return the last day where it is possible to walk from the top to the bottom by only walking on land cells.
'''
class Solution:
    def latestDayToCross(self, row: int, col: int, cells: List[List[int]]) -> int:
        n = len(cells)
        visited = [[1]*col for _ in range(row)]
        def ok(m):
            
            def dfs(xr, xc, v):
                #print(xr,xc)
                if xr == row - 1:
                    return True
                res = False
                for l in [[0,1],[0,-1],[1,0],[-1,0]]:
                    x,y = l[0],l[1]
                    nr,nc = xr+x,xc+y
                    if 0<=nr<row and 0<=nc<col and v[nr][nc] == 0:
                        v[nr][nc] = 1
                        res = res | dfs(nr,nc,v)
                        if res:
                            v[nr][nc] = 0
                            return True
                        v[nr][nc] = 0
                return res
            for x in range(col):
                if m[0][x] == 0:
                    if dfs(0, x, m):
                        return True
            return False
        for i in range(n - 1, -1, -1):
            r, c = cells[i][0] - 1, cells[i][1] - 1
            visited[r][c] = 0
            if ok(visited):
                return i
        return -1