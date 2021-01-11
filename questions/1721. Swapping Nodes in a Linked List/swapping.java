/*
You are given the head of a linked list, and an integer k.

Return the head of the linked list after swapping the values of the kth node from the beginning and 
the kth node from the end (the list is 1-indexed).
*/
class Solution {
    public ListNode swapNodes(ListNode head, int k) {
        ListNode first= null, second = null;
        int count = k;
        ListNode fast = head;
        while(count != 1){
            count -= 1;
            fast = fast.next;
        }
        first = fast;
        ListNode slow = head;
        while(fast.next != null){
            fast = fast.next;
            slow = slow.next;
        }
        second = slow;
        int tmp = first.val;
        first.val = second.val;
        second.val = tmp;
        return head;
    }
}