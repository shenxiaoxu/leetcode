/*
104. Maximum Depth of Binary Tree

Given a binary tree, find its maximum depth.

The maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.

Note: A leaf is a node with no children.

Example:

Given binary tree [3,9,20,null,null,15,7],

    3
   / \
  9  20
    /  \
   15   7
return its depth = 3.
*/
import java.util.*;
class MaxDepth104{
	public int maxDepth(TreeNode root){
		if(root == null) return 0;
		LinkedList<Integer> depths = new LinkedList<Integer>();
		LinkedList<TreeNode> stack = new LinkedList<TreeNode>();
		int current_depth = 0;
		int depth = 0;
		stack.add(root);
		depths.add(1);

		while(stack.size() != 0){
			root = stack.pollLast();
			current_depth = depths.pollLast();
			if(root != null){
				depth = Math.max(current_depth, depth);
				stack.add(root.left);
				stack.add(root.right);
				depths.add(current_depth + 1);
				depths.add(current_depth + 1);
			}
		}
		return depth;
	}
}