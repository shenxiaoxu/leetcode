/*25. Reverse Nodes in k-Group
Hard

1713

337

Add to List

Share
Given a linked list, reverse the nodes of a linked list k at a time and return its modified list.

k is a positive integer and is less than or equal to the length of the linked list. If the number of nodes is not a multiple of k then left-out nodes in the end should remain as it is.

Example:

Given this linked list: 1->2->3->4->5

For k = 2, you should return: 2->1->4->3->5

For k = 3, you should return: 3->2->1->4->5

Note:

Only constant extra memory is allowed.
You may not alter the values in the list's nodes, only nodes itself may be changed.*/
class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        int count = 0;
        ListNode curr = head;
        while(curr != null && count != k){//look for k+1 node
        	curr = curr.next;
        	count++;
        }

        if(count == k){//find K+ 1node
        	curr = reverseKGroup(curr, k);//curr new node, head is directed part

        	while(count-- > 0){//reverse k node list.
        		ListNode tmp = head.next;
        		head.next = curr;
        		curr = head;
        		head = tmp;
        	}
        	head = curr;
        }
        return head;

    }
}