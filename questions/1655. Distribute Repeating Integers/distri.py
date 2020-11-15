class Solution:
    def canDistribute(self, nums: List[int], quantity: List[int]) -> bool:
        ma = defaultdict(int)
        for i in nums:
            ma[i] += 1
        count = list(Counter(ma).values())
        count.sort()
        quantity.sort(reverse = True)
        def dfs(c, q, l):
            if l == len(q):
                return True
            for i in range(len(c)):
                if c[i] >= q[l]:
                    c[i] -= q[l]
                    if dfs(c, q, l + 1):
                        return True
                    c[i] += q[l]
            return False
        return dfs(count, quantity, 0)
        
