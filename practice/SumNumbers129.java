/*
129.sum root to leaf numbers
given a binary tree containing digits from 0-9, each root to leaf path could represent a number.
find total sum of all root-to-leaf numbers.
1
2 3
out:25 12+13
  4
9   0
5 1  1   1387 495+491+401

*/
class SumNumbers{
	public static void main(String[] args){
		TreeNode node1 = new TreeNode(4);
		TreeNode node2 = new TreeNode(9);
		TreeNode node3 = new TreeNode(0);
		TreeNode node4 = new TreeNode(5);
		TreeNode node5 = new TreeNode(1);
		TreeNode node6 = new TreeNode(1);
		node1.left = node2;
		node1.right = node3;
		node2.left = node4;
		node2.right = node5;
		node3.right = node6;
		System.out.println(sumNumbers(node1, 0, 0));
	}
	public static int sumNumbers(TreeNode root, int sum, int number){
		
		if(root.left == null && root.right == null){
			number = number * 10 + root.val;
			sum += number;
			return sum;
		}
		int sum1 = 0;
		int sum2 = 0;
		number = number * 10 + root.val;
		System.out.println("number: " + number);
		if(root.left != null){
			sum1 = sumNumbers(root.left, sum, number);
		}
		if(root.right != null){
			sum2 = sumNumbers(root.right, sum, number);
		}
		return sum1+ sum2;
	}
}