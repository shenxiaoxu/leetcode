'''
Given the root of a binary tree and an integer targetSum, return all root-to-leaf paths where each path's sum equals targetSum.

A leaf is a node with no children.
'''
class Solution(object):
    def pathSum(self, root, targetSum):
        """
        :type root: TreeNode
        :type targetSum: int
        :rtype: List[List[int]]
        """
        res = []
        def recursiveBuild(tmp, root, targetSum):
            if root:
                if not root.left and not root.right and targetSum == root.val:
                    tmp.append(root.val)
                    res.append(tmp)
                recursiveBuild(tmp + [root.val], root.left, targetSum - root.val)
                recursiveBuild(tmp + [root.val], root.right, targetSum - root.val)
        recursiveBuild([], root, targetSum)
        return res