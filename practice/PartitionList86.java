/*86. Partition List

Given a linked list and a value x, partition it such that all nodes less than x come before nodes greater than or equal to x.

You should preserve the original relative order of the nodes in each of the two partitions.

Example:

Input: head = 1->4->3->2->5->2, x = 3
Output: 1->2->2->4->3->5
*/
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode partition(ListNode head, int x) {
        if(head == null) return null;
        ListNode dummy = new ListNode(0);
        ListNode cur, pre;
        ListNode left;
        left = dummy;
        cur = head;
        pre = dummy;
        dummy.next = head;
        while(cur != null){
        	if(pre == left){
        		if(cur.val < x){
        			left = left.next;
        		}
        		pre = cur;
        		cur = cur.next;
        	}else{
        		if(cur.val >= x){
        			pre = cur;
        			cur = cur.next;
        		}else{
        			pre.next = cur.next;
        			cur.next = left.next;
        			left.next = cur;
        			left = left.next;
        			cur = pre.next;//attention cur is not get by cur.next, but by pre.next
        		}

        	}
        }
        return dummy.next;
    }
}