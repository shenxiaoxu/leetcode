'''
Given an array nums of distinct positive integers, return the number of tuples (a, b, c, d) such that a * b = c * d where a, b, c, and d are elements of nums, and a != b != c != d.
'''
class Solution:
    def tupleSameProduct(self, nums: List[int]) -> int:
        d = collections.defaultdict(int)
        res = 0
        for i in range(len(nums)):
            for j in range(i + 1, len(nums)):
                d[nums[i]*nums[j]] += 1
        for key in d.keys():
            if d[key] >= 2:
                res += math.comb(d[key], 2)*8
        return res