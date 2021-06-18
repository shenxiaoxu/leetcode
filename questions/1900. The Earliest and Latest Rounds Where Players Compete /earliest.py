class Solution:
    def earliestAndLatest(self, n: int, firstPlayer: int, secondPlayer: int) -> List[int]:
        minround = float('inf')
        maxround = -float('inf')
        @lru_cache
        def dfs(mask, i, j, r):
            nonlocal minround, maxround
            if i >= j:
                dfs(mask, 1, n, r + 1)
            elif mask & (1 << i):
                dfs(mask, i + 1, j, r)
            elif mask & (1 << j):
                dfs(mask, i, j - 1, r)
            elif i == firstPlayer and j == secondPlayer:
                minround = min(r, minround)
                maxround = max(r, maxround)
            else:
                if i != firstPlayer and i != secondPlayer:
                    dfs(mask | (1 << i), i + 1, j - 1, r)
                if j != secondPlayer and j != firstPlayer:
                    dfs(mask | (1 << j), i + 1, j - 1, r)
        dfs(0, 1, n, 1)
        return minround, maxround