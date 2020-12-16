'''
98. Validate Binary Search Tree
Medium

Given the root of a binary tree, determine if it is a valid binary search tree (BST).

A valid BST is defined as follows:

The left subtree of a node contains only nodes with keys less than the node's key.
The right subtree of a node contains only nodes with keys greater than the node's key.
Both the left and right subtrees must also be binary search trees.
'''
class Solution(object):
	def isValidBST(self, root):
		if not root:
			return True
		def dfs(root, minV, maxV):
			if not root:
				return True
			if root.val <= minV or root.val >= maxV:
				return False
			return dfs(root.left, minV, min(root.val, maxV)) and dfs(root.right, max(root.val, minV), maxV)
		res = dfs(root, -float('inf'), float('inf'))
		return res
	def isValidBSTIte(self, root):
		stack, pre = [], None
		while root or stack:
			while root:
				stack.append(root)
				root = root.left
			cur = stack.pop()
			if pre and cur.val <= pre.val: 
				return False
			pre = cur
			root = cur.right
		return True
