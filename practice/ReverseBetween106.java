/*
106.reverse a linked list from position m to n. do it in one-pass.
in:1-2-3-4-5 m= 2 n = 4
out:1-4-3-2-5
*/
class ReverseBetween{
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
		int m = 2;
		int n = 4;
		reverseBetween(first, m, n);
		while(first != null){
			System.out.println(first.val);
			first = first.next;
		}
	}
	public static void reverseBetween(ListNode head, int m, int n){
		ListNode mIndex = head;
		ListNode start = head;
		ListNode previous = head;
		if(head == null){
			return;
		}
		ListNode next = head.next;
		ListNode mIndexStart = head;
		int count = 1;
		while(start != null){
			//System.out.println("Start: " + start.val + "previous: " + previous.val + "mIndexStart: " + mIndexStart.val + "mIndex: " + mIndex.val);
			if(count == m){
				mIndex = previous;
				mIndexStart = start;
			}
			if(count == n){
				start.next = previous;
				mIndex.next = start;
				mIndexStart.next = next;
			}
			if(count > m && count < n){
				start.next = previous;
				previous = start;
				start = next;				
				next = start.next;
				count++;
				continue;
			}
			previous = start;
			start = next;			
			if(start == null){
				break;
			}
			next = start.next;
			count++;
		}
	}
}