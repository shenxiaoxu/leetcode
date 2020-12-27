'''
Return the root node of a binary search tree that matches the given preorder traversal.

(Recall that a binary search tree is a binary tree where for every node, any descendant of node.left has a value < node.val, 
and any descendant of node.right has a value > node.val.  Also recall that a preorder traversal displays the value of the node first, 
then traverses node.left, then traverses node.right.)

It's guaranteed that for the given test cases there is always possible to find a binary search tree with the given requirements.
'''
from typing import List
class TreeNode:
	def __init__(self, val = 0, left = None, right = None):
		self.val = val
		self.left = left
		self.right = right
class Solution:
	def constructBinaryTree(self, nums:List[int])->TreeNode:
		level = 0
		def dfs(nums, lo, hi):
			nonlocal level
			if level >= len(nums) or lo >= nums[level] or nums[level] >= hi: 
				return None
			
			root = TreeNode(nums[level])
			level += 1
			if level < len(nums) and lo < nums[level] < root.val:
				root.left = dfs(nums, lo, root.val)
			
			if level < len(nums) and root.val < nums[level] < hi:
				root.right = dfs(nums, root.val, hi)
			return root
		res = dfs(nums, float('-inf'), float('inf'))
		return res
	def preorder(self, root: TreeNode):
		if not root:
			return
		print(root.val)
		self.preorder(root.left)
		self.preorder(root.right)
if __name__ == "__main__":
	nums = [8,5,1,7,10,12]
	o = Solution()
	res = o.constructBinaryTree(nums)
	o.preorder(res)
