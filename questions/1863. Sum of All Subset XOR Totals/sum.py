'''
The XOR total of an array is defined as the bitwise XOR of all its elements, or 0 if the array is empty.

For example, the XOR total of the array [2,5,6] is 2 XOR 5 XOR 6 = 1.
Given an array nums, return the sum of all XOR totals for every subset of nums. 

Note: Subsets with the same elements should be counted multiple times.

An array a is a subset of an array b if a can be obtained from b by deleting some (possibly zero) elements of b.
'''
class Solution:
    def subsetXORSum(self, nums: List[int]) -> int:
        visited = [0]*len(nums)
        res = 0
        def dfs(level, tmp):
            nonlocal res
            val = 0
            for i in tmp:
                val = val ^ i
            res += val
            for i in range(level,len(nums)):
                if visited[i] == 0:
                    visited[i] = 1
                    tmp.append(nums[i])
                    dfs(i + 1, tmp)
                    visited[i] = 0
                    tmp.pop()
        dfs(0,[])
        return res