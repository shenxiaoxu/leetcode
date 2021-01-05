/*
78.subsets
given a set of distinct integers, return all possible subsets
in: nums = [1,2,3]
out:
[
[3],
[1]
[2].
[1,2,3]
[1,3]
[2,3]
[1,2]
[]
]
*/
import java.util.*;
class Subsets{
	public static void main(String[] args){
		int[] array = {1,2,3};
		LinkedList<LinkedList<Integer>> results = new LinkedList<LinkedList<Integer>>();
		subsets(results, new LinkedList<Integer>(), array);
		LinkedList<Integer> result = new LinkedList<Integer>();
		results.add(result);
		System.out.println(results);
	}
	public static void subsets(LinkedList<LinkedList<Integer>> results, LinkedList<Integer> result, int[] array){
		//System.out.println(result);

		if(results.indexOf(result) == -1 && result.size() != 0){
			//System.out.println(result);
			Collections.sort(result);
			if(results.indexOf(result) == -1){
				results.addFirst(new LinkedList<Integer>(result));
			}
			//return;
		}
		for(int i = 0; i < array.length; i++){
			if(result.indexOf(array[i]) == -1){
				 result.addFirst(array[i]);				
				 subsets(results, result, array);
				 result.poll();
			}
		}
		return;
	}
}