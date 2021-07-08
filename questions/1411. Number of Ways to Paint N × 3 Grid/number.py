'''
You have a grid of size n x 3 and you want to paint each cell of the grid with exactly one of the three colors: Red, Yellow, or Green while making sure that no two adjacent cells have the same color (i.e., no two cells that share vertical or horizontal sides have the same color).

Given n the number of rows of the grid, return the number of ways you can paint this grid. As the answer may grow large, the answer must be computed modulo 109 + 7.
'''
class Solution:
    def numOfWays(self, n: int) -> int:
        a121, a123, MOD = 6, 6, 10**9 + 7
        for i in range(n - 1):
            a121, a123 = 3*a121 + 2*a123, 2*a121 + 2*a123
        return (a121+a123)%MOD
