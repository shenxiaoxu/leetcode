/*
54.spiral matrix
given a matrix of m*n elements(m rows, n columns),return all elements of matrix in spiral order.
in:
[
[1,2,3],
[4,5,6],
[7,8,9]
]
out:[1,2,3,6,9,8,7,4,5]
in:
[
[1,2,3,4],
[5,6,7,8],
[9,10,11,12]
]
out:[1,2,3,4,8,12,11,10,9,5,6,7]
solution:
m*n start end, 
start + 1, end - 1
*/
import java.util.*;
class SpiralOrder{
	public static void main(String[] args){
		int[][] input1 ={{1,2,3},{4,5,6},{7,8,9}};
		int[][] input2 = {{1,2,3,4},{5,6,7,8},{9,10,11,12}};
		
		System.out.println(spiralOrder(input1));
	}
	public static LinkedList<Integer> spiralOrder(int[][] input1){
		LinkedList<Integer> result = new LinkedList<Integer>();
		int verticalStart = 0;
		int verticalEnd = input1[0].length - 1;
		int horitalStart = 0;
		int horitalEnd = input1.length - 1;
		while(verticalEnd >= verticalStart || horitalEnd >= horitalStart){
			for(int i = verticalStart; i <= verticalEnd; i++)
				result.add(input1[horitalStart][i]);
			for(int j = horitalStart + 1; j <= horitalEnd; j++){				
				result.add(input1[j][verticalEnd]);
			}
			for(int k = verticalEnd - 1; k >=verticalStart; k--){
				if(horitalStart == horitalEnd){
					break;					
				}
				result.add(input1[horitalEnd][k]);
			}
			for(int l = horitalEnd - 1; l >horitalStart;l--){
				if(verticalStart == verticalEnd){
					break;					
				}
				result.add(input1[l][verticalStart]);
			}
			
			verticalStart++;
			verticalEnd--;
			horitalStart++;
			horitalEnd--;
			//System.out.println(horitalStart+ ""+horitalEnd + "" + verticalStart + "" + verticalEnd);
		}
		return result;
	}
}