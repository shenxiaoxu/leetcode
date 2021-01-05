/*
109. convert sorted list to binary search tree
height balanced BST.
a height-balanced binary tree is defined as binary tree which depth of two subtrees of every node never idffer by more than 1.
given sorted linked list [-10,-3,0,5,9]
[0,-3,9,-10,null,5]
public TreeNode sortedListToBST(ListNode head)
*/
class SortedListToBST{
	public static void main(String[] args){
		ListNode first = new ListNode(-10);
		ListNode second = new ListNode(-3);
		ListNode third = new ListNode(0);
		ListNode fourth = new ListNode(5);
		ListNode fifth = new ListNode(9);
		first.next = second;
		second.next = third;
		third.next = fourth;
		fourth.next = fifth;
		TreeTraversal traversal = new TreeTraversal();
		traversal.inorderTraversal(sortedListToBST(first, 0, 4));
	}
	public static TreeNode sortedListToBST(ListNode head, int start, int end){
		if(start > end){
			return null;
		}
		if(head == null){
			return null;
		}
		ListNode leftPart = head;
		int pivot = (start + end)/2;
		int count = start;
		while(leftPart != null){
			if(count == pivot){
				break;
			}
			leftPart = leftPart.next;
			count++;
		}
		TreeNode root = new TreeNode(leftPart.val);
		root.left = sortedListToBST(head, start, pivot - 1);
		root.right = sortedListToBST(leftPart.next, pivot + 1, end);
		return root;
	}
}