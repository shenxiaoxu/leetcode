/*543. Diameter of Binary Tree
Easy

2256

144

Add to List

Share
Given a binary tree, you need to compute the length of the diameter of the tree. 
The diameter of a binary tree is the length of the longest path between any two nodes in a tree. This path may or may not pass through the root.

Example:
Given a binary tree 
          1
         / \
        2   3
       / \     
      4   5    
Return 3, which is the length of the path [4,2,1,3] or [5,2,1,3].

Note: The length of path between two nodes is represented by the number of edges between them.*/


/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public int diameterOfBinaryTree(TreeNode root) {
        if(root == null) return 0;
        int max = 0;
        int result = rDiameterOfBinaryTree(root, max);
        return Math.max(max, result);
    }
    private int rDiameterOfBinaryTree(TreeNode root, int max){
    	if(root == null) return 0;
    	int left = 0;
    	int right = 0;
    	if(root.left != null){
    		left = rDiameterOfBinaryTree(root.left) + 1;
    	}
    	if(root.right != null){
    		right = rDiameterOfBinaryTree(root.right, max) + 1;
    	}
    	max = Math.max(left + right, max);
    	return Math.max(left, right);
    }
}