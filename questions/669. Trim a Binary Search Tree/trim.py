'''
Given the root of a binary search tree and the lowest and highest boundaries as low and high, 
trim the tree so that all its elements lies in [low, high]. 
Trimming the tree should not change the relative structure of the elements that will remain in the tree 
(i.e., any node's descendant should remain a descendant). It can be proven that there is a unique answer.

Return the root of the trimmed binary search tree. Note that the root may change depending on the given bounds.
'''
class TreeNode:
	def __init__(self, val = 0, left = None, right = None):#10
		self.val = val
		self.left = left
		self.right = right
class Solution:
	def trim(self, root, lo, hi):
		if not root:
			return None
		if root.val < lo:
			return self.trim(root.right, lo, hi)
		elif root.val > hi:
			return self.trim(root.left, lo, hi)
		
		root.left = self.trim(root.left, lo, hi)
		root.right = self.trim(root.right, lo, hi)
		return root
	def preorder(self, root):
		if not root:
			return
		print(root.val)
		self.preorder(root.left)
		self.preorder(root.right)
if __name__ == "__main__":
	root = TreeNode(3, TreeNode(0, None, TreeNode(2,TreeNode(1))), TreeNode(4))
	o = Solution()
	o.preorder(o.trim(root, 1, 3))