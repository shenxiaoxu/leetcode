/*
61.rotate list
given a linkedlist, rotate the list to the right by k places, where k is not-negative.
in:1-2-3-4-5 k = 2
out:4-5-1-2-3
in:0-1-2 k = 4
out:2-0-1
solution:
solution:
from k%linklistlength + 1 to null
k%linklistlength + 1.next to start
*/
class RotateRight{
	public static void main(String[] args){
		ListNode first = new ListNode(1);
		ListNode second = new ListNode(2);
		ListNode third = new ListNode(3);
		ListNode fourth = new ListNode(4);
		ListNode fifth = new ListNode(5);
		first.next = second;
		second.next = third;
		third.next = fourth;
		fourth.next = fifth;

		ListNode head = rotateRight(first, 7);
		while(head != null){
			System.out.println(head.val);
			head = head.next;
		}
	}
	public static ListNode rotateRight(ListNode head, int k){
		ListNode start = head;
		ListNode slow;
		int number = 0;
		while(head != null){
			head = head.next;
			number++;
		}
		number = k%number;
		System.out.println("number" + number);
		head  = start;
		slow = head;
		while(number != 0){
			head = head.next;
			number--;
		}
		while(head.next != null){
			slow = slow.next;
			head = head.next;
		}
		head.next = start;
		start = slow.next;
		slow.next = null;

		return start;
	}
}

