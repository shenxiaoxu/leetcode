'''
There are n people and 40 types of hats labeled from 1 to 40.

Given a list of list of integers hats, where hats[i] is a list of all hats preferred by the i-th person.

Return the number of ways that the n people wear different hats to each other.

Since the answer may be too large, return it modulo 10^9 + 7.
'''
class Solution:
    def numberWays(self, hats: List[List[int]]) -> int:
        h_hat = [[] for i in range(41)]
        #print(h_hat)
        for i, pre_hats in enumerate(hats):
            for h1 in pre_hats:
                h_hat[h1].append(i)
        l_hat = list(filter(lambda h:h, h_hat))
        #print(l_hat)
        num_hat = len(l_hat)
        num_p = len(hats)
        MOD = 10**9 + 7
        @lru_cache(None)
        def dfs(i, mask):
            if bin(mask).count('1') == num_p:
                return 1
            if i == num_hat:
                return 0
            res = dfs(i + 1, mask)
            for p in l_hat[i]:
                if mask & (1 << p) == 0:
                    res += dfs(i + 1, mask | (1 << p))
            return res%MOD
        return dfs(0, 0)