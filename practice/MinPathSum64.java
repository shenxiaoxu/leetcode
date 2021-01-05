/*
64.minimum path sum
given numbers. find path from top left to bottom right which minimizes the sum of all numbers along its path.
in:
[
[1,3,1],
[1,5,1],
[4,2,1]
]
out:7
*/
import java.util.*;
class MinPathSum{
	public static void main(String[] args){

		//int[][] markedarray = new int[m][n];
		int[][] input = {{1,3,1},{1,0,1},{4,2,1}};
		int[][] markedarray = new int[input.length][input[0].length];
		for(int i = 0; i < markedarray.length;i++){
			for(int j = 0; j < markedarray[0].length;j++){
				markedarray[i][j] = 0;
			}
		}
		LinkedList<Integer> result = new LinkedList<Integer>();
		minPathSum(result, input, markedarray,0,0, 0,input.length, input[0].length);
		Collections.sort(result);
		System.out.println(result.get(0));
	}
	public static void minPathSum(LinkedList<Integer> list, int[][] input, int[][] markedarray, int horital, int vertical, int current, int m, int n){
		if(horital > m - 1 || vertical > n - 1)
			return;   
		if(horital == m - 1 && vertical == n - 1){			
			current = current + input[horital][vertical];
			list.add(current);		
		}
		if(markedarray[horital][vertical] == 1){
			return;
		}
		markedarray[horital][vertical] = 1;
		minPathSum(list,input,markedarray,horital + 1, vertical, current + input[horital][vertical], m, n);
		markedarray[horital][vertical] = 0;

		markedarray[horital][vertical] = 1;
		minPathSum(list, input,markedarray,horital, vertical + 1, current + input[horital][vertical], m, n);
		markedarray[horital][vertical] = 0;		
	}
}