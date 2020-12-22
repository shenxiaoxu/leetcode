'''
Given a binary tree, determine if it is height-balanced.

For this problem, a height-balanced binary tree is defined as:

a binary tree in which the left and right subtrees of every node differ in height by no more than 1.
'''
class Solution:
	def balanced(self, root:TreeNode)->bool:
		ans = True
		def dfs(root):
			nonlocal ans
			if not root:
				return 0
			left = dfs(root.left)
			right = dfs(root.right)
			if abs(left-right) > 1:
				ans = False
			return max(left, right) + 1
		return ans