class Solution:
    def minimumDeletions(self, s: str) -> int:
        n = len(s)
        res = float('inf')
        bcount = 0
        A = [0]*n
        if s[n - 1] == 'a':
            A[n - 1] = 1
        for i in range(n - 2, -1, -1):
            A[i] = A[i + 1]
            if s[i] == 'a':
                A[i] += 1
        for i in range(0, n):
            if s[i] == 'b':
                res = min(res, bcount + A[i])
                bcount += 1
        res = min(bcount, res)
        if res == float('inf'):
            return 0
        return res
