import java.util.Stack;
public class BSTIterator{
	private Stack<TreeNode> stack = new Stack<TreeNode>();
	private TreeNode node = new TreeNode(0);
	public BSTIterator(TreeNode root){
		this.node = root;
	}
	public boolean hasNext(){
		if(this.node == null && stack.empty()){
			return false;
		}
		if(!stack.empty()){
			this.node = stack.pop();
			return true;
		}
		while(this.node.left != null){
			stack.push(this.node);
			System.out.println("Stack value" + this.node.val);
			node = this.node.left;
		}
		return true;
	}
	public int next(){
		int val;
		if(this.node.left == null && this.node.right == null){
			val = this.node.val;
			this.node = this.node.right;
			return val;
		}
		if(this.node.right != null){
			val = this.node.val;
			node = this.node.right;
			if(!stack.empty()){
				stack.pop();
			}
			return val;
		}else{
			val = this.node.val;
			this.node = this.node.right;
			return val;
		}
	}
}