'''
You are given a binary matrix matrix of size m x n, and you are allowed to rearrange the columns of the matrix in any order.

Return the area of the largest submatrix within matrix where every element of the submatrix is 1 after reordering the columns optimally.
'''
class Solution:
    def largestSubmatrix(self, matrix: List[List[int]]) -> int:
        res = 0
        for row in range(len(matrix)):
            for col in range(len(matrix[0])):
                if row > 0 and matrix[row][col] == 1:
                    matrix[row][col] += matrix[row - 1][col]
            
            cur = sorted(matrix[row],reverse=True)
            #print(matrix[row])
            for col in range(len(matrix[0])):
                res = max(res, cur[col] * (col + 1))
        return res