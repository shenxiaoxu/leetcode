'''
Given an integer array nums, your goal is to make all elements in nums equal. To complete one operation, follow these steps:

Find the largest value in nums. Let its index be i (0-indexed) and its value be largest. If there are multiple elements with the largest value, pick the smallest i.
Find the next largest value in nums strictly smaller than largest. Let its value be nextLargest.
Reduce nums[i] to nextLargest.
Return the number of operations to make all elements in nums equal.
'''
class Solution:
    def reductionOperations(self, nums: List[int]) -> int:
        m = Counter(nums)
        s = list(m.keys())
        s.sort()
        res = 0
        for i in range(len(s) - 1, 0, -1):
            res += m[s[i]] * i 
        return res