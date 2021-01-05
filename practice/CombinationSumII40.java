/*
40.combination sumII
given a collection of candidate numbers and a target number, find all unique combination in candidates where candidate numbers sum to target.
each number may only be used once in combination.
in: candidates =[10,1,2,7,6,1,5],target = 8, out:[[1,7],[1,2,5],[2,6],[1,1,6]]
in: candidates = [2,5,2,1,2], target = 5,out:[[1,2,2],[5]]
*/

import java.util.*;
class CombinationSum2{
	public static void main(String[] args){
		int[] input = {10,1,2,7,6,1,5};
		int[] input2 = {2,5,2,1,2};
		LinkedList<LinkedList<Integer>> results = new LinkedList<LinkedList<Integer>>();
		LinkedList<LinkedList<Integer>> results2 = new LinkedList<LinkedList<Integer>>();		
		//result.push(input[0]);
		//results.push(result);
		//System.out.println(results);
		Arrays.sort(input);
		Arrays.sort(input2);
		combinationSum(input, input.length - 1, 8, new LinkedList<Integer>(), results);
		System.out.println(results);
		combinationSum(input2, input2.length - 1, 5, new LinkedList<Integer>(), results2);
		System.out.println(results2);
	}
	public static void
	combinationSum(int[] arrays, int end, int remainingValue, LinkedList<Integer> result, LinkedList<LinkedList<Integer>> results){

		if(remainingValue < 0){
			return;
		}
		if(remainingValue == 0){
			if(results.indexOf(result) == -1){
				results.addLast(new LinkedList<Integer>(result));
			}
			//System.out.println("combination" + results);
			return;
		}
		if(end < 0){
			return;
		}
		for(int j = end; j >=0; j--){
			//System.out.println("before combination" + results);
			result.addFirst(arrays[j]);
			combinationSum(arrays, j - 1, remainingValue - arrays[j], result, results);			
			result.remove();
			//System.out.println("after combination" + results);
		}
		return;
	}
}