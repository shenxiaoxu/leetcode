/*1192. Critical Connections in a Network
Hard

631

59

Add to List

Share
There are n servers numbered from 0 to n-1 connected by undirected server-to-server connections forming a network where connections[i] = [a, b] represents a connection between servers a and b. Any server can reach any other server directly or indirectly through the network.

A critical connection is a connection that, if removed, will make some server unable to reach some other server.

Return all critical connections in the network in any order.

 

Example 1:



Input: n = 4, connections = [[0,1],[1,2],[2,0],[1,3]]
Output: [[1,3]]
Explanation: [[3,1]] is also accepted.*/
class Solution {
    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
    	int[] disc = new int[n], low = new int[n];
    	List<Integer>[] graph = new ArrayList[n];
    	List<List<Integer>> res = new ArrayList<>();
    	Arrays.fill(disc, -1);
    	for(int i = 0; i < n; i++){
    		graph[i] = new ArrayList<>();
    	}
    	for(int i = 0; i < connections.size();i++){
    		int from = connections.get(i).get(0), to = connections.get(i).get(1);
    		graph[from].add(to);
    		graph[to].add(from);
    	}
    	for(int i = 0; i < n; i++){
    		if(disc[i] == -1){
    			dfs(i, low, disc, graph, res, i);
    		}
    	}
    	return res;
	}
	int time = 0;
	private void dfs(int u, int[]low, int[]disc, List<Integer>[] graph, List<List<Integer>> result, int pre){
		disc[u] = low[u] = ++time;
		for(int j = 0; j < graph[u].size();j++){
			int v = graph[u].get(j);
			if(v==pre){
				continue;
			}
			if(disc[v] == -1){
				dfs(v, low, disc, graph, res, u);
				low[u] = Math.min(low[u], low[v]);
				if(low[v] > disc[u]){
					res.add(Arrays.asList(u,v));
				}
			}else{
				low[u] = Math.min(low[u], disc[v]);
			}
		}
	}
}




















