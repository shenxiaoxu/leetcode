/*743. network delay time
there are n network nodes, label 1 to n
given times, a list of travel times as directed edges times[i] = (u, v, w), where u is the source node, v is target node
w is the time it takes for a signal to travel from source to target.
now we send a signal from a certain node k, how long will it take for all nodes to receive the signal?
if it's impossible, return -1
n will be range 1,100
k will be in range 1,n
length of times will be in range 1,6000
all edges times[i] =(u,v,w) will have 1<u v<n and 1<w<100

*/
import java.util.*;
class NetworkDelayTime{
	public static void main(String[] args){
		int[][] times = {{0,5,3,4},{5,0,Integer.MAX_VALUE,1},{3,Integer.MAX_VALUE,0,0},{4,1,0,0}};
		System.out.println(NetworkDelayTime(times, 4, 2));
	}
	public static int NetworkDelayTime(int[][] times, int N, int K){
		int[] edges = new int[N];//record how long it take from k to n
		
		int[][] distance = new int[N][N];
		for(int i = 0; i < times.length; i++){
			for(int j = 0; j < times[0].length; j++){
				distance[i][j] = times[i][j];
			}
		}
		for(int i = 0; i < edges.length; i++){
			edges[i] = Integer.MAX_VALUE;
		}

		LinkedList<Integer> queue = new LinkedList<Integer>();//bfs, record intermedia state
		int finalresult = 0;
		queue.push(K - 1);
		edges[K - 1] = 0;
		
		while(queue.size()!=0){
			int[] visited = new int[N];//record which already be visited
			for(int i = 0; i < visited.length; i++){
				visited[i] = 0;
			}
			for(int i = queue.size()-1; i>=0;i--){
				int node = queue.pollFirst();
				for(int j = 0; j < N; j++){
					if(distance[node][j] != Integer.MAX_VALUE && edges[node] + distance[node][j] < edges[j]){
						if(visited[j] ==0){
							visited[j] = 1;
							queue.addLast(j);
						}
						edges[j] = edges[node] + distance[node][j];
					}
				}
			}
			for(int i = 0; i < edges.length; i++){
				System.out.print(edges[i] + " ");
			}
		}
		
		for(int i = 0; i < edges.length; i++){
			finalresult = Math.max(finalresult, edges[i]); 
		}
		return finalresult == Integer.MAX_VALUE?-1:finalresult;
	}
}