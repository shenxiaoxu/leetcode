'''
Given a rectangular pizza represented as a rows x cols matrix containing the following characters: 'A' (an apple) and '.' (empty cell) and given the integer k. You have to cut the pizza into k pieces using k-1 cuts. 

For each cut you choose the direction: vertical or horizontal, then you choose a cut position at the cell boundary and cut the pizza into two pieces. If you cut the pizza vertically, give the left part of the pizza to a person. If you cut the pizza horizontally, give the upper part of the pizza to a person. Give the last piece of pizza to the last person.

Return the number of ways of cutting the pizza such that each piece contains at least one apple. Since the answer can be a huge number, return this modulo 10^9 + 7.
'''
class Solution:
    def ways(self, pizza: List[str], k: int) -> int:
        m = len(pizza)
        n = len(pizza[0])
        M = 1000000007
        presum = [[0]*(n + 1) for _ in range(m + 1)]
        for i in range(m - 1, -1, -1):
            for j in range(n - 1, -1, -1):
                presum[i][j] = presum[i + 1][j] + presum[i][j + 1] - presum[i + 1][j + 1] + (pizza[i][j] == 'A')
        
        @lru_cache(None)
        def dfs(k, r, c):
            if presum[r][c] == 0:
                return 0
            if k == 0:
                return 1
            ans = 0
            for nr in range(r + 1, m):
                if presum[r][c] - presum[nr][c] > 0:
                    ans = (ans + dfs(k - 1, nr, c))%M
            for nc in range(c + 1, n):
                if presum[r][c] - presum[r][nc] > 0:
                    ans = (ans + dfs(k - 1, r, nc))%M
            return ans
        return dfs(k - 1, 0, 0)