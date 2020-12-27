'''
Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).

For example, this binary tree [1,2,2,3,4,4,3] is symmetric:
'''
class Soluton:
	def symmetric(self, root:TreeNode)->bool:
		if not root:
			return True
		def dfs(left, right):
			if not left and not right:
				return True 
			if not left or not right:
				return False
			return left.val == right.val and dfs(left.left, right.right) 
				and dfs(left.right, right.left)
		return dfs(root.left, root.right)