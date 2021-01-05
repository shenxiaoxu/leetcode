/*200. Number of Islands
Medium

4342

159

Add to List

Share
Given a 2d grid map of '1's (land) and '0's (water), count the number of islands. An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.

Example 1:

Input:
11110
11010
11000
00000

Output: 1
Example 2:

Input:
11000
11000
00100
00011

Output: 3
*/
class Solution {
    int m;
    int n;	
    char[][] _grid;
    int[] rdirection = {1,0,-1,0};
    int[] cdirection = {0,1,0,-1};
    public int numIslands(char[][] grid) {
    	_grid = grid;
    	m = _grid.length;
    	n = _grid[0].length;
        int count = 0;
        for(int i = 0; i < m; i++){//traverse grid to find 1 and dfs around
        	for(int j = 0; j < n; j++){
        		if(_grid[i][j] == '1'){
        			dfs(_grid, i, j);
                    System.out.println(_grid[i][j]);
        			count++;
        		}
        	}
        }
        return count;
    }
    private void dfs(char[][] grid, int row, int col){
    	if(row < 0 || row >= m || col < 0 || col >= n || _grid[row][col] == '0' || _grid[row][col] == '2') return;
    	_grid[row][col] = '2';
    	for(int i = 0; i < rdirection.length; i++){
    		int nrow = row + rdirection[i];
    		int ncol = col + cdirection[i];
    		if(_grid[nrow][ncol] == '1'){
    			dfs(_grid, nrow, ncol);
    		}
    	}
    }
}







