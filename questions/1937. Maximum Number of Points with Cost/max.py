'''
You are given an m x n integer matrix points (0-indexed). Starting with 0 points, you want to maximize the number of points you can get from the matrix.

To gain points, you must pick one cell in each row. Picking the cell at coordinates (r, c) will add points[r][c] to your score.

However, you will lose points if you pick a cell too far from the cell that you picked in the previous row. For every two adjacent rows r and r + 1 (where 0 <= r < m - 1), picking cells at coordinates (r, c1) and (r + 1, c2) will subtract abs(c1 - c2) from your score.

Return the maximum number of points you can achieve.
'''
class Solution:
    def maxPoints(self, p: List[List[int]]) -> int:
        m = len(p)
        n = len(p[0])
        if m == 1: return max(p[0])
        if n == 1: return sum(sum(x) for x in p)
        
        def lft(pre):
            cur = [pre[0]] + [0]*(n - 1)
            for i in range(1, n):
                cur[i] = max(cur[i - 1] - 1, pre[i])
            return cur
        def rig(pre):
            cur =  [0]*(n - 1) + [pre[-1]]
            for i in range(n - 2, -1, -1):
                cur[i] = max(cur[i + 1] - 1, pre[i])
            return cur        
        
        pre = p[0]
        for i in range(m - 1):
            left, right, cur = lft(pre), rig(pre), [0]*n
            for j in range(n):
                cur[j] = max(left[j],right[j]) + p[i + 1][j]
            
            pre = cur[:]
        return max(pre)
        