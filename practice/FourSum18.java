/*
18.4 sum
given an array nums of n integers and an integer target, are there elements a,b,c and d a+b+c+d = target
in:[1,0,-1,0,-2,2] target = 0;
out:[
[-1,0,0,1],
[-2,-1,1,2],
[-2,0,0,2]
]
*/
import java.util.*;
class FourSum{
	public static ArrayList<ArrayList<Integer>> FourSum(int[] input){
		Arrays.sort(input);
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		int start = 0;
		int end = input.length - 1;
		for(int j = 0; j < input.length; j++){
			int target = input[j];
			for(int i = j + 1; i < input.length; i++){
				start = 0;
				end = input.length - 1;
				while(start < j && end > i){
					if(input[start] + input[end] + input[i] == -target){
						ArrayList<Integer> solution = new ArrayList<Integer>();
						solution.add(input[start]);
						solution.add(target);
						solution.add(input[i]);
						solution.add(input[end]);
						result.add(solution);
						start++;
						end--;
					}else if(input[start] + input[end] + input[i] < -target){
						start++;
						while(input[start] == input[start + 1] && start < j){
							start++;
						}
					}else{
						end--;
						while(input[end] == input[end - 1] && end > i){
							end--;
						}					
					}
				}
			}
		}
		return result;
	}
	public static void main(String[] args){
		int[] input = {1,0,-1,0,-2,2};
		System.out.println(FourSum(input));
	}
}