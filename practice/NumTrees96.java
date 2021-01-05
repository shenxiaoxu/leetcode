/*
96.unique binary search trees
given n ,how many unique bst's that store values 1..n
in:3
out:5
1 null 3 2 null
3 2 null 1 null
3 1 null null 2
2 1 3
1 null 2 3
*/
import java.util.*;
class NumTrees{
	public static void main(String[] args){
		int number = 3;
		LinkedList<TreeNode> result = generateTrees(1, number);
		System.out.println(result.size());
	}
	public static LinkedList<TreeNode> generateTrees(int start, int end){
		LinkedList<TreeNode> result = new LinkedList<TreeNode>();
		if(start > end){
			result.add(null);
			return result;
		}
		for(int i = start; i <= end; i++){
			LinkedList<TreeNode> leftChildren = generateTrees(start, i - 1);
			LinkedList<TreeNode> rightChildren = generateTrees(i + 1, end);
			for(TreeNode leftChild : leftChildren){
				for(TreeNode rightChild : rightChildren){
					TreeNode root = new TreeNode(i);
					root.left = leftChild;
					root.right = rightChild;
					result.add(root);
				}
			}			
		}
		return result;
	}
}