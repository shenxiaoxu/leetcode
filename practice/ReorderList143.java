/*
143. reorder list
given a singly linked list: L:l0-l1->....Ln
reorder it to L0-ln-l1-ln-1
given 1-2-3-4 reorder it 1-4-2-3
given 1-2-3-4-5 reorder it to 1-5-2-4-3
*/
import java.util.*;
class ReorderList{
	public static void main(String[] args){
		ListNode node1 = new ListNode(1);
		ListNode node2 = new ListNode(2);
		ListNode node3 = new ListNode(3);
		ListNode node4 = new ListNode(4);

		node1.next = node2;
		node2.next = node3;
		node3.next = node4;

		ListNode temp = ReorderList(node1);
		while(temp!= null){
			System.out.println(temp.val);
			temp = temp.next;
		}
	}
	public static ListNode ReorderList(ListNode root){
		int length = 0;
		ListNode head=root;
		LinkedList<ListNode> list = new LinkedList<ListNode>();
		ListNode temp;
		while(head != null){
			temp = new ListNode(head.val);
			length++;		
			list.add(temp);
			head = head.next;
		}
		//System.out.println("length: " + length);
		int mid = length/2;	
		if(length %2 == 1){
			mid = mid + 1;
		}
		int count = 0;
		int index = 0;
		ListNode newHead = root;
		ListNode result = root;
		while(mid != 0){
			newHead = list.get(index);
			temp = new ListNode(newHead.val);
			result.next = temp;
			result = result.next;
			System.out.println("result1: " + result.val);
			count++;
			if(count == length){
				break;
			}
			ListNode node2 = list.pollLast();
			//System.out.println("stack: " + node2.val);
			temp = new ListNode(node2.val);
			result.next = temp;
			result = result.next;
			System.out.println("result2: " + result.val);
			
			mid--;
			count++;
			index++;
		}
		return root.next;
	}
}