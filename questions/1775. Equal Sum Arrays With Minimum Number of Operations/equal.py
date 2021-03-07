'''
You are given two arrays of integers nums1 and nums2, possibly of different lengths. The values in the arrays are between 1 and 6, inclusive.

In one operation, you can change any integer's value in any of the arrays to any value between 1 and 6, inclusive.

Return the minimum number of operations required to make the sum of values in nums1 equal to the sum of values in nums2. Return -1​​​​​ if it is not possible to make the sum of the two arrays equal.
'''
class Solution:
    def minOperations(self, nums1: List[int], nums2: List[int]) -> int:
        if 6*len(nums1) < len(nums2) or len(nums1) > 6*len(nums2):
            return -1
        sum1, sum2 = sum(nums1), sum(nums2)
        if sum1 > sum2:
            return self.minOperations(nums2, nums1)
        nums1.sort()
        nums2.sort()
        i, j = 0, len(nums2) - 1
        res = 0
        while sum1 < sum2:
            if i < len(nums1) and j >= 0 and 6 - nums1[i] > nums2[j] - 1:
                sum1 += 6 - nums1[i]
                i += 1
            else:
                sum2 -= nums2[j] - 1
                j -= 1
            res += 1
        return res
        