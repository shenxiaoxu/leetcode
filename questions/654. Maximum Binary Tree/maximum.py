'''
You are given an integer array nums with no duplicates. A maximum binary tree can be built recursively from nums using the following algorithm:

Create a root node whose value is the maximum value in nums.
Recursively build the left subtree on the subarray prefix to the left of the maximum value.
Recursively build the right subtree on the subarray suffix to the right of the maximum value.
Return the maximum binary tree built from nums.
'''
# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution(object):
    def constructMaximumBinaryTree(self, nums):
        """
        :type nums: List[int]
        :rtype: TreeNode
        """
        def build(nums, start, end):
            if start > end:
                return None
            idx, num_max = 0, float('-inf')
            for i in range(start, end + 1):
                if nums[i] > num_max:
                    num_max = nums[i]
                    idx = i
            root = TreeNode(num_max)
            root.left = build(nums, start, idx - 1)
            root.right = build(nums, idx + 1, end)
            return root
        root = build(nums, 0, len(nums) - 1)
        return root
        