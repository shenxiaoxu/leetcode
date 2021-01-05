/*
133. Clone Graph
Medium

Given a reference of a node in a connected undirected graph.

Return a deep copy (clone) of the graph.

Each node in the graph contains a val (int) and a list (List[Node]) of its neighbors.

class Node {
    public int val;
    public List<Node> neighbors;
}
 

Test case format:

For simplicity sake, each node's value is the same as the node's index (1-indexed). For example, the first node with val = 1, the second node with val = 2, and so on. The graph is represented in the test case using an adjacency list.

Adjacency list is a collection of unordered lists used to represent a finite graph. Each list describes the set of neighbors of a node in the graph.

The given node will always be the first node with val = 1. You must return the copy of the given node as a reference to the cloned graph.

 

Example 1:


Input: adjList = [[2,4],[1,3],[2,4],[1,3]]
Output: [[2,4],[1,3],[2,4],[1,3]]
Explanation: There are 4 nodes in the graph.
1st node (val = 1)'s neighbors are 2nd node (val = 2) and 4th node (val = 4).
2nd node (val = 2)'s neighbors are 1st node (val = 1) and 3rd node (val = 3).
3rd node (val = 3)'s neighbors are 2nd node (val = 2) and 4th node (val = 4).
4th node (val = 4)'s neighbors are 1st node (val = 1) and 3rd node (val = 3).
Example 2:


Input: adjList = [[]]
Output: [[]]
Explanation: Note that the input contains one empty list. The graph consists of only one node with val = 1 and it does not have any neighbors.
Example 3:

Input: adjList = []
Output: []
Explanation: This an empty graph, it does not have any nodes.
Example 4:


Input: adjList = [[2],[1]]
Output: [[2],[1]]
 

Constraints:

1 <= Node.val <= 100
Node.val is unique for each node.
Number of Nodes will not exceed 100.
There is no repeated edges and no self-loops in the graph.
The Graph is connected and all nodes can be visited starting from the given node.
clone an undirected graph, each node in graph contains a label and a list of its neighbors.
class UndirectedGraphNode{
	int label;
	List<UndirectedGraphNode> neighbors;
	UndirectedGraphNode(int x){label = x; neighbors = new ArrayList<UndirectedGraphNode>();}
}
{0,1,2#1,2#2,2}
*/
import java.util.*;
class CloneGraph133{
	private HashMap<Node, Node> visited = new HashMap<>();
	public static void main(String[] args){
		Node node1 = new Node(0);
		Node node2 = new Node(1);
		Node node3 = new Node(2);
		node1.neighbors.add(node2);
		node1.neighbors.add(node3);
		node2.neighbors.add(node1);
		node2.neighbors.add(node3);
		node3.neighbors.add(node1);
		node3.neighbors.add(node2);
		CloneGraph133 object = new CloneGraph133();
		Node root = object.cloneGraphDFS(node1);
		
		System.out.println(root.val);
		for(int i = 0; i < root.neighbors.size(); i++){
			System.out.println(root.neighbors.get(i).val);
		}

	}
	public static UndirectedGraphNode cloneGraph(UndirectedGraphNode node, LinkedList<Integer> list){
		LinkedList<UndirectedGraphNode> queue = new LinkedList<UndirectedGraphNode>();
		LinkedList<UndirectedGraphNode> result = new LinkedList<UndirectedGraphNode>();
		
		queue.add(node);
		while(queue.size() != 0){
			UndirectedGraphNode q = queue.pollLast();
			//System.out.println("q: " + q.label);
			if(list.indexOf(q.label) == -1){
				UndirectedGraphNode clone = new UndirectedGraphNode(q.label);
				LinkedList<UndirectedGraphNode> neighbors = q.neighbors;
				for(int i = 0; i < neighbors.size(); i++){
					//System.out.println("neighbors: " + neighbors.get(i).label);
					UndirectedGraphNode neighbor = neighbors.get(i);
					UndirectedGraphNode temp = new UndirectedGraphNode(neighbor.label);
					for(int j = 0; j < neighbor.neighbors.size();j++){
						temp.neighbors.add(new UndirectedGraphNode(neighbor.neighbors.get(j).label));
					}
					clone.neighbors.add(temp);
					queue.add(temp);
				}		
				list.add(q.label);
				result.add(clone);
			}
	
		}
		return result.get(2);
	}
	public Node cloneGraphNew(Node node) {
		if(node == null) return null;
        HashMap<Node, Node> map = new HashMap<Node, Node>();
        Queue<Node> q = new LinkedList<Node>();
  
        q.offer(node);
        map.put(node, null);
        while(q.size() != 0){
        	Node nodeQ = q.poll();
        	Node copy = new Node(nodeQ.val);
        	map.put(nodeQ, copy);
        	for(Node nei: node.neighbors){
        		if(!map.containsKey(nei)){
        			q.offer(nei);
        			map.put(nei, null);
        		}
        	}
        }
        for(Node nodeM: map.keySet()){
        	for(Node nodeN: nodeM.neighbors){
        		map.get(nodeM).neighbors.add(map.get(nodeN));
        	}
        }

        return map.get(node);
    }
    public Node cloneGraphDFS(Node node){
    	if(node == null) return null;

    	if(visited.containsKey(node)){
    		return visited.get(node);
    	}

    	Node cloneNode = new Node(node.val, new ArrayList<Node>());
    	visited.put(node, cloneNode);

    	for(Node neighbor: node.neighbors){
    		cloneNode.neighbors.add(cloneGraphDFS(neighbor));
    	}
    	return cloneNode;
    }
}

class Node {
    public int val;
    public List<Node> neighbors;
    
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
