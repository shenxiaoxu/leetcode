class Solution:
    def minSkips(self, dist: List[int], s: int, hoursBefore: int) -> int:
        n = len(dist)
        dp = [0] * (n + 1)
        for i in range(n):
            for j in range(n, -1, -1):
                dp[j] += dist[i]
                if j < n - 1:
                    dp[j] = (dp[j] + s - 1)//s*s
                if j > 0:
                    dp[j] = min(dp[j], dp[j - 1] + dist[i])
        for i in range(n):
            if dp[i] <= s*hoursBefore:
                return i
        return -1