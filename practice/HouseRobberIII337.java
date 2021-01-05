/*
337. House Robber III

The thief has found himself a new place for his thievery again. There is only one entrance to this area, called the "root." Besides the root, each house has one and only one parent house. After a tour, the smart thief realized that "all houses in this place forms a binary tree". It will automatically contact the police if two directly-linked houses were broken into on the same night.

Determine the maximum amount of money the thief can rob tonight without alerting the police.

Example 1:

Input: [3,2,3,null,3,null,1]

     3
    / \
   2   3
    \   \ 
     3   1

Output: 7 
Explanation: Maximum amount of money the thief can rob = 3 + 3 + 1 = 7.
Example 2:

Input: [3,4,5,1,3,null,1]

     3
    / \
   4   5
  / \   \ 
 1   3   1

Output: 9
Explanation: Maximum amount of money the thief can rob = 4 + 5 = 9.
*/
class HouseRobberIII337{
	public static void main(String[] args){
		TreeNode root = new TreeNode(3);
		TreeNode root1 = new TreeNode(2);
		TreeNode root2 = new TreeNode(3);
		TreeNode root3 = new TreeNode(3);
		TreeNode root4 = new TreeNode(1);
		root.left = root1;
		root.right = root2;
		root1.right = root3;
		root2.right = root4;
		HouseRobberIII337 object = new HouseRobberIII337();
		System.out.println(object.rob(root));

	}
    public int rob(TreeNode root) {
        if(root == null) return 0;
        int[] result = new int[2];
        result = robHelperOpt(root);
        return Math.max(result[0],result[1]);
    }	

    public int[] robHelperOpt(TreeNode root){
    	if(root == null) return new int[2];
    	int[] result = new int[2];
    	int[] left = new int[2];
    	int[] right = new int[2];
    	left = robHelperOpt(root.left);
    	right = robHelperOpt(root.right);
    	result[0] = Math.max(left[0],left[1]) + Math.max(right[0], right[1]);
    	result[1] = left[0] + right[0] + root.val;
    	return result;
    }
    public int robHelper(TreeNode root, int parent_rb, int parent_nrb, boolean rob){
    	int result = 0;
    	int parent_rb_nrb = 0;
    	if(root == null) return 0;
    	if(rob){
    		parent_rb = root.val + robHelper(root.left, parent_rb, parent_nrb, !rob) + robHelper(root.right, parent_rb, parent_nrb, !rob);
    		parent_rb_nrb = robHelper(root.left, parent_rb, parent_nrb, rob) + robHelper(root.right, parent_rb, parent_nrb, rob);
    		parent_rb = Math.max(parent_rb, parent_rb_nrb);
    	}else{
   			parent_nrb = robHelper(root.left, parent_rb, parent_nrb, !rob) + robHelper(root.right, parent_rb, parent_nrb, !rob);
   		}
   		result = Math.max(parent_nrb, parent_rb);
   		return result;
    }    
}















