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
        @lru_cache(None)
        def dfs(k):
            if k < 0:
                return -inf
            if k == 0: return 0
            return max(dfs(k - cost[i])*10+ i + 1 for i, c in enumerate(cost))
        return str(max(dfs(target),0))