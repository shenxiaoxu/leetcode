/*
106. Construct Binary Tree from Inorder and Postorder Traversal

Given inorder and postorder traversal of a tree, construct the binary tree.

Note:
You may assume that duplicates do not exist in the tree.

For example, given

inorder = [9,3,15,20,7]
postorder = [9,15,7,20,3]
Return the following binary tree:

    3
   / \
  9  20
    /  \
   15   7
*/
public class BuildTreeII106
{
    public static void main(String[] args){
    	int[] inorder = {9,3,15,20,7};
    	int[] postorder = {9,15,7,20,3};
        BuildTreeII106 object = new BuildTreeII106();
    	PreorderTraversal p = new PreorderTraversal();
    	TreeNode root = object.buildTree(inorder, postorder);
    	p.preorderTraversal(root);
    }
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if(inorder == null || postorder == null || inorder.length != postorder.length) return null;
        TreeNode root = preorderAssemble(inorder,postorder, 0, inorder.length - 1, postorder.length - 1);
        return root;
    }    
    public TreeNode preorderAssemble(int[] inorder, int[] postorder, int inStart, int inEnd, int postEnd){
    	if(inStart > inEnd || postEnd < 0){
    		return null;
    	}
    	int rootValue = postorder[postEnd];
    	TreeNode root = new TreeNode(rootValue);

    	int i = inStart;
    	while(i <= inEnd){
    		if(inorder[i] == rootValue){
    			break;
    		}
            i++;
    	}

    	root.left = preorderAssemble(inorder, postorder, inStart, i - 1, postEnd - inEnd + i - 1);
    	root.right = preorderAssemble(inorder, postorder, i + 1, inEnd, postEnd - 1);
    	return root;
    }
    
}