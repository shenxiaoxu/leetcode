'''
Given a non-negative integer represented as a linked list of digits, plus one to the integer.

The digits are stored such that the most significant digit is at the head of the list.
Input: head = [1,2,3]
Output: [1,2,4]
'''
class ListNode:
	def __init__(self, val = 0, next = None):
		self.val = val
		self.next = next
class Solution(object):
	def plus(self, head):
		stack = []
		worker_node = head#workernode is processing node
		while worker_node:
			stack.append(worker_node)
			worker_node = worker_node.next
		carry = 1
		while stack:
			cur = stack.pop()
			tmp = cur.val + carry
			cur.val = tmp%10
			carry = tmp//10
			if not carry:
				break;
		if carry == 1:
			newHead = ListNode(1)
			newHead.next = head
			return newHead
		return head
	def plusOne(self, head):#recursive method		
		def recurPlusOne(head):
			if not head.next:
				head.val = (head.val + 1)%10
				return 0 if head.val else 1
			remain = recurPlusOne(head.next) 
			tmp = head.val + remain
			head.val = tmp%10
			return tmp//10
		remain = recurPlusOne(head)	
		if remain:
			dummy = ListNode(1)
			dummy.next = head
			return dummy
		return head
	def plusTwo(self, head):#record last nine digit
		if not head: 
			return None
		dummy = ListNode(0)
		dummy.next = head
		process_node = head
		last_nine = dummy
		while process_node:
			if process_node.val != 9:
				last_nine = process_node
			process_node = process_node.next
		last_nine.val += 1
		last_nine = last_nine.next
		while last_nine:
			last_nine.val = 0
			last_nine = last_nine.next
		return dummy if dummy.val else dummy.next


if __name__ == "__main__":
	head = ListNode(9,ListNode(9, ListNode(9)))
	o = Solution()
	res = o.plus(head)
	while res:
		print(res.val)
		res = res.next
	head1 = ListNode(9,ListNode(9, ListNode(9)))
	res1 = o.plusOne(head1)
	while res1:
		print(res1.val)
		res1 = res1.next

	head2 = ListNode(9,ListNode(9, ListNode(9)))
	res2 = o.plusTwo(head2)
	while res2:
		print(res2.val)
		res2 = res2.next		

