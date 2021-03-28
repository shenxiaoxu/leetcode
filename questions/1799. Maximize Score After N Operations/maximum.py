'''
You are given nums, an array of positive integers of size 2 * n. You must perform n operations on this array.

In the ith operation (1-indexed), you will:

Choose two elements, x and y.
Receive a score of i * gcd(x, y).
Remove x and y from nums.
Return the maximum score you can receive after performing n operations.

The function gcd(x, y) is the greatest common divisor of x and y.
'''
class Solution:
    def maxScore(self, nums: List[int]) -> int:
        
        @lru_cache(None)
        def gcd(x, y):
            return math.gcd(x, y)
        
        def setBit(mask, i):
            return (1 << i)|mask
        
        def getBit(mask, i):
            return (mask>>i)&1
        
        @lru_cache(None)
        def dp(op, mask):
            if op == n + 1:
                return 0
            ans = 0
            for i in range(2*n):
                if getBit(mask, i) == 1: continue
                for j in range(i + 1, 2*n):
                    if getBit(mask, j) == 1: continue
                    newMask = setBit(setBit(mask, i), j)
                    ans = max(ans, dp(op + 1, newMask) + op*gcd(nums[i], nums[j]))
            return ans
                    
        n = len(nums)//2
        return dp(1, 0)