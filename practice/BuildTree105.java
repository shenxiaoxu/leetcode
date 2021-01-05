/*105. Construct Binary Tree from Preorder and Inorder Traversal
Medium

Given preorder and inorder traversal of a tree, construct the binary tree.

Note:
You may assume that duplicates do not exist in the tree.

For example, given

preorder = [3,9,20,15,7]
inorder = [9,3,15,20,7]
Return the following binary tree:

    3
   / \
  9  20
    /  \
   15   7

*/
class BuildTree105{
	public static void main(String[] args){
		int[] preorder = {3,9,20,15,7};
		int[] inorder = {9,3,15,20,7};
		BuildTree105 object = new BuildTree105();
		TreeNode root = object.buildTree(preorder, inorder);
		TreeTraversal treetraversal = new TreeTraversal();
		treetraversal.inorderTraversal(root);
	}
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder == null || inorder == null || preorder.length == 0 || inorder.length != preorder.length) return null;
        TreeNode root;
        root = buildTreeHelper(preorder, inorder, 0,0,inorder.length - 1);
        return root;
    }
    public TreeNode buildTreeHelper(int[] preorder, int[] inorder, int pre_st, int in_st, int in_end){
    	if(in_st > in_end || pre_st > preorder.length) return null;
    	TreeNode root = new TreeNode(preorder[pre_st]);
    	int i = in_st;
    	while(i <= in_end){
    		if(inorder[i] == root.val){
    			break;
    		}
    		i++;
    	}
    	root.left = buildTreeHelper(preorder,inorder,pre_st+1,in_st, i - 1);
    	root.right = buildTreeHelper(preorder, inorder,pre_st + (i - in_st + 1), i + 1, in_end);
    	return root;
    }	
}   