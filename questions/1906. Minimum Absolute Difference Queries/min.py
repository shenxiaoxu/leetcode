'''
The minimum absolute difference of an array a is defined as the minimum value of |a[i] - a[j]|, where 0 <= i < j < a.length and a[i] != a[j]. If all elements of a are the same, the minimum absolute difference is -1.

For example, the minimum absolute difference of the array [5,2,3,7,2] is |2 - 3| = 1. Note that it is not 0 because a[i] and a[j] must be different.
You are given an integer array nums and the array queries where queries[i] = [li, ri]. For each query i, compute the minimum absolute difference of the subarray nums[li...ri] containing the elements of nums between the 0-based indices li and ri (inclusive).

Return an array ans where ans[i] is the answer to the ith query.

A subarray is a contiguous sequence of elements in an array.

The value of |x| is defined as:

x if x >= 0.
-x if x < 0.
'''
class Solution:
    def minDifference(self, nums: List[int], queries: List[List[int]]) -> List[int]:
        N = max(nums)
        dp = [[0]*(N + 1)]
        ans = []
        for num in nums:
            t = dp[-1][:]
            t[num] += 1
            dp.append(t)
        for s, e in queries:
            res = [i for x, y, i in zip(dp[e + 1], dp[s], range(N + 1)) if x != y]
        
            ans.append(min([y - x for x, y in zip(res, res[1:])] or [-1]))
        return ans