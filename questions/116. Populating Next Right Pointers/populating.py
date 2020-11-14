"""
# Definition for a Node.
class Node:
    def __init__(self, val: int = 0, left: 'Node' = None, right: 'Node' = None, next: 'Node' = None):
        self.val = val
        self.left = left
        self.right = right
        self.next = next
"""

class Solution:
    def connect(self, root: 'Node') -> 'Node':
        if not root:
            return None
        cur = root
        prev = root.left
        while prev:
            head = cur
            while head:
                prev.next = head.right
                prev = prev.next
                head = head.next
                if not head: 
                    break
                prev.next = head.left
                prev = prev.next
            cur = cur.left
            prev = cur.left
        return root
        
        
