/*
106. give inorder and postorder, construct binary tree
inorder[9,3,15,20,7]
postorder[9,15,7,20,3]
3,9,20,null,null,15,7
*/
class BuildTreeII{
	public static void main(String[] args){
		int[] inorder = {9,3,15,20,7};
		int[] postorder = {9,15,7,20,3};
		TreeNode root = BuildTree(inorder, postorder, 0, inorder.length - 1, inorder.length - 1);
		TreeTraversal treetraversal = new TreeTraversal();
		treetraversal.inorderTraversal(root);
	}
	public static TreeNode BuildTree(int[] inorder, int[] postorder, int start, int end, int index){
	    if(start < 0 || start > end || index < 0 || end < 0){
	    	return null;
	    }
	    	
		int element = postorder[index];
		TreeNode root = new TreeNode(element);
		int inStart = 0;
		for(int i = 0; i < inorder.length;i++){
			if(inorder[i] == element){
				inStart = i;
			}
		}


		root.right = BuildTree(inorder, postorder, inStart + 1, end, index - 1);
		System.out.println("root.right:" + index);
		if(root.right != null){
			index -= end - inStart;
		}
		System.out.println("root.left:" + index);
		root.left = BuildTree(inorder, postorder, start, inStart - 1, index - 1);
		if(root.left != null){
			index -= inStart - start;
		}		

		return root;
	}
}