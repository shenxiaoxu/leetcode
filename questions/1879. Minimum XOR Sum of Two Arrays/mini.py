'''
You are given two integer arrays nums1 and nums2 of length n.

The XOR sum of the two integer arrays is (nums1[0] XOR nums2[0]) + (nums1[1] XOR nums2[1]) + ... + (nums1[n - 1] XOR nums2[n - 1]) (0-indexed).

For example, the XOR sum of [1,2,3] and [3,2,1] is equal to (1 XOR 3) + (2 XOR 2) + (3 XOR 1) = 2 + 0 + 2 = 4.
Rearrange the elements of nums2 such that the resulting XOR sum is minimized.

Return the XOR sum after the rearrangement.
'''
class Solution:
    def minimumXORSum(self, nums1: List[int], nums2: List[int]) -> int:
        perm = permutations(nums2)
        res = float('inf')
        for perm_ele in perm:
            tmp = 0
            for j in range(len(nums1)):
                tmp += nums1[j]^perm_ele[j]
            res = min(res, tmp)
        return res