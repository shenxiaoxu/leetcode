class Solution:
    def longestMountain(self, A: List[int]) -> int:
        l,res = len(A), 0
        down = [0]*l
        up = [0]*l
        for i in range(l - 2, 0, -1):
            if A[i] > A[i + 1]:
                down[i] = down[i + 1] + 1
        for i in range(0,l):
            if i > 0 and A[i] > A[i - 1]:
                up[i] = up[i - 1] + 1
            if down[i] > 0 and up[i] > 0:
                res = max(res, down[i] + up[i] + 1)
        return res
