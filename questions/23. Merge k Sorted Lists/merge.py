'''

You are given an array of k linked-lists lists, each linked-list is sorted in ascending order.

Merge all the linked-lists into one sorted linked-list and return it.
'''
# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def mergeKLists(self, lists: List[ListNode]) -> ListNode:
        def merge(left, right):
            if not left:
                return right
            if not right:
                return left
            
            if left.val <= right.val:
                left.next = merge(left.next, right)
                return left
            else:
                right.next = merge(left, right.next)
                return right
            
        def recurringMergeKLists(lists, lo, hi):
            if lo > hi:
                return None
            if lo == hi:
                return lists[lo]
            mid = (lo + hi)//2
            left = recurringMergeKLists(lists, lo, mid)
            right = recurringMergeKLists(lists, mid + 1, hi)
            result = merge(left, right)
            return result
        
        return recurringMergeKLists(lists, 0, len(lists) - 1)