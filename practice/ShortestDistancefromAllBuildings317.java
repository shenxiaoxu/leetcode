/*317. Shortest Distance from All Buildings
Hard

664

40

Add to List

Share
You want to build a house on an empty land which reaches all buildings in the shortest amount of distance. You can only move up, down, left and right. 
You are given a 2D grid of values 0, 1 or 2, where:

Each 0 marks an empty land which you can pass by freely.
Each 1 marks a building which you cannot pass through.
Each 2 marks an obstacle which you cannot pass through.
Example:

Input: [[1,0,2,0,1],[0,0,0,0,0],[0,0,1,0,0]]

1 - 0 - 2 - 0 - 1
|   |   |   |   |
0 - 0 - 0 - 0 - 0
|   |   |   |   |
0 - 0 - 1 - 0 - 0

Output: 7 

Explanation: Given three buildings at (0,0), (0,4), (2,2), and an obstacle at (0,2),
             the point (1,2) is an ideal empty land to build a house, as the total 
             travel distance of 3+3+1=7 is minimal. So return 7.
Note:
There will be at least one building. If it is not possible to build such house according to the above rules, return -1.
*/
class Solution {//time complexity is n3, 
	int minimum = Integer.MAX_VALUE;
	int[][] _grid;
	int m;
	int n;
	int[] rdirection = {1, 0, -1, 0};
	int[] cdirection = {0, 1, 0, -1};
    public int shortestDistance(int[][] grid) {
        _grid = grid;
        m = grid.length;
        n = grid[0].length;
        for(int i = 0; i < m; i++){
        	for(int j = 0; j < n; j++){
        		if(grid[i][j] = 0){
        			BFS(grid, i, j);
        		}
        	}
        }
        return minimum;
    }
    public void BFS(int[][] grid, int rori , int cori){
    	Deque<Pair<Integer, Integer>> queue = new ArrayDeque();
    	queue.add(new Pair<Integer, Integer>(rori,cori));
    	int result = 0;
    	int count = 0;
    	int onecount = 0;
    	while(!queue.isEmpty()){
    		int size = queue.size();
    		count++;
    		for(int i = 0; i < size; i++){
	    		Pair<Integer, Integer> pair = queue.poll();
	    		int start = pair.getKey();
	    		int end = pair.getValue();
	    		grid[start][end] = -1; 
	    		for(int i = 0; i< rdirection.length; i++){
	    			int nstart = start + rdirection[i];
	    			int nend = end + cdirection[i];
	    			if(nstart < 0 || nstart > grid.length || nend < 0 || nend > grid.length) continue;
	    			if(grid[nstart][nend] == 1){//calculate distance
	    				result+= count; grid[nstart][nend] = -1; onecount++;
	    			}else if(grid[nstart][nend] == 2){continue;}
	    			else if(grid[nstart][nend] == 0){queue.add(Pair<Integer, Integer>(nstart, nend));}
	    			else if(grid[nstart][nend] == -1){continue;}
	    		}
    		}
    	}
    	if(onecount != grid.onesize){
    		result = -1;
    	}
    	minimum = Math.minimum(result, minimum);
    }
}

public class Solution {
    public int shortestDistance(int[][] grid) {
        if (grid == null || grid[0].length == 0) return 0;
        final int[] shift = new int[] {0, 1, 0, -1, 0};
        
        int row  = grid.length, col = grid[0].length;
        int[][] distance = new int[row][col];
        int[][] reach = new int[row][col];
        int buildingNum = 0;
        
        for (int i = 0; i < row; i++) {
            for (int j =0; j < col; j++) {
                if (grid[i][j] == 1) {
                    buildingNum++;
                    Queue<int[]> myQueue = new LinkedList<int[]>();
                    myQueue.offer(new int[] {i,j});

                    boolean[][] isVisited = new boolean[row][col];
                    int level = 1;
                    
                    while (!myQueue.isEmpty()) {
                        int qSize = myQueue.size();
                        for (int q = 0; q < qSize; q++) {
                            int[] curr = myQueue.poll();
                            
                            for (int k = 0; k < 4; k++) {
                                int nextRow = curr[0] + shift[k];
                                int nextCol = curr[1] + shift[k + 1];
                                
                                if (nextRow >= 0 && nextRow < row && nextCol >= 0 && nextCol < col
                                    && grid[nextRow][nextCol] == 0 && !isVisited[nextRow][nextCol]) {
                                        //The shortest distance from [nextRow][nextCol] to thic building
                                        // is 'level'.
                                        distance[nextRow][nextCol] += level;
                                        reach[nextRow][nextCol]++;
                                        
                                        isVisited[nextRow][nextCol] = true;
                                        myQueue.offer(new int[] {nextRow, nextCol});
                                    }
                            }
                        }
                        level++;
                    }
                }
            }
        }
        
        int shortest = Integer.MAX_VALUE;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == 0 && reach[i][j] == buildingNum) {
                    shortest = Math.min(shortest, distance[i][j]);
                }
            }
        }
        
        return shortest == Integer.MAX_VALUE ? -1 : shortest;
        
        
    }
}











