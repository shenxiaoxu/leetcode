'''
Given a linked list, swap every two adjacent nodes and return its head.

You may not modify the values in the list's nodes. Only nodes itself may be changed.
'''
class ListNode:
	def __init__(self, val = 0, next = None):
		self.val = val
		self.next = next
class Solution:
	def swap(self, head: ListNode)->ListNode:
		def recursiveReverse(head):
			if not head or not head.next:
				return head
			next = head.next
			then = next.next
			next.next = head
			head.next = recursiveReverse(then)
			return next
		res = recursiveReverse(head)
		return res
if __name__ == "__main__":
	head = ListNode(1, ListNode(2, ListNode(3, ListNode(4))))
	o = Solution()
	head = ListNode(1, ListNode(2, ListNode(3)))
	res = o.swap(head)
	while res:
		print(res.val)
		res = res.next
