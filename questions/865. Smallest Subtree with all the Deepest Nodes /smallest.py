'''
Given the root of a binary tree, the depth of each node is the shortest distance to the root.

Return the smallest subtree such that it contains all the deepest nodes in the original tree.

A node is called the deepest if it has the largest depth possible among any node in the entire tree.

The subtree of a node is tree consisting of that node, plus the set of all descendants of that node.
'''
class TreeNode:
	def __init__(self, val = 0, left = None, right = None):
		self.val = val
		self.left = left
		self.right = right
class Solution(object):
	def subtreeWithAllDeepest(self, root):
		if not root:
			return None
		def dfs(root, height):
			if not root:
				return [-1, None]
			left = dfs(root.left, height + 1)
			right = dfs(root.right, height + 1)
			if left[0] == right[0] and left[0] != -1:
				return [left[0], root]
			elif left[0] == right[0] and left[0] == -1:
				return [height, root]
			else:
				return [left[0], left[1]] if left[0]>right[0] else [right[0], right[1]]
		h, res = dfs(root, 0)
		return res
if __name__ == "__main__":
	o = Solution()
	root = TreeNode(1,TreeNode(2), TreeNode(3))
	res = o.smallest(root)
	print(res.val)
