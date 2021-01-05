/*
46.permutations
given a collection of distinct integers, return all possible permutations.
in:[1,2,3]
out:[[1,2,3][1,3,2][2,1,3][2,3,1][3,1,2][3,2,1]]
solution:
for each one, recuring add to list, if the number to 3, and to the results
*/
import java.util.*;
class Permute{
	public static void main(String[] args){
		int[] array = {1,2,3};
		LinkedList<LinkedList<Integer>> results = new LinkedList<LinkedList<Integer>>();
		permutations(results, new LinkedList<Integer>(), array);
		System.out.println(results);
	}
	public static void permutations(LinkedList<LinkedList<Integer>> results, LinkedList<Integer> result, int[] array){
		if(result.size() == array.length ){
			results.addFirst(new LinkedList<Integer>(result));
			return;
		}
		for(int i = 0; i < array.length; i++){
			if(result.indexOf(array[i]) == -1){
				 result.addFirst(array[i]);				
				 permutations(results, result, array);
				 result.poll();
			}
		}
		return;
	}
}