
public class BinarySearchTreeIterator
{
    public static void main(String[] args){
    	TreeNode root = new TreeNode(7);
    	root.left = new TreeNode(4);
    	root.right = new TreeNode(15);
    	root.right.left = new TreeNode(11);
    	root.right.right = new TreeNode(20);
    	root.right.left.left = new TreeNode(9);
    	BSTIterator i = new BSTIterator(root);
    	while(i.hasNext()) {
    		System.out.println(i.next());
    	};
    }
}