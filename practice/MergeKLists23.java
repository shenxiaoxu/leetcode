/*
23. merge k sorted lists
merge k sorted linkedlist and return it as one sorted list. analyze and describe its complexity.
in
[
1-4-5
1-3-4
2-6
]
out
1-1-2-3-4-4-5-6
*/
class MergeKLists{
	public static void main(String[] args){
		ListNode first = new ListNode(1);
		ListNode second = new ListNode(4);
		ListNode third = new ListNode(5);
		first.next = second;
		second.next = third;
		ListNode first1 = new ListNode(1);
		ListNode second1 = new ListNode(3);
		ListNode third1 = new ListNode(4);
		first1.next = second1;
		second1.next = third1;
		ListNode first2 = new ListNode(2);
		ListNode second2 = new ListNode(6);
		first2.next = second2;
		ListNode[] lists = new ListNode[3];
		lists[0] = first;
		lists[1] = first1;
		lists[2] = first2;
		ListNode result = mergeKLists(lists);
		while(result != null){
			System.out.println(result.val);
			result = result.next;
		}				
	}
	public static ListNode mergeKLists(ListNode[] lists){
		int length = lists.length;
		int interval = 1;
		while(interval < length){
			for(int i = 0; i <= (length/interval); i=i+2){
				ListNode l1 = lists[i*interval];
				if(i*interval + interval >= length){
					continue;
				}
				ListNode l2 = lists[i*interval + interval];
				ListNode result = mergeTwoLists(l1, l2);
				lists[i*interval] = result;	
			}
			interval = interval * 2;
		}
		return lists[0];
	}
	public static ListNode mergeTwoLists(ListNode l1, ListNode l2){
		ListNode head, start;
		head = new ListNode(0);
		start = head;
		while(l1 != null && l2 != null){
			if(l1.val < l2.val){
				head.next = l1;
				l1 = l1.next;
			}else{
				head.next = l2;
				l2 = l2.next;
			}
			head = head.next;
		}
		if(l1 == null){
			head.next = l2;
		}
		if(l2 == null){
			head.next = l1;
		}
		return start.next;
	}
}