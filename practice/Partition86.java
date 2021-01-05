/*
86.partition list
given a linked list and a value x, partition it such that all nodes  less than x come before nodes greater than or equal to x.
preserve original relative order of nodes in each of two partitions
in:1-4-3-2-5-2 x = 3
out:1-2-2-4-3-5
*/
class Partition{
	public static void main(String[] args){
		ListNode first = new ListNode(1);
		ListNode second = new ListNode(4);
		ListNode third = new ListNode(3);
		ListNode fourth = new ListNode(2);
		ListNode fifth = new ListNode(5);
		ListNode sixth = new ListNode(2);
		first.next = second;
		second.next = third;
		third.next = fourth;
		fourth.next = fifth;
		fifth.next = sixth;
		first = partition(first, 3);
		while(first != null){
			System.out.println(first.val);
			first = first.next;
		}
	}
	public static ListNode partition(ListNode head, int target){
		if(head == null){
			return null;
		}
		ListNode start = head;
		ListNode previous = head;
		while(start != null){
			if(start.val >= target){
				break;
			}
			previous = start;
			start = start.next;
		}
		System.out.println("start " + start.val + "previous " + previous.val);
		ListNode previous2 = start;
		while(start != null){
			if(start.val < target){
				ListNode temp = new ListNode(start.val);
				temp.next = previous.next;
				previous.next = temp;
				previous = temp;
				previous2.next = start.next;
				start = start.next;
				if(start != null){
					System.out.println("start " + start.val + "previous " + previous.val + "previous2 " + previous2.val);
				}
			}else{
				previous2 = start;
				start = start.next;
			}
						
		}
		return head;
	}	
}