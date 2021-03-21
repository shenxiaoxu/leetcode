'''
You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order, and each of their nodes contains a single digit. Add the two numbers and return the sum as a linked list.

You may assume the two numbers do not contain any leading zero, except the number 0 itself.
'''
# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def addTwoNumbers(self, l1: ListNode, l2: ListNode) -> ListNode:
        l3, carry = ListNode(0), 0
        head = l3
        while l1 or l2:
            val1 = l1.val if l1 else 0
            val2 = l2.val if l2 else 0
            val3 = (val1 + val2 + carry)%10
            carry = (val1 + val2 + carry)//10
            l3.next = ListNode(val3)
            l3 = l3.next
            if l1:
                l1 = l1.next
            if l2:
                l2 = l2.next
        if carry:
            l3.next = ListNode(1)
        return head.next