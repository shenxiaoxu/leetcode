class Solution:
    def minimumEffort(self, tasks: List[List[int]]) -> int:
        tasks.sort(key=lambda x:x[0]- x[1])
        res = cur = 0
        for cost, mmin in tasks:
            if mmin > cur:
                res += mmin - cur
                cur = mmin
            cur -= cost
        return res
        
