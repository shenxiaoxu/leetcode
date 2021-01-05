/*
116.populating next right pointer in each node.
1
2 5
3,4  6 

1-null
2-5-null
3-4-6-null
*/
import java.util.*;
class Connect{
	public static void main(String[] args){
		TreeLinkNode root = new TreeLinkNode(1);
		TreeLinkNode root1 = new TreeLinkNode(2);
		TreeLinkNode root2 = new TreeLinkNode(5);
		TreeLinkNode root3 = new TreeLinkNode(3);
		TreeLinkNode root4 = new TreeLinkNode(4);
		TreeLinkNode root5 = new TreeLinkNode(6);
		root.left = root1;
		root.right = root2;
		root1.left = root3;
		root1.right = root4;
		root2.right = root5;
		connect(root);
		while(root1 != null){
			System.out.println(root1.val);
			root1 = root1.next;
		}
		while(root3 != null){
			System.out.println(root3.val);
			root3 = root3.next;
		}		
	}
	public static void connect(TreeLinkNode root){
		LinkedList<TreeLinkNode> level = new LinkedList<TreeLinkNode>();
		LinkedList<TreeLinkNode> nextlevel = new LinkedList<TreeLinkNode>();
		
		level.add(root);
		while(level.size() != 0 || nextlevel.size() != 0){
			TreeLinkNode previous = null;
			if(level.size() != 0){
				previous = level.get(0);
			}
			boolean flag = false;
			while(level.size() != 0){
				TreeLinkNode element;
				if(!flag){
					element = level.poll();
					if(level.size() == 0){
						element.next = null;
					}
					flag = true;
				}else{
					element = level.poll();
					previous.next = element;
					previous = element;
				}
				if(element.left != null){
					nextlevel.add(element.left);
				}
				if(element.right != null){
					nextlevel.add(element.right);
				}
			}
			if(nextlevel.size() != 0){
				previous = nextlevel.get(0);
			}
			flag = false;
			while(nextlevel.size() != 0){
				TreeLinkNode element;
				if(!flag){
					element = nextlevel.poll();
					if(nextlevel.size() == 0){
						element.next = null;
					}
					flag = true;
				}else{
					element = nextlevel.poll();
					previous.next = element;
					previous = element;
				}
				if(element.left != null){
					level.add(element.left);
				}
				if(element.right != null){
					level.add(element.right);
				}			
			}

		}
	}
}