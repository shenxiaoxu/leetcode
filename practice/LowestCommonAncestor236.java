/*236. Lowest Common Ancestor of a Binary Tree
Medium

3001

161

Add to List

Share
Given a binary tree, find the lowest common ancestor (LCA) of two given nodes in the tree.

According to the definition of LCA on Wikipedia: 
“The lowest common ancestor is defined between two nodes p and q as the lowest node in T that has both p and q as descendants 
(where we allow a node to be a descendant of itself).”
question:
1.is p and q both guarantee in the tree?
2. is possible p and q are the same?
3.are the value in the tree all distinct?
design:
p and q is both in the left subtree? lca is root.left
p and q is both in the right subtree? lca is root.right
p, q in the different side of tree, lca is root.
recursive check every node of tree.
*/

class Solution{
	public TreeNode LCA(TreeNode p, TreeNode q, TreeNode root){
		if(root == null) return;
		if(root.val == p.val || root.val == q.val) return root;
		if(find(p, q, root)) return root;
		TreeNode resultleft = LCA(p, q, root.left);
		TreeNode resultright = LCA(p, q, root.right);
		return resultleft == null? resultright:resultleft;
	}
	public boolean find(TreeNode p, TreeNode q, TreeNode root){
		if(root == null) return false;
		if(root == p.val || root == q.val) return true;
		boolean left = find(p, q, root.left);
		boolean right = find(p, q, root.right);
		return left || right;
	}

}

class Solution {

    private TreeNode ans;

    public Solution() {
        // Variable to store LCA node.
        this.ans = null;
    }

    private boolean recurseTree(TreeNode currentNode, TreeNode p, TreeNode q) {

        // If reached the end of a branch, return false.
        if (currentNode == null) {
            return false;
        }

        // Left Recursion. If left recursion returns true, set left = 1 else 0
        int left = this.recurseTree(currentNode.left, p, q) ? 1 : 0;

        // Right Recursion
        int right = this.recurseTree(currentNode.right, p, q) ? 1 : 0;

        // If the current node is one of p or q
        int mid = (currentNode == p || currentNode == q) ? 1 : 0;


        // If any two of the flags left, right or mid become True
        if (mid + left + right >= 2) {
            this.ans = currentNode;
        }

        // Return true if any one of the three bool values is True.
        return (mid + left + right > 0);
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // Traverse the tree
        this.recurseTree(root, p, q);
        return this.ans;
    }
}