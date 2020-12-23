#!/usr/bin/env python
# -*- coding: utf-8 -*-
'''
92. Reverse Linked List II
Medium

Reverse a linked list from position m to n. Do it in one-pass.

Note: 1 ≤ m ≤ n ≤ length of list.

Example:

Input: 1->2->3->4->5->NULL, m = 2, n = 4
Output: 1->4->3->2->5->NULL
'''
class ListNode:
	def __init__(self, val = 0, next = None):
		self.next = next
		self.val = val
class Solution:
	def reverseBetween(self, head:ListNode, m:int, n:int)->ListNode:
		dummy = ListNode(0)
		dummy.next = head
		midx, nidx, premidx, pre, cur = None, None, None, dummy, head
		count = 0
		if m == n: 
			return head
		while cur:
			nex = cur.next
			if count == m - 1:
				midx = cur
				premidx = pre
			elif m<= count < n:
				cur.next = pre
				if count == m:
					pre.next = None
				if count == n - 1:
					nidx = cur
			elif count == n:					
				midx.next = cur
				premidx.next = nidx
				break	
			pre = cur
			cur = nex
			count += 1						
		if count == n and not cur:
			midx.next = None
			premidx.next = nidx
		return dummy.next
	def reverseBetweenTwo(self, head:ListNode, m:int, n:int)->ListNode:
		dummy = ListNode(0)
		dummy.next = head
		pre = dummy
		for i in range(m - 1):
			pre = pre.next
		start = pre.next
		then = start.next
		for i in range(n - m):
			start.next = then.next
			then.next = pre.next
			pre.next = then
			then = start.next
		return dummy.next

if __name__ == "__main__":
	res = [1,2,3,4,5]
	root = ListNode(1, ListNode(2, ListNode(3, ListNode(4, ListNode(5)))))
	o = Solution()
	root = o.reverseBetweenTwo(root, 2, 4)
	while root:
		print("res" + str(root.val))
		root = root.next

