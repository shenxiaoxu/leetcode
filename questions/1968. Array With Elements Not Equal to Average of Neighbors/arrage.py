'''
You are given a 0-indexed array nums of distinct integers. You want to rearrange the elements in the array such that every element in the rearranged array is not equal to the average of its neighbors.

More formally, the rearranged array should have the property such that for every i in the range 1 <= i < nums.length - 1, (nums[i-1] + nums[i+1]) / 2 is not equal to nums[i].

Return any rearrangement of nums that meets the requirements.
'''
class Solution:
    def rearrangeArray(self, nums: List[int]) -> List[int]:
        for num in list(permutations(nums)):
            aver = True
            for i in range(1, len(num) - 1):
                if num[i] == (num[i - 1] + num[i + 1])/2:
                    aver = False
            if aver:
                return num
        return None