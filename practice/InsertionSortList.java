/*
sort a linked list using insertion sort
in:4-2-1-3
out:1-2-3-4
in: -1-5-3-4-0
out:-1-0-3-4-5
*/
class InsertionSortList{
	public static void main(String[] args){
		ListNode first = new ListNode(4);
		ListNode second = new ListNode(2);
		ListNode third = new ListNode(1);
		ListNode fourth = new ListNode(3);
		first.next = second;
		second.next = third;
		third.next = fourth;
		ListNode start = insertionSortList(first);
		while(start != null){
			System.out.println(start.val);
			start = start.next;
		}
	}
	public static ListNode insertionSortList(ListNode node){
		ListNode result = new ListNode(0);
		ListNode helper = result;
		ListNode next = null;
		ListNode cur = node;
		while(cur != null){
			next = cur.next;
			if(helper.next == null || helper.next.val > cur.val){helper = result;}
			while(helper.next != null && helper.next.val < cur.val){
				helper = helper.next;
			}
			cur.next = helper.next;
			helper.next = cur;
			cur = next;	
		}
		return result.next;
	}
}