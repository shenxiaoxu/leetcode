'''
Given a binary tree root, a node X in the tree is named good if in the path from root to X there are no nodes with a value greater than X.

Return the number of good nodes in the binary tree.
'''
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def goodNodes(self, root: TreeNode) -> int:
        def dfs(root, num):
            if not root:
                return 0
            left = dfs(root.left, max(root.val, num))
            right = dfs(root.right, max(root.val, num))
            return left + right + (1 if root.val >= num else 0)
        return dfs(root, -inf)
        