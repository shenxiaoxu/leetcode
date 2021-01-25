'''
You are given a 2D matrix of size m x n, consisting of non-negative integers. You are also given an integer k.

The value of coordinate (a, b) of the matrix is the XOR of all matrix[i][j] where 0 <= i <= a < m and 0 <= j <= b < n (0-indexed).

Find the kth largest value (1-indexed) of all the coordinates of matrix.
'''
class Solution:
    def kthLargestValue(self, matrix: List[List[int]], k: int) -> int:
        m, n = len(matrix), len(matrix[0])
        xor = [[0]*n for _ in range(m)]
        l = []
        for i in range(m):
            for j in range(n):
                tmp = 0
                if i > 0:
                    tmp ^= xor[i - 1][j]
                if j > 0:
                    tmp ^= xor[i][j - 1]
                if i > 0 and j > 0:
                    tmp ^= xor[i - 1][j - 1]
                xor[i][j] = tmp ^ matrix[i][j]
                l.append(xor[i][j])
        l.sort()
        return l[len(l) - k]