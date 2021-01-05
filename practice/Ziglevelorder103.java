/*
103. binary tree zigzag level order traversal
[3,9,20,null,null,15,7]
[
[3]
[20,9]
[15,7]
]
*/
import java.util.*;
class Zigzaglevelorder{
	public static void main(String[] args){
		TreeNode root = new TreeNode(3);
		TreeNode root1 = new TreeNode(9);
		TreeNode root2 = new TreeNode(20);
		TreeNode root3 = new TreeNode(15);
		TreeNode root4 = new TreeNode(7);
		root.left = root1;
		root.right = root2;
		root2.left = root3;
		root2.right = root4;
		System.out.println(zigzaglevelorder(root));
	}
	public static LinkedList<LinkedList<Integer>> zigzaglevelorder(TreeNode root){
		LinkedList<TreeNode> level = new LinkedList<TreeNode>();
		LinkedList<TreeNode> nextlevel = new LinkedList<TreeNode>();
		LinkedList<LinkedList<Integer>> results = new LinkedList<LinkedList<Integer>>();
		level.add(root);
		while(level.size() != 0 || nextlevel.size() != 0){
			LinkedList<Integer> result = new LinkedList<Integer>();
			while(level.size() != 0){
				TreeNode element = level.poll();
				if(element == null){
					break;
				}
				result.add(element.val);
				if(element.left != null){
					nextlevel.add(element.left);
				}
				if(element.right != null){
					nextlevel.add(element.right);
				}
			}
			if(result.size() != 0){
				results.add(result);
			}
			LinkedList<Integer> result2 = new LinkedList<Integer>();
			while(nextlevel.size() != 0){
				TreeNode element = nextlevel.poll();
				if(element == null){
					break;
				}
				result2.addFirst(element.val);
				if(element.left != null){
					level.add(element.left);
				}
				if(element.right != null){
					level.add(element.right);
				}				
			}
			if(result2.size() != 0){
				results.add(result2);
			}
		}
		return results;
	}
}