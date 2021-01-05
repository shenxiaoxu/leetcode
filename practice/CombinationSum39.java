/*
39.Combination sum
give a set of candidate numbers(without duplicates) and a target number,find all unique combinations in candidates where the candidate numbers
sums to target.
the same repeated number may be chosen unlimited number of times.
all numbers will be positive integers.
solution set must not contain duplicate combinations.
in:[2,3,6,7] target = 7, [[7],[2,2,3]]
in:[2,3,5] target = 8, [[2,2,2,2],[2,3,3],[3,5]]
solution: sorted array,
from end of array, recuring chose from end of element for remaining value as long as the value is not bigger than remaining value.
*/
import java.util.*;
class CombinationSum{
	public static void main(String[] args){
		int[] input = {2,3,6,7};
		int[] input2 = {2,3,5};
		LinkedList<LinkedList<Integer>> results = new LinkedList<LinkedList<Integer>>();
		LinkedList<LinkedList<Integer>> results2 = new LinkedList<LinkedList<Integer>>();		
		//result.push(input[0]);
		//results.push(result);
		//System.out.println(results);
		Array.sort(results);
		Array.sort(results2);
		combinationSum(input, input.length - 1, 7, new LinkedList<Integer>(), results);
		System.out.println(results);
		combinationSum(input2, input2.length - 1, 8, new LinkedList<Integer>(), results2);
		System.out.println(results2);
	}
	public static void
	combinationSum(int[] arrays, int end, int remainingValue, LinkedList<Integer> result, LinkedList<LinkedList<Integer>> results){
		if(end < 0){
			return;
		}
		if(remainingValue < 0){
			return;
		}
		if(remainingValue == 0){
			results.addLast(new LinkedList<Integer>(result));
			System.out.println("combination" + results);
			return;
		}

		for(int j = end; j>=0; j--){
			System.out.println("before combination" + results);
			result.addFirst(arrays[j]);
			combinationSum(arrays, j, remainingValue - arrays[j], result, results);			
			result.remove();
			System.out.println("after combination" + results);
		}
		return;
	}
}