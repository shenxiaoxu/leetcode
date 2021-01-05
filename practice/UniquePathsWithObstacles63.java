/*
63.unique pathII
a robot is located at the top-left corner of a mn grid,
the robot can only move either down or right at any point in time.reach bottom-right
consider if some obstacles are added to the grids, how many unique paths.
in:
[
[0,0,0],
[0,1,0],
[0,0,0]
]
out: 2
*/
class UniquePathsWithObstacles{
	public static void main(String[] args){
		int m = 3;
		int n = 3;
		//int[][] markedarray = new int[m][n];
		int[][] markedarray = {{0,0,0},{0,1,0},{0,0,0}};
		System.out.println(uniquePathsWithObstacles(m, n, markedarray,0,0));
	}
	public static int uniquePathsWithObstacles(int m, int n, int[][] markedarray, int horital, int vertical){
		if(horital > m - 1 || vertical > n - 1)
			return 0;   
		if(horital == m - 1 && vertical == n - 1){
			return 1;
		}
		if(markedarray[horital][vertical] == 1){
			return 0;
		}
		markedarray[horital][vertical] = 1;
		int sub1 = uniquePathsWithObstacles(m,n,markedarray,horital + 1, vertical);
		markedarray[horital][vertical] = 0;

		markedarray[horital][vertical] = 1;
		int sub2 = uniquePathsWithObstacles(m,n,markedarray,horital, vertical + 1);
		markedarray[horital][vertical] = 0;		

		return sub1+sub2;
	}
}