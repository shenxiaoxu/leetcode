'''
You are given two integers m and n. Consider an m x n grid where each cell is initially white. You can paint each cell red, green, or blue. All cells must be painted.

Return the number of ways to color the grid with no two adjacent cells having the same color. Since the answer can be very large, return it modulo 109 + 7.
'''
class Solution:
    def colorTheGrid(self, m: int, n: int) -> int:
        def setColor(mask, pos, color):
            return mask | (color << (2*pos))
        def getColor(mask, pos):
            return (mask >> (2*pos))&3
        
        def dfs(r, curMask, prevMask, out):
            if r == m:
                out.append(curMask)
                return
            
            for i in [1,2,3]:
                if getColor(prevMask, r) != i and (r == 0 or getColor(curMask, r - 1) != i):
                    dfs(r + 1, setColor(curMask, r, i), prevMask, out)
                
        @lru_cache(None)
        def neighbor(prevMask):
            out = []
            dfs(0,0,prevMask,out)
            return out
        
        @lru_cache(None)
        def dp(c, prevMask):
            if c == n:
                return 1
            ans = 0
            for nei in neighbor(prevMask):
                ans = (ans + dp(c + 1, nei))%1000000007
            return ans
        
        return dp(0,0)