/*305. Number of Islands II
Hard

732

18

Add to List

Share
A 2d grid map of m rows and n columns is initially filled with water. We may perform an addLand operation which turns the water at position (row, col) into a land. Given a list of positions to operate, count the number of islands after each addLand operation. An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.

Example:

Input: m = 3, n = 3, positions = [[0,0], [0,1], [1,2], [2,1]]
Output: [1,1,2,3]
Explanation:

Initially, the 2d grid grid is filled with water. (Assume 0 represents water and 1 represents land).

0 0 0
0 0 0
0 0 0
Operation #1: addLand(0, 0) turns the water at grid[0][0] into a land.

1 0 0
0 0 0   Number of islands = 1
0 0 0
Operation #2: addLand(0, 1) turns the water at grid[0][1] into a land.

1 1 0
0 0 0   Number of islands = 1
0 0 0
Operation #3: addLand(1, 2) turns the water at grid[1][2] into a land.

1 1 0
0 0 1   Number of islands = 2
0 0 0
Operation #4: addLand(2, 1) turns the water at grid[2][1] into a land.

1 1 0
0 0 1   Number of islands = 3
0 1 0
Follow up:

Can you do it in time complexity O(k log mn), where k is the length of the positions?*/

class Solution {
    int m;
    int n;
    int[] parents = new int[m*n];
    int[][] position;
    public List<Integer> numIslands2(int m, int n, int[][] positions) {
        this.m = m;
        this.n = n;
        this.position = position;
        List<Integer> result = new ArrayList();
        for(int[] position: positions){
            int r = position[0];
            int c = position[1];
            int num = 0;
            int[] rdirections = {1, 0, -1, 0};
            int[] cdirections = {0, 1, 0, -1};
            for(int i = 0;i< rdirections.length; i++){
                int rn = r + rdirections[i];
                int cn = c + rdirections[i];
                if(){
                    int r1 = union(rn * cn, r * c);
                    num = Math.min(result, r1);
                }
            }
            result.add(num); 
        }
        return result;
    }
    private int union(int x, int y){
        int rankx = find(x);
        int ranky = find(y);
        if(rankx > ranky){
            rankx = parents[ranky];
        }else if(rankx < ranky){
            ranky = parents[rankx];
        }else{
            rankx = parents[ranky];
            rankx++;
        }
        return rankx;
    }
    private int find(int x){
        if(parents[x] != x) x = parents[x];
        return parents[x];
    }
}