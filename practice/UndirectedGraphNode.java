import java.util.*;
class UndirectedGraphNode{
	int label;
	LinkedList<UndirectedGraphNode> neighbors;
	UndirectedGraphNode(int x){label = x; neighbors = new LinkedList<UndirectedGraphNode>();}
}