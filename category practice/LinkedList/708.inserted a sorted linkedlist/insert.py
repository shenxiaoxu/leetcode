'''
708.inserted a sorted linkedlist
Given a node from a Circular Linked List which is sorted in ascending order, 
write a function to insert a value insertVal into the list such that it remains a sorted circular list. 
The given node can be a reference to any single node in the list, and may not be necessarily the smallest value in the circular list.

If there are multiple suitable places for insertion, you may choose any place to insert the new value. 
After the insertion, the circular list should remain sorted.

If the list is empty (i.e., given node is null), you should create a new single circular list and 
return the reference to that single node. Otherwise, you should return the original given node.
'''
class Solution:
	def insert(self, head:'Node', val: int)->'Node':
		node = Node(val)
		if not head:
			node.next = node
			return node
		if head.next==head:
			head.next = node
			node.next = head
			return head
		pre, cur = head, None
		
		while pre:
			cur = pre.next
			if (cur.val >= val and pre.val <= val) or (pre.val < val and cur.val < val and cur.val < pre.val) or (pre.val > val and cur.val > val and cur.val < pre.val) or cur == head:
				pre.next = node
				node.next = cur
				break
			else:
				pre = cur
		return head

if __name__ == "__main__":
	nums = [3,3,3]
	t = 0
	nums = [3,3,5]
	t = 0