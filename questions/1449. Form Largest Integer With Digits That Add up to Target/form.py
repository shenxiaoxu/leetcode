'''
Given an array of integers cost and an integer target. Return the maximum integer you can paint under the following rules:

The cost of painting a digit (i+1) is given by cost[i] (0 indexed).
The total cost used must be equal to target.
Integer does not have digits 0.
Since the answer may be too large, return it as string.

If there is no way to paint any integer given the condition, return "0".
'''
class Solution:
    def largestNumber(self, cost: List[int], target: int) -> str:
        res = 0
        dic = {}
        for i, c in enumerate(cost):
            dic[i + 1] = c
        @lru_cache(None)
        def cal(cur, num):
            nonlocal res
            if cur > target:
                return 0
            if cur == target:
                res = max(num, res)
                return
            for d in range(1,10):
                cal(cur + dic[d], num*10 + d)
        cal(0,0)
        return str(res)