/*
142. linked list cycleII
given a linked list, return the node where the cycle begins, if there is no cycle, return null.
follow up:
can you solve it without using extra space?
1-2-3-4-5-6   ---2


*/
import java.util.*;
class DetectCycle{
	public static void main(String[] args){
		ListNode node1 = new ListNode(1);
		ListNode node2 = new ListNode(2);
		ListNode node3 = new ListNode(3);
		ListNode node4 = new ListNode(4);
		ListNode node5 = new ListNode(5);
		ListNode node6 = new ListNode(6);
		node1.next = node2;
		node2.next = node3;
		node3.next = node4;
		node4.next = node5;
		node5.next = node6;
		node6.next = node5;
		ListNode result = detectCycle(node1);
		if(result == null){
			System.out.println("null");
		}else{
			System.out.println(result.val);
		}
	}
	public static ListNode detectCycle(ListNode root){
		ListNode fast = null;
		ListNode slow = null;
		ListNode previous = null;
		if(root == null){
			return null;
		}
		fast = root;
		slow = root;
		previous = root;
		boolean occur = false;
		while(previous != null){
			while(slow != null){
				slow = slow.next;
				if(fast == null){
					return null;
				}
				fast = fast.next;
				if(fast == null){
					return null;
				}
				fast = fast.next;
				if(fast == previous){
					occur = true;
				}				
				if(fast == slow && occur){
					return previous;
				}
				if(fast == slow && !occur){
					break;
				}

			}
			occur = false;
			previous = previous.next;
		}
		return null;
	}
}
