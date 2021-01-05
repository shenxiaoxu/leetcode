/*
give an array num of n integers find there elements abc and to 0, find all triplets that gives sum of zero.
the solution not contian duplicate triplets.
[-1,0,1,2,-1,-4]
solution [[-1,0,1] [-1,-1,2]]

sort the list, 
[-4,-1,-1,0,1,2]
the find the index number
then left right to right index
*/
import java.util.*;
class ThreeSum{
	public static ArrayList<ArrayList<Integer>> ThreeSum(int[] input){
		Arrays.sort(input);
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		int start = 0;
		int end = input.length - 1;
		for(int i = 0; i < input.length; i++){
			start = 0;
			end = input.length - 1;
			while(start < i && end > i){
				if(input[start] + input[end] + input[i] == 0){
					ArrayList<Integer> solution = new ArrayList<Integer>();
					solution.add(input[start]);
					solution.add(input[i]);
					solution.add(input[end]);
					result.add(solution);
					break;
				}else if(input[start] + input[end] + input[i] < 0){
					start++;
					while(input[start] == input[start + 1] && start + 1 < i){
						start++;
					}
				}else{
					end--;
					while(input[end] == input[end - 1] && end - 1 > i){
						end--;
					}					
				}
			}
		}
		return result;
	}
	public static void main(String[] args){
		int[] input = {-1,0,1,2,-1,-4};
		System.out.println(ThreeSum(input));
	}
}