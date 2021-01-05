/*
19.remove nth node from end of list
given a linked list, remove the nth node from the end of list and return its head.
in:1-2-3-4-5 n = 2
out:1-2-3-5
do it in one pass
*/
class RemoveNthFromEnd{
	public static ListNode removeNthFromEnd(ListNode head, int n){
		if(head == null) return null;
		ListNode index,start;
		start = head;
		index = head;
		int track = n;
		while(start.next != null){
			if(track == 0){
				index = head;
				break;
			}
			start = start.next;
			track--;
		}
		if(start == null) return head;
		while(start.next != null){
			start = start.next;
			index = index.next;
		}
		//System.out.println(index.val + "" + index.next.val +"" +index.next.next.val);
		index.next = index.next.next;
		//System.out.println(index.val + "" + index.next.val);
		//start = index;
		return head;
	}
	public static void main(String[] args){
		ListNode a = new ListNode(1);
		ListNode b = new ListNode(2);
		ListNode c = new ListNode(3);
		ListNode d = new ListNode(4);
		ListNode e = new ListNode(5);
		a.next = b;
		b.next = c;
		c.next = d;
		d.next = e;
		e.next = null;
		ListNode result;
		result = removeNthFromEnd(a,2);
		while(result != null){
			System.out.println(result.val);
			result = result.next;
		}
	}	
}