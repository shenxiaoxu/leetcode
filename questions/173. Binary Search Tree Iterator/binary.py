'''
173. Binary Search Tree Iterator

Implement the BSTIterator class that represents an iterator over the in-order traversal of a binary search tree (BST):

BSTIterator(TreeNode root) Initializes an object of the BSTIterator class. The root of the BST is given as part of the constructor. 
The pointer should be initialized to a non-existent number smaller than any element in the BST.
boolean hasNext() Returns true if there exists a number in the traversal to the right of the pointer, otherwise returns false.
int next() Moves the pointer to the right, then returns the number at the pointer.
Notice that by initializing the pointer to a non-existent smallest number, the first call to next() will return the smallest element in the BST.

You may assume that next() calls will always be valid. That is, there will be at least a next number in the in-order traversal when next() is called.
'''
import collections
class TreeNode:
	def __init__(self, val = 0, left = None, right = None):
		self.val = val
		self.left = left
		self.right = right
class BSTIte:
	def __init__(self, root):
		self.stack = collections.deque()
		self.root = root
		while root:
			self.stack.append(root)
			root = root.left
	def hasNext(self):
		if len(self.stack) != 0:
			return True 
		return False
	def next(self):
		n = self.stack.pop()
		if n.right:
			right = n.right
			while right:
				self.stack.append(right)
				right = right.left
		return n.val
if __name__ == "__main__":
	root1 = TreeNode(1, TreeNode(2), TreeNode(3))
	root2 = TreeNode(4, None, root1)
	o = BSTIte(root2)
	
	while o.hasNext():
		print(o.next())