'''
You are given an integer array nums. The unique elements of an array are the elements that appear exactly once in the array.

Return the sum of all the unique elements of nums.
'''
class Solution:
    def sumOfUnique(self, nums: List[int]) -> int:
        m = Counter(nums)
        res = 0
        for k, v in m.items():
            if v == 1:
                res += k
        return res