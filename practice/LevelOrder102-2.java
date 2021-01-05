/*102. Binary Tree Level Order Traversal

Given a binary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).

For example:
Given binary tree [3,9,20,null,null,15,7],
    3
   / \
  9  20
    /  \
   15   7
return its level order traversal as:
[
  [3],
  [9,20],
  [15,7]
]
*/
import java.util.*;
class LevelOrder{
	List<List<Integer>> results = new ArrayList<>();
    public List<List<Integer>> levelOrder(TreeNode root) {
     	LinkedList<List<Integer>> result = new LinkedList<>();
     	Queue<TreeNode> queue = new LinkedList<TreeNode>();
     	if(root == null) return new LinkedList<List<Integer>>();

     	queue.offer(root);

     	while(queue.size() != 0){
     		int size = queue.size();
     		LinkedList<Integer> list = new LinkedList<Integer>();
     		for(int i = 0; i < size; i++){
     			TreeNode node = queue.poll();
     			if(node != null){
     				list.add(node.val);
     				queue.offer(node.left);
     				queue.offer(node.right);
     			}
     		}
     		if(list.size() != 0){
     			result.add(list);
     		}
     	}
     	return result;  
    }
    public List<List<Integer>> levelOrderDFS(TreeNode root) {
    	if(root == null) return results;

    	levelOrderDFSHelper(root, 0);

    	return results;
    }

    public void levelOrderDFSHelper(TreeNode root, int level){
    	if(root == null) return;
    	if(level == results.size()){
    		results.add(new ArrayList<Integer>());
    	}

    	results.get(level).add(root.val);

    	if(root.left != null){
    		levelOrderDFSHelper(root.left, level + 1);
    	}
    	if(root.right != null){
    		levelOrderDFSHelper(root.right, level + 1);
    	}
    }
}












