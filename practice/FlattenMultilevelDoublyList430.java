/*430. Flatten a Multilevel Doubly Linked List
Medium

828

128

Add to List

Share
You are given a doubly linked list which in addition to the next and previous pointers, it could have a child pointer, which may or may not 
point to a separate doubly linked list. These child lists may have one or more children of their own, and so on, 
to produce a multilevel data structure, as shown in the example below.

Flatten the list so that all the nodes appear in a single-level, doubly linked list. You are given the head of the first level of the list.
question: can node point to itself or this doubly linked list, yes
can doubly linked list have many children. yes
can one node and another node point to the same children doubly linked list. yes
*/

/*
// Definition for a Node.
class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;
};
design:
use hashmap to record parents of the node, if we going to visited its child in order to call back.
use hashset to label already visited one.

*/
class Solution {
	HashMap<Node, Node> parents;
	HashSet<Node> visited;
	Stack<Node> queue;
	public Solution(){
		parents = new HashMap();
		visited = new HashSet();
	} 
    public Node flatten(Node head) {
        if(head == null) return null;
        Node dummy = new Node(-1);
        dummy.next = head;
        queue.add(head);
        while(head != null){
        	if(!queue.isEmpty()){
        		Node curr = queue.poll();
        		if(curr.child != null){
        			parents.put(head.child, head);
        		}        		
        	}
        }
    }
}

/*
// Definition for a Node.
class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;

    public Node() {}

    public Node(int _val,Node _prev,Node _next,Node _child) {
        val = _val;
        prev = _prev;
        next = _next;
        child = _child;
    }
};
*/
class Solution {
  public Node flatten(Node head) {
    if (head == null) return head;
    // pseudo head to ensure the `prev` pointer is never none
    Node pseudoHead = new Node(0, null, head, null);

    flattenDFS(pseudoHead, head);

    // detach the pseudo head from the real head
    pseudoHead.next.prev = null;
    return pseudoHead.next;
  }
  /* return the tail of the flatten list */
  public Node flattenDFS(Node prev, Node curr) {
    if (curr == null) return prev;
    curr.prev = prev;
    prev.next = curr;

    // the curr.next would be tempered in the recursive function
    Node tempNext = curr.next;

    Node tail = flattenDFS(curr, curr.child);
    curr.child = null;

    return flattenDFS(tail, tempNext);
  }
}











