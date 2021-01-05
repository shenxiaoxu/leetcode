/*
113.path sumII
given a bianry tree and a sum, find all root to leaf paths where each path's sum equals the given sum.
5
4 8
11   13 4
7 2      5 1

22

[
[5,4,11,2],
[5,8,4,5]
]
*/
import java.util.*;
class PathSum{
	public static void main(String[] args){
		TreeNode root = new TreeNode(5);
		TreeNode root1 = new TreeNode(4);
		TreeNode root2 = new TreeNode(8);
		TreeNode root3 = new TreeNode(11);
		TreeNode root4 = new TreeNode(13);
		TreeNode root5 = new TreeNode(4);
		TreeNode root6 = new TreeNode(7);
		TreeNode root7 = new TreeNode(2);
		TreeNode root8 = new TreeNode(5);
		TreeNode root9 = new TreeNode(1);
		root.left = root1;
		root.right = root2;
		root1.left = root3;
		root2.left = root4;
		root2.right = root5;
		root3.left = root6;
		root3.right = root7;
		root5.left = root8;
		root5.right = root9;
		LinkedList<LinkedList<Integer>> results = new LinkedList<LinkedList<Integer>>();
		pathSum(root, new LinkedList<Integer>(), results, 0, 22);
		System.out.println(results);

	}
	public static void pathSum(TreeNode root, LinkedList<Integer> result, LinkedList<LinkedList<Integer>> results, int temp, int target){


		if(temp> target){
			return;
		}
		if(temp == target && root == null){
			if(results.indexOf(result) == -1){
				results.add(new LinkedList<Integer>(result));
			}
			return;
		}

		if(root == null){
			return;
		}
		result.add(root.val);
		temp += root.val;
		
		pathSum(root.left, result, results, temp, target);	
		pathSum(root.right, result, results, temp, target);	
		
		result.pollLast();
		temp -= root.val;
	} 
}