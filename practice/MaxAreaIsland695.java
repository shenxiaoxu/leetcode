/*695. Max Area of Island
Medium

1549

69

Add to List

Share
Given a non-empty 2D array grid of 0's and 1's, an island is a group of 1's (representing land) connected 4-directionally (horizontal or vertical.) 
You may assume all four edges of the grid are surrounded by water.

Find the maximum area of an island in the given 2D array. (If there is no island, the maximum area is 0.)

Example 1:

[[0,0,1,0,0,0,0,1,0,0,0,0,0],
 [0,0,0,0,0,0,0,1,1,1,0,0,0],
 [0,1,1,0,1,0,0,0,0,0,0,0,0],
 [0,1,0,0,1,1,0,0,1,0,1,0,0],
 [0,1,0,0,1,1,0,0,1,1,1,0,0],
 [0,0,0,0,0,0,0,0,0,0,1,0,0],
 [0,0,0,0,0,0,0,1,1,1,0,0,0],
 [0,0,0,0,0,0,0,1,1,0,0,0,0]]
Given the above grid, return 6. Note the answer is not 11, because the island must be connected 4-directionally.
Example 2:

[[0,0,0,0,0,0,0,0]]
Given the above grid, return 0.
Note: The length of each dimension in the given grid does not exceed 50.8*/
class Solution {
	int[][] _grid;
	int m;
	int n;
    public int maxAreaOfIsland(int[][] grid) {
        _grid = grid;
        m = grid.length;
        if(m == 0) return 0;
        int result = 0;
        n = grid[0].length;
        for(int i = 0; i < m; i++){//tranverse grid to find 1
        	for(int j = 0; j < n; j++){
        		if(_grid[i][j] == 1){
        			result = Math.max(result, rMaxAreaOfIsland(i, j));
        		}
        	}
        }
        return result;
    }
    public int rMaxAreaOfIsland(int i, int j){//dfs to find max area
    	if(i < 0 || i >= m || j < 0 || j >= n || _grid[i][j] == 0){
    		return 0;
    	}
    	int[] rdirection = {1,0,-1,0};
    	int[] cdirection = {0,1,0,-1};
    	int result = 1;
    	_grid[i][j] = -1;
    	for(int k = 0; k < rdirection.length; k++){
    		int nr = i + rdirection[k];
    		int nc = j + cdirection[k];
    		if(_grid[nr][nc] == 1){result += rMaxAreaOfIsland(nr, nc);}
    	}
    	return result;
    }
}
class Solution {
    int[][] grid;
    boolean[][] seen;

    public int area(int r, int c) {
        if (r < 0 || r >= grid.length || c < 0 || c >= grid[0].length ||
                seen[r][c] || grid[r][c] == 0)
            return 0;
        seen[r][c] = true;
        return (1 + area(r+1, c) + area(r-1, c)
                  + area(r, c-1) + area(r, c+1));
    }

    public int maxAreaOfIsland(int[][] grid) {
        this.grid = grid;
        seen = new boolean[grid.length][grid[0].length];
        int ans = 0;
        for (int r = 0; r < grid.length; r++) {
            for (int c = 0; c < grid[0].length; c++) {
                ans = Math.max(ans, area(r, c));
            }
        }
        return ans;
    }
}








