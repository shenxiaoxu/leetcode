/*
962. Maximum Width Ramp
Given an array A of integers, a ramp is a tuple (i, j) for which i < j and A[i] <= A[j].  The width of such a ramp is j - i.

Find the maximum width of a ramp in A.  If one doesn't exist, return 0.

 

Example 1:

Input: [6,0,8,2,1,5]
Output: 4
Explanation: 
The maximum width ramp is achieved at (i, j) = (1, 5): A[1] = 0 and A[5] = 5.
Example 2:

Input: [9,8,1,0,1,9,4,0,4,1]
Output: 7
Explanation: 
The maximum width ramp is achieved at (i, j) = (2, 9): A[2] = 1 and A[9] = 1.
 

Note:

2 <= A.length <= 50000
0 <= A[i] <= 50000

1.write solution1 and didn't write solution2
2.solution2 see website:

use stack from beginning and end, stack might contain double information.
*/
import java.util.*;
class MaximumWidthRamp962{
	public static void main(String[] args){
		int[] input = {6,0,8,2,1,5};
		int[] input2 = {9,8,1,0,1,9,4,0,4,1};
		System.out.println(MaximumWidthRampSolution2(input));
		System.out.println(MaximumWidthRampSolution2(input2));
	}
	public static int MaximumWidthRampSolution1(int[] input){
		int maximumwidth = Integer.MIN_VALUE;
		for(int i = 0; i < input.length; i++){
			for(int j = i + 1; j < input.length; j++){
				if(input[i] <= input[j]){
					maximumwidth = Math.max(maximumwidth, j - i);
				}
			}
		}
		return maximumwidth;
	}
	public static int MaximumWidthRampSolution2(int[] input){
		//6,0,8,2,1,5
		//stack (6,0)(0,1) 
		
		//9,8,1,0,1,9,4,0,4,1
		//stack (9,0)(8,1)(1,2)(0,3)
		int distance = 0;
		Stack<Pair> stack = new Stack<Pair>();
		for(int i = 0; i < input.length;i++){
			if(stack.empty() || input[i] < stack.peek().getKey()){
				stack.push(new Pair(input[i],i));
			}
		}
		for(int i = input.length - 1; i >=0;i--){
			while(!stack.empty() && input[i] >= stack.peek().getKey()){
				distance = Math.max(distance, i - stack.peek().getValue());
				stack.pop();
			}
		}

		return distance;
	}
}
class Pair{
	int x;
	int y;
	Pair(int x, int y){
		this.x = x;
		this.y = y;
	}
	public int getKey(){
		return x;
	}
	public int getValue(){
		return y;
	}
}













