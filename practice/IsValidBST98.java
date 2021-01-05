/*
98.validate binary search tree
given binary tree, determine if it's a valid binary search tree
2-1-3 true
5-1-4-null-null-3- 6
*/
class IsValidBST{
	public static void main(String[] args){
		TreeNode root = new TreeNode(3);
		TreeNode root1 = new TreeNode(2);
		TreeNode root2 = new TreeNode(20);
		TreeNode root3 = new TreeNode(15);
		TreeNode root4 = new TreeNode(25);
		root.left = root1;
		root.right = root2;
		root2.left = root3;
		root2.right = root4;
		System.out.println(isValidBST(root));
	}
	public static boolean isValidBST(TreeNode root){
		if(root == null){
			return true;
		}
		if(root.left != null && root.left.val > root.val){
			return false;
		}
		if(root.right != null && root.right.val < root.val){
			return false;
		}
		return isValidBST(root.left) && isValidBST(root.right);		
	}
}