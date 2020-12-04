class Solution {
	public TreeNode increasingBST(TreeNode root){
		if(root == null) return null;
		TreeNode[] arr = recuring(root);
		return arr[0];
	} 
	private TreeNode[] recuring(TreeNode root){
        TreeNode first = root, last = root;
        if(root == null) return new TreeNode[]{first, last};
		if(root.left == null && root.right == null) return new TreeNode[]{root, root};
		TreeNode[] left = recuring(root.left);
        if(left[0] != null) first = left[0];
        if(left[1] != null) left[1].right = root; 
        root.left = null;
		TreeNode[] right = recuring(root.right);
        if(right[0] != null) root.right = right[0];
        if(right[1] != null) last = right[1];
		return new TreeNode[]{first, last};
	}
}
