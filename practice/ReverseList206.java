/*206. Reverse Linked List

Reverse a singly linked list.

Example:

Input: 1->2->3->4->5->NULL
Output: 5->4->3->2->1->NULL
Follow up:

A linked list can be reversed either iteratively or recursively. Could you implement both?
attention:
pre = curr;
curr = next;
*/
class ReverseList206{
    public ListNode reverseList(ListNode head) {
        ListNode pre = null;
        ListNode curr = head;
        while(curr != null){
        	ListNode next = curr.next;
        	curr.next = pre;        	
        	pre = curr;
        	curr = next;
        }
        return pre;
    }
    public ListNode reverseListIter(ListNode head){
    	if(head == null || head.next == null) return head;
    	ListNode p = reverseListIter(head.next);
    	head.next.next = head;
    	head.next = null;
    	return p;
    }	
}