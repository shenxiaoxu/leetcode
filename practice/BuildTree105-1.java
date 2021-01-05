/*
105.construct binary tree from preorder and inorder traversal
preorder[3,9,20,15,7]
inorder[9,3,15,20,7]
3,9,20,null,null,15,7
*/
class BuildTree{
	public static void main(String[] args){
		int[] preorder = {3,9,1,4,20,15,7};
		int[] inorder = {1,9,4,3,15,20,7};
		TreeNode root = BuildTree(preorder, inorder, 0, inorder.length, 0);
		TreeTraversal treetraversal = new TreeTraversal();
		treetraversal.inorderTraversal(root);
	}
	public static TreeNode BuildTree(int[] preorder, int[] inorder, int start, int end, int index){
	    if(start < 0 || start > end || index >= inorder.length){
	    	return null;
	    }

		int element = preorder[index];
		TreeNode root = new TreeNode(element);
		int inStart = 0;
		for(int i = 0; i < inorder.length;i++){
			if(inorder[i] == element){
				inStart = i;
				break;
			}
		}
		System.out.println("root.left:" + index);
		root.left = BuildTree(preorder, inorder, start, inStart - 1, index + 1);
		if(root.left != null){
			index += inStart - start ;
		}
		System.out.println("root.right:" + index);
		root.right = BuildTree(preorder, inorder, inStart + 1, end, index + 1);
		if(root.right != null){
			index += end - inStart ;
		}
		
		
		return root;
	}
}