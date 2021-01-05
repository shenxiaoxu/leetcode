class TreeTraversal{
	public void inorderTraversal(TreeNode root){
		if(root == null){
			return;
		}
		System.out.println(root.val);
		if(root.left != null){
			inorderTraversal(root.left);
		}
		if(root.right != null){
			inorderTraversal(root.right);
		}
	}
}