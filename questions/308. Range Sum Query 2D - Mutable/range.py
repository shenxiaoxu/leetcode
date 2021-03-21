'''
Given a 2D matrix matrix, find the sum of the elements inside the rectangle defined by its upper left corner (row1, col1) and lower right corner (row2, col2).

Implement the NumMatrix class:

NumMatrix(int[][] matrix) initializes the object with the integer matrix matrix.
void update(int row, int col, int val) updates the value of matrix[row][col] to be val.
int sumRegion(int row1, int col1, int row2, int col2) returns the sum of the elements of the matrix array inside the rectangle defined by its upper left corner (row1, col1) and lower right corner (row2, col2).
'''
class NumMatrix:

    def __init__(self, matrix: List[List[int]]):
        if not matrix:
            return
        self.m = len(matrix)
        self.n = len(matrix[0])
        self.bit = [[0]*(self.n+1) for _ in range(self.m + 1)]
        self.num = [[0]*(self.n) for _ in range(self.m)]
        for i in range(self.m):
            for j in range(self.n):
                self.update(i,j, matrix[i][j])

    def update(self, row: int, col: int, val: int) -> None:
        diff, self.num[row][col], i= val - self.num[row][col], val, row + 1
        while i <= self.m:
            j = col + 1
            while j <= self.n:
                self.bit[i][j] += diff
                j += (j & -j)
            i += (i & -i)

    def sumRegion(self, row1: int, col1: int, row2: int, col2: int) -> int:
        return self.sumBit(row2, col2) + self.sumBit(row1 - 1, col1 - 1) - self.sumBit(row1 - 1, col2) - self.sumBit(row2, col1 - 1)
    
    def sumBit(self, row, col):
        res, i = 0, row + 1
        while i:
            j = col + 1
            while j:
                res += self.bit[i][j]
                j -= j&(-j)
            i -= i&(-i)
        return res


# Your NumMatrix object will be instantiated and called as such:
# obj = NumMatrix(matrix)
# obj.update(row,col,val)
# param_2 = obj.sumRegion(row1,col1,row2,col2)