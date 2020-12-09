'''
958. Check Completeness of a Binary Tree

Given the root of a binary tree, determine if it is a complete binary tree.

In a complete binary tree, every level, except possibly the last, is completely filled, 
and all nodes in the last level are as far left as possible. It can have between 1 and 2h nodes inclusive at the last level h.

 Example 1:


Input: root = [1,2,3,4,5,6]
Output: true
Explanation: Every level before the last is full (ie. levels with node-values {1} and {2, 3}), 
and all nodes in the last level ({4, 5, 6}) are as far left as possible.
'''
import collections
class TreeNode:
	def __init__(self, left = None, right = None, val = 0):
		self.left = left
		self.right = right
		self.val = val
class Solution(object):
	def check(self, root: TreeNode) -> bool:
		q = collections.deque()
		q.append(root)
		while len(q):
			node = q.popleft()
			if not node:
				break
			q.append(node.left)
			q.append(node.right)
		while len(q):
			node = q.popleft()
			if node:
				return False
		return True
if __name__ == "__main__":
	o = Solution()
	root = TreeNode(TreeNode(None, None, 1), None, 1)
	print(o.check(root))

