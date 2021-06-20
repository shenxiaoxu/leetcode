'''
A k x k magic square is a k x k grid filled with integers such that every row sum, every column sum, and both diagonal sums are all equal. The integers in the magic square do not have to be distinct. Every 1 x 1 grid is trivially a magic square.

Given an m x n integer grid, return the size (i.e., the side length k) of the largest magic square that can be found within this grid.
'''
class Solution:
    def largestMagicSquare(self, grid: List[List[int]]) -> int:
        m = len(grid)
        n = len(grid[0])
        res = 0
        rows = [[0]*(n+2) for _ in range(m + 2)]
        cols = [[0]*(n+2) for _ in range(m + 2)]
        d1 = [[0]*(n+2) for _ in range(m + 2)]
        d2 = [[0]*(n+2) for _ in range(m + 2)]
        #print(d1)
        for i in range(1, m + 1):
            for j in range(1, n + 1):
                rows[i][j] += rows[i][j - 1] + grid[i - 1][j - 1]
                cols[i][j] += cols[i - 1][j] + grid[i - 1][j - 1]
                d1[i][j] += d1[i - 1][j - 1] + grid[i - 1][j - 1]
                d2[i][j] += d2[i - 1][j + 1] + grid[i - 1][j - 1]
        #print(rows)
        for i in range(1, m + 1):
            for j in range(1, n + 1):
                for k in range(min(m - i, n - j), res, -1):
                    match = True
                    s1 = d1[i + k][j + k] - d1[i - 1][j - 1]
                    s2 = d2[i + k][j] - d2[i - 1][j + k + 1]
                    if s1 != s2:
                        match = False
                    for l in range(k + 1):
                        if not match: break
                        r1 = rows[i + l][j + k] - rows[i + l][j - 1]
                        if r1 != s1:
                            match = False
                            break
                        c1 = cols[i + k][j + l] - cols[i - 1][j + l]
                        if c1 != s1:
                            match = False
                            break
                    if match:
                        #print(s1)
                        res = max(res, k)
                        break
        return res + 1