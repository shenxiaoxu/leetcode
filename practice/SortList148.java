/*
148.sort list
sort linked list in o(nlogn) time using constatn space complexity
in:4-2-1-3
out:1-2-3-4
*/
class SortList{
	public static void main(String[] args){
		ListNode first = new ListNode(4);
		ListNode second = new ListNode(1);
		ListNode third = new ListNode(2);
		ListNode fourth = new ListNode(3);
		first.next = second;
		second.next = third;
		third.next = fourth;
		ListNode root = sortList(first);
		while(root != null){
			System.out.println(root.val);
			root = root.next;
		}
	}
	public static ListNode sortList(ListNode root){
		if(root == null || root.next == null){
			return root;
		}
		ListNode slow=root;
		ListNode fast=root;
		ListNode previous = root;
		ListNode result;
		while(fast != null && fast.next != null){
			previous = slow;
			slow = slow.next;
			fast = fast.next;
			fast = fast.next;
		}
		previous.next = null;
		
		ListNode left = sortList(root);
		ListNode right = sortList(slow);
		result = merge(left, right);
		return result;
	}
	public static ListNode merge(ListNode left, ListNode right){
		if(left == null){
			return right;
		}
		if(right == null){
			return left;
		}
		ListNode result = new ListNode(0);
		ListNode head = result;
		while(left != null || right != null){
			if(left == null){
				result.next = right;
				break;
			}
			if(right == null){
				result.next = left;
				break;
			}
			if(left.val < right.val){
				result.next = left;
				left = left.next;
			}else{
				result.next = right;
				right = right.next;
			}
			result = result.next;
		}
		return head.next;
	}
}