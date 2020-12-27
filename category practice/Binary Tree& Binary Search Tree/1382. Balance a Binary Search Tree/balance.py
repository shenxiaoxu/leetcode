'''
Given a binary search tree, return a balanced binary search tree with the same node values.

A binary search tree is balanced if and only if the depth of the two subtrees of every node never differ by more than 1.

If there is more than one answer, return any of them.
'''
from typing import List
class TreeNode:
	def __init__(self, val = 0, left = None, right = None):
		self.left = left
		self.right = right
		self.val = val
class Solution:
	def balanceBinaryTree(self, root:TreeNode)->TreeNode:
		res = []
		self.inorder(root, res)
		def construct(nums:List[int], lo, hi)->TreeNode:
			if lo > hi:
				return None
			mid = lo + (hi - lo)//2
			root = TreeNode(nums[mid])
			root.left = construct(nums, lo, mid - 1)
			root.right = construct(nums, mid + 1, hi)
			return root
		root = construct(res, 0, len(res) - 1)
		return root
	def inorder(self, root:TreeNode, res: List[int]):
		if not root:
			return
		self.inorder(root.left, res)
		res.append(root.val)
		self.inorder(root.right, res)
	def preorder(self, root:TreeNode):
		if not root:
			return
		print(root.val)
		self.preorder(root.left)
		self.preorder(root.right)
if __name__ == "__main__":
	root = TreeNode(1, None, TreeNode(5, None, TreeNode(7)))
	o = Solution()
	res = o.balanceBinaryTree(root)
	o.preorder(res)


