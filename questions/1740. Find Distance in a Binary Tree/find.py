'''
Given the root of a binary tree and two integers p and q, return the distance between the nodes of value p and value q in the tree.

The distance between two nodes is the number of edges on the path from one to the other.
'''
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def findDistance(self, root: TreeNode, p: int, q: int) -> int:
        if p == q: return 0
        def findlca(root, p, q):
            if not root:
                return None
            if root.val == p or root.val == q:
                return root
            left = findlca(root.left, p, q)
            right = findlca(root.right, p, q)
            if left and right:
                return root
            return left if left else right
        lca = findlca(root, p, q)
        #print(lca.val)
        res, count, step = 0,0, 0
        queue = collections.deque()
        queue.append(lca)
        while queue:
            size = len(queue)
            for i in range(size):
                cur = queue.popleft()
                
                if cur.val == p or cur.val == q:
                    #print(cur.val)
                    res += step
                    count += 1
                    #print(count)
                    if count == 2:
                        return res
                if cur.left:
                    queue.append(cur.left)
                if cur.right:
                    queue.append(cur.right)
            step += 1
        return -1