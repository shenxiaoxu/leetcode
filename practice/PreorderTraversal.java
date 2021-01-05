import java.util.Stack;
public class PreorderTraversal
{
    public static void main(String[] args){
    	TreeNode root = new TreeNode(7);
    	root.left = new TreeNode(4);
    	root.right = new TreeNode(15);
    	root.right.left = new TreeNode(11);
    	root.right.right = new TreeNode(20);
    	root.right.left.left = new TreeNode(9);
    	preorderTraversal(root);
    	preorderTraversalIteratively(root);
    }
    public static void preorderTraversal(TreeNode root){
    	if(root == null){
    		return;
    	}
    	if(root.left == null && root.right == null){
    		System.out.println(root.val);
    		return;
    	}
        System.out.println(root.val);
    	if(root.left!= null){
    		preorderTraversal(root.left);
    	}

    	if(root.right != null){
    		preorderTraversal(root.right);
    	}
    }
    public static void preorderTraversalIteratively(TreeNode root){
    	Stack<TreeNode> s = new Stack<TreeNode>();
    	while(!s.empty() || root !=null){
    		while(root.left != null && !root.left.visited){
    			s.push(root);
    			root = root.left;
    		}
    		System.out.println(root.val);
    		root.visited = true;
    		if(root.right != null){
    			root = root.right;
    		}else{
    			if(!s.empty()){
    				root = s.pop();
    			}else{
    				return;
    			}
    		}
    	}
    }
}