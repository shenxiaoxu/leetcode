/*
47.permutations II
given a collection of numbers that might contain duplicates, return all possible
unique permutations.
in:[1,1,2]
out:
[[1,1,2],[1,2,1],[2,1,1]]
solution:
choose one random, put in the result, before, left result not in the same element, if size = 3, add to results
*/
import java.util.*;
class PermuteUnique{
	public static void main(String[] args){
		int[] array = {1,1,2};
		int[] markedArray = {0,0,0};
		LinkedList<LinkedList<Integer>> results = new LinkedList<LinkedList<Integer>>();
		permutations(results, new LinkedList<Integer>(), array, markedArray);
		System.out.println(results);
	}
	public static void permutations(LinkedList<LinkedList<Integer>> results, LinkedList<Integer> result, int[] array, int[] markedArray){
		if(result.size() == array.length){
			if(results.indexOf(result) == -1){
				results.add(new LinkedList<Integer>(result));
			}
			//for(int j = 0; j < markedArray.length; j++){
			//	markedArray[j] = 0;
			//}
			return;
		}
		for(int i = 0; i < array.length;i++){
			if(markedArray[i] == 0){
				result.addFirst(array[i]);
				markedArray[i] = 1;
				permutations(results, result,array,markedArray);
				markedArray[i] = 0;
				result.poll();
			}
		}
	}

}