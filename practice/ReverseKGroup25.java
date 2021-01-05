/*
25.reverse nodes in k-group
given a linked list, reverse nodes of linked list k at a time and return its modified list

1-2-3-4-5
k = 2  return 2-1-4-3-5
k = 3  return 3-2-1-4-5
*/
class ReverseKGroup{
	public static void main(String[] args){
		ListNode first= new ListNode(1);
		ListNode second= new ListNode(2);
		ListNode third= new ListNode(3);
		ListNode fourth= new ListNode(4);
		ListNode fifth= new ListNode(5);
		first.next = second;
		second.next = third;
		third.next = fourth;
		fourth.next = fifth;
		ListNode start = reverseKGroup(first, 2);
		while(start != null){
			System.out.println(start.val);
			start = start.next;
		}
	}
	public static ListNode reverseKGroup(ListNode head, int k){
		if(head==null || k==1) return head;
		ListNode dummy = new ListNode(-1);
		ListNode pre, cur;
		cur = head;
		int count = 0;
		dummy.next = head;
		pre = dummy;
		while(cur != null){
			count++;
			if(count % k == 0){
				pre = reverse(pre, cur.next);
				cur = pre.next;
			}else{
				cur = cur.next;
			}
			
		}
		return dummy.next;
	}
	public static ListNode reverse(ListNode pre, ListNode next){
		ListNode last = pre.next;
		ListNode cur = last.next;
		while(cur != next){
			last.next = cur.next;
			cur.next = pre.next;
			pre.next = cur;
			cur = last.next;
		}
		return last;
	}
	
}