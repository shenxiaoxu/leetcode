'''
Given two n x n binary matrices mat and target, return true if it is possible to make mat equal to target by rotating mat in 90-degree increments, or false otherwise.
'''
class Solution:
    def findRotation(self, mat: List[List[int]], target: List[List[int]]) -> bool:
        n = len(mat)
        def rotate(mat):
            nonlocal n
            for i in range(n):
                for j in range(i):
                    tmp = mat[i][j]
                    mat[i][j] = mat[j][i]
                    mat[j][i] = tmp
            for i in range(n):
                for j in range(n//2):
                    tmp = mat[i][j]
                    mat[i][j] = mat[i][n - j - 1]
                    mat[i][n - j - 1] = tmp
        
        time = 4
        while time != 0:                        
            if mat == target: return True
            rotate(mat)
            #print(mat)
            time -= 1
        return False
                    
            