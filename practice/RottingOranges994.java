/*994. Rotting Oranges
Easy

1014

154

Add to List

Share
In a given grid, each cell can have one of three values:

the value 0 representing an empty cell;
the value 1 representing a fresh orange;
the value 2 representing a rotten orange.
Every minute, any fresh orange that is adjacent (4-directionally) to a rotten orange becomes rotten.

Return the minimum number of minutes that must elapse until no cell has a fresh orange.  If this is impossible, return -1 instead.

 

Example 1:



Input: [[2,1,1],[1,1,0],[0,1,1]]
Output: 4
Example 2:

Input: [[2,1,1],[0,1,1],[1,0,1]]
Output: -1
Explanation:  The orange in the bottom left corner (row 2, column 0) is never rotten, because rotting only happens 4-directionally.
Example 3:

Input: [[0,2]]
Output: 0
Explanation:  Since there are already no fresh oranges at minute 0, the answer is just 0.
 

Note:

1 <= grid.length <= 10
1 <= grid[0].length <= 10
grid[i][j] is only 0, 1, or 2.*/
class Solution {
    public int orangesRotting(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        Queue<Pair<Integer, Integer>> queue = new LinkedList();
        for(int i = 0; i < m; i++){//find which cell has rotton orange and add to queue.
        	for(int j = 0; j < n; j++){
        		if(grid[i][j] == 2){
        			queue.add(new Pair<Integer, Integer>(i, j));
        		}
        	}
        }
        int miniutes = 0;
        int[] rdirections = {1,0,-1,0};
        int[] cdirections = {0,1,0,-1};
        while(!queue.isEmpty()){//use bfs to traverse other cell to rotton
        	int size = queue.size();
        	for(int i = 0; i < size; i++){
        		Pair<Integer, Integer> pair = queue.poll();
        		int row = pair.getKey();
        		int col = pair.getValue();
        		for(int k = 0; k < rdirections; k++){
        			int nrow = row + rdirections[k];
        			int ncol = col + cdirections[k];
        			if(nrow < 0 || nrow >= m || ncol < 0 || ncol >= n || grid[nrow][ncol] == 0){continue;}
        			if(grid[nrow][ncol] == 1){
        				grid[nrow][ncol] = 2;
        				queue.offer(new Pair<Integer, Integer>(nrow, ncol));
        			}
        		}
        	}
        	miniutes++;
        	
        }

        for(int i = 0; i < m; i++){//find which cell has rotton orange and add to queue.
        	for(int j = 0; j < n; j++){
        		if(grid[i][j] == 1){
        			return -1;
        		}
        	}
        }
        return miniutes;        
    }
}












