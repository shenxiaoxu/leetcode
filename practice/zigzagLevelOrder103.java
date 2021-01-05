/*
103. Binary Tree Zigzag Level Order Traversal

Given a binary tree, return the zigzag level order traversal of its nodes' values. (ie, from left to right, then right to left for the next level and alternate between).

For example:
Given binary tree [3,9,20,null,null,15,7],
    3
   / \
  9  20
    /  \
   15   7
return its zigzag level order traversal as:
[
  [3],
  [20,9],
  [15,7]
]
*/
import java.util.*;
class zigzagLevelOrder103 {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
    	if(root == null) return new ArrayList<List<Integer>>();
    	List<List<Integer>> result = new LinkedList<List<Integer>>();
    	boolean leftRight = true;
    	Queue<TreeNode> queue = new LinkedList<TreeNode>();
    	queue.offer(root);
    	while(queue.size() != 0)
    	{
    		LinkedList<Integer> list = new LinkedList<Integer>();
    		int size = queue.size();
	    	for(int i = 0; i < size; i++){
	    		if(leftRight){
	    			TreeNode node = queue.poll();	    			
	    			if(node != null){
	    				queue.offer(node.left);
	    				queue.offer(node.right);
	    				list.add(node.val);
	    			}	    			
	    		}else{
	    			TreeNode node = queue.poll();
	    			if(node != null){
	    				queue.offer(node.left);
	    				queue.offer(node.right);
	    				list.addFirst(node.val);
	    			}
	    		}
	    	}
	    	if(list.size() != 0){
	    		leftRight = !leftRight;
	    		result.add(list);
	    	}
        }
    	return result;
	}
}
    