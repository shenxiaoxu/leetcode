'''
You are given two non-increasing 0-indexed integer arrays nums1​​​​​​ and nums2​​​​​​.

A pair of indices (i, j), where 0 <= i < nums1.length and 0 <= j < nums2.length, is valid if both i <= j and nums1[i] <= nums2[j]. The distance of the pair is j - i​​​​.

Return the maximum distance of any valid pair (i, j). If there are no valid pairs, return 0.

An array arr is non-increasing if arr[i-1] >= arr[i] for every 1 <= i < arr.length.
'''
class Solution:
    def maxDistance(self, nums1: List[int], nums2: List[int]) -> int:
        res = 0
        nums2.sort()
        for idx, num in enumerate(nums1):
            insert_idx = bisect_left(nums2, num)
            #print((len(nums2) - insert_idx - 1, idx))
            res = max(res, len(nums2) - insert_idx - idx - 1)
        return res
            