/*
82. Remove Duplicates from Sorted List II

Given a sorted linked list, delete all nodes that have duplicate numbers, leaving only distinct numbers from the original list.

Example 1:

Input: 1->2->3->3->4->4->5
Output: 1->2->5
Example 2:

Input: 1->1->1->2->3
Output: 2->3
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
    public ListNode deleteDuplicates(ListNode head) {
		ListNode dummy = new ListNode(0);
		ListNode pre, cur, realnode;
		ListNode next;
		pre = null;
		cur = head;
		realnode = dummy;
		while(cur != null){
			if((pre == null || pre.val != cur.val) && (cur.next == null || cur.next.val != cur.val)){
				realnode.next = cur;
				realnode = cur;
			}
			pre = cur;
			cur = cur.next;
			pre.next = null;
		}
		return dummy.next;        
    }
}