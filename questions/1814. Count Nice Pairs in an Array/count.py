'''
You are given an array nums that consists of non-negative integers. Let us define rev(x) as the reverse of the non-negative integer x. For example, rev(123) = 321, and rev(120) = 21. A pair of indices (i, j) is nice if it satisfies all of the following conditions:

0 <= i < j < nums.length
nums[i] + rev(nums[j]) == nums[j] + rev(nums[i])
Return the number of nice pairs of indices. Since that number can be too large, return it modulo 109 + 7.
'''
class Solution:
    def countNicePairs(self, nums: List[int]) -> int:
        tran = []
        num_map = collections.defaultdict(int)
        count = 0
        for i in range(len(nums)):
            rev = int(str(nums[i])[::-1])
            tran.append(nums[i]-rev)
        for i in range(len(tran)):
            if tran[i] in num_map:
                count = (count + num_map[tran[i]])%1000000007
            num_map[tran[i]] += 1
        return count