'''
Given the root of a binary tree, calculate the vertical order traversal of the binary tree.

For each node at position (row, col), its left and right children will be at positions (row + 1, col - 1) and (row + 1, col + 1) respectively. The root of the tree is at (0, 0).

The vertical order traversal of a binary tree is a list of top-to-bottom orderings for each column index starting from the leftmost column and ending on the rightmost column. There may be multiple nodes in the same row and same column. In such a case, sort these nodes by their values.

Return the vertical order traversal of the binary tree.
'''
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def verticalTraversal(self, root: TreeNode) -> List[List[int]]:
        dictionary = collections.defaultdict(list)
        queue = collections.deque()
        queue.append((root, 0, 0))
        min_col, max_col = 0, 0
        res = []
        while queue:
            size = len(queue)
            for i in range(size):
                node, row, col = queue.popleft()
                min_col = min(col, min_col)
                max_col = max(col, max_col)
                dictionary[col].append((row, node.val))
                if node.left:
                    queue.append((node.left, row + 1, col - 1))
                if node.right:
                    queue.append((node.right, row + 1, col + 1))
        for col in range(min_col, max_col + 1):
            tmp = []
            col_list = sorted(dictionary[col])
            for row, val in col_list:
                tmp.append((val))
            res.append(tmp)
        return res
        