/*
82.remove duplicates from sorted list II
given a sorted linked list, delete all nodes that have duplicate numbers, leaving only distinct numbers from original list
in:1-2-3-3-4-4-5
out1-2-5
in:1-1-1-2-3
out2-3
*/
class DeleteDuplicates{
	public static void main(String[] args){
		ListNode first = new ListNode(1);
		ListNode second = new ListNode(1);
		ListNode third = new ListNode(1);
		ListNode fourth = new ListNode(1);
		ListNode fifth = new ListNode(1);
		ListNode sixth = new ListNode(2);
		ListNode seventh = new ListNode(3);
		first.next = second;
		second.next = third;
		third.next = fourth;
		fourth.next = fifth;
		fifth.next = sixth;
		sixth.next = seventh;
		first = deleteDuplicates(first);
		while(first != null){
			System.out.println(first.val);
			first = first.next;
		}
	}
	public static ListNode deleteDuplicates(ListNode head){
		if(head == null){
			return null;
		}
		ListNode start = head;
		ListNode previous = head;
		ListNode next = start.next;
		while(start != null && next != null){
			if(next.val == start.val){
				while(next.val == start.val){
					next = next.next;
				}
				if(previous.val == start.val){
					previous = next;
					start = next;
					next = start.next;
					head = previous;
					System.out.println("head: " + head.val + "start: " + start.val);
				}else{
					start = next;
					previous.next = start;
					next = start.next;
				}
			}else{
				previous = start;
				start = next;
				next = start.next;
			}
		}
		return head;
		
	}
}