/*61. Rotate List
Medium

887

950

Add to List

Share
Given a linked list, rotate the list to the right by k places, where k is non-negative.

Example 1:

Input: 1->2->3->4->5->NULL, k = 2
Output: 4->5->1->2->3->NULL
Explanation:
rotate 1 steps to the right: 5->1->2->3->4->NULL
rotate 2 steps to the right: 4->5->1->2->3->NULL
Example 2:

Input: 0->1->2->NULL, k = 4
Output: 2->0->1->NULL
Explanation:
rotate 1 steps to the right: 2->0->1->NULL
rotate 2 steps to the right: 1->2->0->NULL
rotate 3 steps to the right: 0->1->2->NULL
rotate 4 steps to the right: 2->0->1->NULL
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
    public ListNode rotateRight(ListNode head, int k) {
        //base case
        if (head == null) return null;
        if(head.next == null) return head;
 		
 		//make linked list into ring
 		int n;
 		ListNode oldtail = head;
 		for(n = 1; oldtail.next != null; n++){
 			oldtail = oldtail.next;
 		}
 		oldtail.next = head;

 		//find rotate node, new tail is n - k%n - 1, new head is n - k%n
 		ListNode newtail = head;
 		ListNode newhead;
 		for(int i = 0; i < n - k%n - 1; i++){
 			newtail = newtail.next;
 		}
 		newhead = newtail.next;

 		//break the ring
 		newtail.next = null;

 		return newhead;
    }
}







