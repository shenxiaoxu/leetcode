/*
114.flatten binary tree to linked list
given a binary tree, flatten it to linked list in place
1
2 , 5
3,4  6
1-2-3-4-5-6
*/
import java.util.*;
class Flatten{
	public static void main(String[] args){
		TreeNode root = new TreeNode(1);
		TreeNode root1 = new TreeNode(2);
		TreeNode root2 = new TreeNode(5);
		TreeNode root3 = new TreeNode(3);
		TreeNode root4 = new TreeNode(4);
		TreeNode root5 = new TreeNode(6);
		root.left = root1;
		root.right = root2;
		root1.left = root3;
		root1.right = root4;
		root2.right = root5;
		flatten(root);
		InorderTraversal traversal = new InorderTraversal();
		traversal.inorderTraversal(root);
	}
	public static void flatten(TreeNode root){
		LinkedList<TreeNode> line = new LinkedList<TreeNode>();
		TreeNode newStart = new TreeNode(root.val);
		TreeNode previous = newStart;

		line.add(root);
		while(line.size() != 0){
			TreeNode temp = line.pollFirst();
			System.out.println("temp: " + temp.val);
			newStart.right = new TreeNode(temp.val);
			newStart = newStart.right;
			System.out.println("newStart: " + newStart.val);
			if(temp.right != null){
				//System.out.println("temp right: " + temp.right.val);
				line.addFirst(temp.right);
			}
			if(temp.left != null){
				//System.out.println("temp left: " + temp.left.val);
				line.addFirst(temp.left);
			}
		}
		root = previous.right;
	}
}