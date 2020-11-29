'''
1669. Merge In Between Linked Lists
You are given two linked lists: list1 and list2 of sizes n and m respectively.

Remove list1's nodes from the ath node to the bth node, and put list2 in their place.

The blue edges and nodes in the following figure incidate the result:
Input: list1 = [0,1,2,3,4,5], a = 3, b = 4, list2 = [1000000,1000001,1000002]
Output: [0,1,2,1000000,1000001,1000002,5]
Explanation: We remove the nodes 3 and 4 and put the entire list2 in their place. The blue edges and nodes in the above figure indicate the result.

'''
class ListNode:
	def __init__(self, val = 0, nex = None):
		self.val = val
		self.nex = nex

class Solution(object):
	def mergeInBetween(self, n1, a, b, n2):
            p1, p2, c, head = None, None, 0, None
            head = n1

            while c != a - 1:
                n1 = n1.next
                c += 1
            p1 = n1
                      
            while c != b:
                n1 = n1.next
                c += 1
            p2 = n1.next
            p1.next = n2

            while p1.next:
                p1 = p1.next
            print(p1.val)
            p1.next = p2
        
            return head

