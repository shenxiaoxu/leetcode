class Solution:
    def minOperations(self, nums: List[int]) -> int:
        
        prev, res = 0, 0

        for cur in nums:
            if cur <= prev:
                prev += 1
                res += prev - cur
            else:
                prev = cur
        return res