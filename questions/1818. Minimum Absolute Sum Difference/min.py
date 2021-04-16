'''
You are given two positive integer arrays nums1 and nums2, both of length n.

The absolute sum difference of arrays nums1 and nums2 is defined as the sum of |nums1[i] - nums2[i]| for each 0 <= i < n (0-indexed).

You can replace at most one element of nums1 with any other element in nums1 to minimize the absolute sum difference.

Return the minimum absolute sum difference after replacing at most one element in the array nums1. Since the answer may be large, return it modulo 109 + 7.

|x| is defined as:

x if x >= 0, or
-x if x < 0.
'''

class Solution:
    def minAbsoluteSumDiff(self, nums1: List[int], nums2: List[int]) -> int:
        
        ans = float('inf')
        diff_ans = []
        absdiffsum = 0
        n = len(nums1)
        for i in range(n):
            diff = abs(nums1[i] - nums2[i])
            absdiffsum += diff
            diff_ans.append(diff)
        nums1.sort()
        for num, diff in zip(nums2, diff_ans):
            idx = bisect.bisect_left(nums1, num)
            if idx > 0:
                ans = min(ans, absdiffsum - diff + abs(nums1[idx - 1] - num))
            if idx < n:
                ans = min(ans, absdiffsum - diff + abs(nums1[idx] - num))
            
        return ans%1000000007