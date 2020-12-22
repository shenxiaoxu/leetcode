'''
Given the root of a binary tree and a node u in the tree, return the nearest node on the same level that is to the right of u, 
or return null if u is the rightmost node in its level.
'''
class Solution:
	def levelorder(self, root, u):
		q = collections.deque()
		q.append(root)
		while q:
			size = len(q)
			for i in range(size):
				cur = q.popleft()
				if cur == u:
					return q.popleft() if i != size - 1 else None 
				if cur.left:
					q.append(cur.left)
				if cur.right:
					q.append(cur.right)
		return None
	def findNearestRightNode(self, root: TreeNode, u: TreeNode)->TreeNode:
		level, ans = None, None
		def dfs(root, lvl):
			nonlocal level, ans
			if not root:
				return
			if root == u:
				level = lvl
			elif lvl == level and ans is None:
				ans = root
				return
			dfs(root.left, lvl + 1)
			dfs(root.right, lvl + 1)
		dfs(root, 0)
		return ans
