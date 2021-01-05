/*92. Reverse Linked List II

Reverse a linked list from position m to n. Do it in one-pass.

Note: 1 ≤ m ≤ n ≤ length of list.

Example:

Input: 1->2->3->4->5->NULL, m = 2, n = 4
Output: 1->4->3->2->5->NULL
*/
class ReverseBetween92 {
    public ListNode reverseBetween(ListNode head, int m, int n) {
    	if(head == null) return null;
        ListNode pre = null;
        ListNode cur = head;
        ListNode third;
        while(m > 1){
        	pre = cur;
        	cur = cur.next;
        	m--;
        	n--;
        }
        ListNode con = pre;
        ListNode tail = cur;
        while(n > 0){
        	third = cur.next;
        	cur.next = pre;
        	pre = cur;
        	cur = third;
        	n--;
        }

        if(con != null){
        	con.next = pre;
        }else{
        	head = pre;
        }
        tail.next = cur;
        return head;
    }
}