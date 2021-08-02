class Solution:
    def maxCompatibilitySum(self, students: List[List[int]], mentors: List[List[int]]) -> int:
        m = len(students)
        score = [[0]*m for _ in range(m)]
        for x in range(m):
            for y in range(m):
                score[x][y] = sum(i == j for i, j in zip(students[x], mentors[y]))
        @cache
        def dfs(mask, j):
            ans = 0
            for i in range(m):
                if not mask & (1 << i):
                    ans = max(ans, dfs(mask^(1 << i), j - 1) + score[i][j])
            return ans
        return dfs(1<<m, m - 1)