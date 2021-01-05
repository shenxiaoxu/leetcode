/*94. Binary Tree Inorder Traversal

Given a binary tree, return the inorder traversal of its nodes' values.

Example:

Input: [1,null,2,3]
   1
    \
     2
    /
   3

Output: [1,3,2]
Follow up: Recursive solution is trivial, could you do it iteratively?
*/
import java.util.*;
class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        if(root == null){
            return new ArrayList<Integer>();
        }
        List<Integer> result = new ArrayList<Integer>();
        inorderTraversalHelper(root, result);
        return result;
    }
    public void inorderTraversalHelper(TreeNode root, List<Integer> result){
        if(root == null) return;
        inorderTraversalHelper(root.left, result);
        result.add(root.val);
        inorderTraversalHelper(root.right, result);
    }
    public void inorderTraversalHelperIte(TreeNode root, List<Integer> result){
        if(root == null) return;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;

        while(cur != null || !stack.isEmpty()){
        	while(cur != null){
        		stack.add(cur);
        		cur = cur.left;        		
        	}
        	cur = stack.pop();
        	result.add(cur.val);
        	cur = cur.right;
        }
    }    
    public List<Integer> preorderTraversal(TreeNode root) {
        if(root == null){
            return new ArrayList<Integer>();
        }
        List<Integer> result = new ArrayList<Integer>();
        preorderTraversalHelper(root, result);
        return result;
    }
    public void preorderTraversalHelper(TreeNode root, List<Integer> result){
        if(root == null) return;
        result.add(root.val);
        preorderTraversalHelper(root.left, result);       
        preorderTraversalHelper(root.right, result);
    }
    public void preorderTraversalHelperIte(TreeNode root, List<Integer> result){
        if(root == null) return;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;

        while(cur != null || !stack.isEmpty()){
        	while(cur != null){
        		result.add(cur.val);
        		stack.add(cur);
        		cur = cur.left;        		
        	}
        	cur = stack.pop();
        	cur = cur.right;
        }
    }     
    public List<Integer> postorderTraversal(TreeNode root) {
        if(root == null){
            return new ArrayList<Integer>();
        }
        List<Integer> result = new ArrayList<Integer>();
        postorderTraversalHelper(root, result);
        return result;
    }
    public void postorderTraversalHelper(TreeNode root, List<Integer> result){
        if(root == null) return;       
        postorderTraversalHelper(root.left, result);       
        postorderTraversalHelper(root.right, result);
        result.add(root.val);
    } 
    public void postorderTraversalHelperIte(TreeNode root, LinkedList<Integer> result){
        if(root == null) return;
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(queue.size() != 0){
        	TreeNode node = queue.pollLast();
        	result.addFirst(node.val);
        	if(node.left != null){
        		queue.add(node.left);
        	}
        	if(node.right != null){
        		queue.add(node.right);
        	}
        }

    } 

}



