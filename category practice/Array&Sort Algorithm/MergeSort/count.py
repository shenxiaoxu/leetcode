'''
315. Count of Smaller Numbers After Self

You are given an integer array nums and you have to return a new counts array. 
The counts array has the property where counts[i] is the number of smaller elements to the right of nums[i].

 

Example 1:

Input: nums = [5,2,6,1]
Output: [2,1,1,0]
Explanation:
To the right of 5 there are 2 smaller elements (2 and 1).
To the right of 2 there is only 1 smaller element (1).
To the right of 6 there is 1 smaller element (1).
To the right of 1 there is 0 smaller element.
'''
class TreeNode:
	def __init__(self, val = 0, left = None, right = None):
		self.val = val
		self.left = left
		self.right = right
		self.duplicate = 1
		self.small = 0
class Solution(object):
	def countSmaller(self, nums):
		res = []
		if not nums: return res
		root = TreeNode(nums[-1])
		res.append(0)
		for i in range(len(nums) - 2, -1, -1):
			self.count = 0
			self.insert(root, nums[i])
			res.append(self.count)
		return res[::-1]
	def insert(self, root, num):
		if not root:
			return TreeNode(num)
		if root.val < num:
			self.count += root.duplicate + root.small
			root.right = self.insert(root.right, num)	
		elif root.val == num:
			root.duplicate += 1
			self.count += root.small
		else:
			root.small += 1
			root.left = self.insert(root.left, num)
		return root
if __name__ == "__main__":
	nums1 = [5,2,6,1]
	nums2 = [5,5,2,2,2,6,1,1]
	nums3 = []
	nums4 = [2,0,1]
	nums5 = [5,-4,5]
	o = Solution()
	print(o.countSmaller(nums1))
	print(o.countSmaller(nums2))
	print(o.countSmaller(nums3))
	print(o.countSmaller(nums4))
	print(o.countSmaller(nums5))

