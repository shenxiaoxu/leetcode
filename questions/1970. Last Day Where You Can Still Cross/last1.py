class Solution:
    def latestDayToCross(self, row: int, col: int, cells: List[List[int]]) -> int:
        n = len(cells)        
        def ok(m):
            visited = [[0]*col for _ in range(row)]
            for i in range(m):
                x, y = cells[i]
                visited[x - 1][y - 1] = 1
            q = collections.deque()
            for x in range(col):
                if visited[0][x] == 0:
                    visited[0][x] = 1
                    q.append((0,x))
            
            while q:
                x, y = q.pop()
                if x == row - 1:
                    return True
                for i,j in [[0,1],[1,0],[0,-1],[-1,0]]:
                    nx = x + i
                    ny = y + j
                    if 0<=nx<row and 0<=ny<col and visited[nx][ny] == 0:
                        visited[nx][ny] = 1
                        q.append((nx,ny))
            return False
        lo,hi = 0, n
        while lo < hi:
            mid = lo + (hi - lo)//2
            #print(mid)
            if ok(mid):
                lo = mid + 1
            else:
                hi = mid
        return lo - 1