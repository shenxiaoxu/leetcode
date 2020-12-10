'''
102. Binary Tree Level Order Traversal

Given a binary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).

For example:
Given binary tree [3,9,20,null,null,15,7],
    3
   / \
  9  20
    /  \
   15   7
return its level order traversal as:
[
  [3],
  [9,20],
  [15,7]
]
'''
import collections
class TreeNode:
	def __init__(self, val = 0, left = None, right = None):
		self.left = left
		self.right = right
		self.val = val
class Solution(object):
	def level(self, root):
		if not root:
			return []
		q = collections.deque()
		res = []
		q.append(root)
		while len(q):
			s = len(q)
			level = []
			for i in range(s):
				cur = q.popleft()
				level.append(cur.val)
				if cur.left:
					q.append(cur.left)
				if cur.right:
					q.append(cur.right)
			res.append(level)
		return res
if __name__ == "__main__":
	o = Solution()
	root = TreeNode(3, TreeNode(9), TreeNode(20))
	print(o.level(root))
	print(o.level(None))

