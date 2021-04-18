class Solution:
    def minSideJumps(self, obstacles: List[int]) -> int:
        n = len(obstacles)
        dp = [1,0,1]
        for a in obstacles:
            if a:
                dp[a - 1] = float('inf')
            for j in range(3):
                if j + 1 != a:
                    dp[j] = min(dp[j], dp[(j + 1)%3] + 1, dp[(j + 2)%3] + 1)
        return min(dp)
                    