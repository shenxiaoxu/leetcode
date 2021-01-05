/*
62.unique paths
a robot is located at the top-left corner of m*n gid
robot can only move either down or right at any point in time, robot is trying to reach bottom right corner of grid.
how moany possible unique paths are there?
m and n will be at most 100
in:m=3,n = 2
out:3
in:m = 7,n=3
out:28
given marked array, array index i,j, find marked array i+1 or j+1, if reach the end of matrix, count 1,
*/
class UniquePaths{
	public static void main(String[] args){
		int m = 7;
		int n = 3;
		int[][] markedarray = new int[m][n];
		for(int i = 0; i < m; i++){
			for(int j = 0; j < n;j++){
				markedarray[i][j] = 0;
			}
		}
		System.out.println(uniquePaths(m, n, markedarray,0,0));
	}
	public static int uniquePaths(int m, int n, int[][] markedarray, int horital, int vertical){
		if(horital > m - 1 || vertical > n - 1)
			return 0;   
		if(horital == m - 1 && vertical == n - 1){
			return 1;
		}
		if(markedarray[horital][vertical] == 1){
			return 0;
		}
		markedarray[horital][vertical] = 1;
		int sub1 = uniquePaths(m,n,markedarray,horital + 1, vertical);
		markedarray[horital][vertical] = 0;

		markedarray[horital][vertical] = 1;
		int sub2 = uniquePaths(m,n,markedarray,horital, vertical + 1);
		markedarray[horital][vertical] = 0;		

		return sub1+sub2;
	}
}