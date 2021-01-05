/*
24.Swap Nodes in Pairs
given alinked list, swap every two adjacent nodes and return its head.
given 1-2-3-4,you should return the list as 2-1-4-3
algrithm should use only constant extra space.
may not modify the values in the list nodes, only nodes itself may be changed.
previous , current, next
current.next = start;
previous.next = next;
current = next.next;
previous = next;
*/
class SwapPairs{
	public static void main(String[] args){
		ListNode a = new ListNode(1);
		ListNode b = new ListNode(2);
		ListNode c = new ListNode(3);
		ListNode d = new ListNode(4);
		a.next = b;
		b.next = c;
		c.next = d;
		a = swapPairs(a);
		while(a != null){
			System.out.println(a.val);
			a = a.next;
		}
	}
	public static ListNode swapPairs(ListNode head){
		ListNode headNew = head;
		ListNode current,next;
		ListNode previous;
		if(head.next != null){
			previous = head;
			current = head.next;
			next = current.next;
			headNew = current;
		}else{
			return headNew;
		}
		while(current != null){
			current.next = previous;
			previous.next = next;
			if(next == null){
				break;
			}else{
				current = next.next;
				previous.next = current;
				if(current == null){
					previous.next = next;
				}
			}
			previous = next;
			if(current == null){
				break;
			}
			next = current.next;
		}
		return headNew;
	}
}