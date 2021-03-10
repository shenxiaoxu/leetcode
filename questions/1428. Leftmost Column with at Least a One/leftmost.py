'''
A row-sorted binary matrix means that all elements are 0 or 1 and each row of the matrix is sorted in non-decreasing order.

Given a row-sorted binary matrix binaryMatrix, return the index (0-indexed) of the leftmost column with a 1 in it. If such an index does not exist, return -1.

You can't access the Binary Matrix directly. You may only access the matrix using a BinaryMatrix interface:

BinaryMatrix.get(row, col) returns the element of the matrix at index (row, col) (0-indexed).
BinaryMatrix.dimensions() returns the dimensions of the matrix as a list of 2 elements [rows, cols], which means the matrix is rows x cols.
Submissions making more than 1000 calls to BinaryMatrix.get will be judged Wrong Answer. Also, any solutions that attempt to circumvent the judge will result in disqualification.

For custom testing purposes, the input will be the entire binary matrix mat. You will not have access to the binary matrix directly.
'''
# """
# This is BinaryMatrix's API interface.
# You should not implement it, or speculate about its implementation
# """
#class BinaryMatrix(object):
#    def get(self, row: int, col: int) -> int:
#    def dimensions(self) -> list[]:

class Solution:
    def leftMostColumnWithOne(self, binaryMatrix: 'BinaryMatrix') -> int:
        row_col = binaryMatrix.dimensions()
        row, col = row_col[0], row_col[1]
        lo, hi = 0, col - 1
        res = col
        for r in range(row):
            val = 0
            lo, hi = 0, min(res, hi)
            while lo < hi:
                mid = (lo + hi)//2
                val = binaryMatrix.get(r, mid)
                if val == 0:
                    lo = mid + 1
                else:
                    hi = mid
            #print(lo)
            if binaryMatrix.get(r,lo) != 0:
                res = min(lo, res)
        return res if res != col else -1