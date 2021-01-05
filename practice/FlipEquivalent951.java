/*
951. Flip Equivalent Binary Trees
Medium

For a binary tree T, we can define a flip operation as follows: choose any node, and swap the left and right child subtrees.

A binary tree X is flip equivalent to a binary tree Y if and only if we can make X equal to Y after some number of flip operations.

Write a function that determines whether two binary trees are flip equivalent.  The trees are given by root nodes root1 and root2.

 

Example 1:

Input: root1 = [1,2,3,4,5,6,null,null,null,7,8], root2 = [1,3,2,null,6,4,5,null,null,null,null,8,7]
 1         1 
2   3     3 2
45 6       6 45
 7 8     8 7 
Output: true
Explanation: We flipped at nodes with values 1, 3, and 5.
Flipped Trees Diagram
 

Note:

Each tree will have at most 100 nodes.
Each value in each tree will be a unique integer in the range [0, 99].
 

*/
import java.util.*;
class FlipEquivalent951{
	public static void main(String[] args){
		TreeNode node1 = new TreeNode(1);
		TreeNode node2 = new TreeNode(2);
		TreeNode node3 = new TreeNode(3);
		TreeNode node4 = new TreeNode(4);
		TreeNode node5 = new TreeNode(5);
		TreeNode node6 = new TreeNode(6);
		TreeNode node7 = new TreeNode(7);
		TreeNode node8 = new TreeNode(8);
		

		node1.left = node2;
		node1.right = node3;
		node2.left = node4;
		node2.right = node5;
		node5.left = node7;
		node3.left = node6;
		node6.left = node8;


		TreeNode node21 = new TreeNode(1);
		TreeNode node22 = new TreeNode(2);
		TreeNode node23 = new TreeNode(3);
		TreeNode node24 = new TreeNode(4);
		TreeNode node25 = new TreeNode(5);
		TreeNode node26 = new TreeNode(6);
		TreeNode node27 = new TreeNode(7);
		TreeNode node28 = new TreeNode(8);
		
		//node21.left = node22;
		//node22.left = node23;
		

		node21.left = node23;
		node21.right = node22;
		node22.left = node24;
		node22.right = node25;
		node25.right = node27;
		node23.right = node26;
		node26.right = node28;

		Stack<TreeNode> path1 = new Stack<TreeNode>();
		Stack<TreeNode> path2 = new Stack<TreeNode>();	
		FlipEquivalent951 flip = new FlipEquivalent951();	
		System.out.println(flip.flipEquivalent951Solution2(node1, node21));
	}
	public boolean flipEquivalent951(TreeNode root1, TreeNode root2, Stack<TreeNode> path1, Stack<TreeNode> path2){
		if(root1 == null && root2 == null){
			return true;
		}

		if(root1 != null && root2 != null &&root1.val == root2.val){
			path1.push(root1);
			path2.push(root2);
			boolean left = flipEquivalent951(root1.left, root2.left, path1, path2);
			boolean right = flipEquivalent951(root1.right, root2.right, path1, path2);
			if(left && right){
				return true;
			}
		}

		if(root1!= null && root1.visited == true){
			return false;
		}
		if((root1 == null && root2 != null) ||(root1 != null && root2 == null)||(root1.val != root2.val)){
			if(path1.empty() || path2.empty()){
				return false;
			}
			root1 = path1.pop();
			root2 = path2.pop();
			TreeNode temp;
			temp = root1.left;
			root1.left = root1.right;
			root1.right = temp;
			root1.visited = true;
		}

		boolean left = flipEquivalent951(root1.left, root2.left, path1, path2);
		boolean right = flipEquivalent951(root1.right, root2.right, path1, path2);
		if(left && right){
			return true;
		}else{		
			return false;
		}
	}
	public boolean flipEquivalent951Solution2(TreeNode root1, TreeNode root2){
		if(root1 == root2){
			return true;
		}
		if(root1 == null || root2 == null || root1.val != root2.val){
			return false;
		}
		return (flipEquivalent951Solution2(root1.left, root2.left)&& flipEquivalent951Solution2(root1.right, root2.right)) || 
				(flipEquivalent951Solution2(root1.left, root2.right)&& flipEquivalent951Solution2(root1.right, root2.left));
	}
}
