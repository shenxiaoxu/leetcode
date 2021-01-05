/*572. Subtree of Another Tree
Easy

1866

87

Add to List

Share
Given two non-empty binary trees s and t, check whether tree t has exactly the same structure and node values with a subtree of s. 
A subtree of s is a tree consists of a node in s and all of this node's descendants. The tree s could also be considered as a subtree of itself.
question:
1.first check root
2.recursive check left right and if it's wrong return false
3.improve time complexity, bottom up
4. if t1 is empty, is it also subtree of t2?
test
1,2,null, null, 3,4,null,null, null
*/
class SubtreeofAnotherTree572{
	//time complexity is logn, n is bigger size of t1 or t2.
	public boolean subtree(TreeNode t1, TreeNode t2){
		if(t1 == null && t2 == null) return true;
		if(t1 == null || t2 == null) return false;		
		if(t1.val == t2.val){
			if(check(t1.left, t2.left) && check(t1.right, t2.right)){return true;}
		}
		boolean left = subtree(t1, t2.left);
		boolean right = subtree(t1, t2.right);
		return left||right;
	}
	private boolean check(TreeNode t1, TreeNode t2){
		if(t1 == null && t2 == null) return true;
		if(t1 == null || t2 == null) return false;
		if(t1.val != t2.val) return false;
		return check(t1.left, t2.left) && check(t1.right, t2.right);
	}
}

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
    //time complexity is m*n, worst case is skewed tree
	public boolean isSubtree(TreeNode t1, TreeNode t2){
		return t1!= null &&(check(t1, t2) || isSubtree(t1.left, t2)||isSubtree(t1.right, t2));
	}
	private boolean check(TreeNode t1, TreeNode t2){
		if(t1 == null && t2 == null) return true;
		if(t1 == null || t2 == null) return false;
		if(t1.val != t2.val) return false;
		return check(t1.left, t2.left) && check(t1.right, t2.right);
	}
}
