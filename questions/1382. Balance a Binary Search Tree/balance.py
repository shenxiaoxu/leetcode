'''
Given a binary search tree, return a balanced binary search tree with the same node values.

A binary search tree is balanced if and only if the depth of the two subtrees of every node never differ by more than 1.

If there is more than one answer, return any of them.
'''
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def balanceBST(self, root: TreeNode) -> TreeNode:
        list_array = []
        def convert(root):
            if not root:
                return
            nonlocal list_array
            
            convert(root.left)
            list_array.append(root.val)
            convert(root.right)
        convert(root)
        #print(list_array)
        def buildTree(list_array, lo, hi):
            if lo == hi:
                return TreeNode(list_array[lo])
            if lo > hi:
                return None
            mid = (lo + hi)//2
            root = TreeNode(list_array[mid])
            root.left = buildTree(list_array, lo, mid - 1)
            root.right = buildTree(list_array, mid + 1, hi)
            return root
            
        return buildTree(list_array, 0, len(list_array) - 1)