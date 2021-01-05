/*
59.spiral matrix II
given  a positive integer n, generate a square matrix filled with elements from 1 to n2 in spiral order
in:3
out
[
[1,2,3],
[8,9,4],
[7,6,5]
]
in:4
out
[
[1,2,3,4],
[12,13,14,5],
[11,16,15,6],
[10,9,8,7]
]
solution: according to n, casue it's square, vertical horital is same
*/
import java.util.*;
class GenerateMatrix{
	public static void main(String[] args){
		int number = 3;
		System.out.println(generateMatrix(number));
	}
	public static List<List<Integer>> generateMatrix(int number){
		int[][] matrix = new int[number][number];
		int verticalStart = 0;
		int verticalEnd = number -1;
		int horitalStart = 0;
		int horitalEnd = number - 1;
		int value = 1;
		while(verticalStart <= verticalEnd && horitalStart <= horitalEnd){
			for(int i = verticalStart; i <= verticalEnd; i++){
				matrix[horitalStart][i] = value; 
				//System.out.println( horitalStart + "" + i);
				value++;
			}
			for(int i = horitalStart + 1; i <= horitalEnd; i++){
				matrix[i][verticalEnd] = value;
				//System.out.println(i + "" + verticalEnd);
				value++;
			}
			for(int i = verticalEnd - 1; i >=verticalStart; i--){
				matrix[horitalEnd][i] = value;
				//System.out.println(horitalEnd + "" + i);
				value++;
			}
			for(int i = horitalEnd - 1; i > horitalStart; i--){
				matrix[i][verticalStart] = value;
				//System.out.println(i + "" + verticalStart);
				value++;
			}
			verticalStart++;
			verticalEnd--;
			horitalStart++;
			horitalEnd--;						
		}
		List<List<Integer>> result = new ArrayList<>();
		for(int i = 0; i < matrix.length; i++){
			List<Integer> temp = new ArrayList<>();
			for(int j = 0; j < matrix[0].length; j++){				
				temp.add(matrix[i][j]);
			}
			result.add(temp);
		}
		return result;
	}
}