/*
90.subsets II
given a collection of integers might contain duplicates, return all possible subsets
[1,2,2]
[
[2],
[1],
[1,2,2],
[2,2],
[1,2],
[]
]
*/
import java.util.*;
class Subsetswithdup{
	public static void main(String[] args){
		int[] array = {1,2,2};
		LinkedList<LinkedList<Integer>> results = new LinkedList<LinkedList<Integer>>();
		subsets(results, new LinkedList<Integer>(), array, 0);
		LinkedList<Integer> result = new LinkedList<Integer>();
		results.add(result);
		System.out.println(results);
	}
	public static void subsets(LinkedList<LinkedList<Integer>> results, LinkedList<Integer> result, int[] array, int index){
		//System.out.println(result);
		Collections.sort(result);
		if(results.indexOf(result) == -1 && result.size() <= array.length && result.size() > 0){
			//System.out.println(result);
			Arrays.sort(array);
			int[] count = new int[array.length];
			boolean satisfy = false;
			for(int i = 0; i < count.length; i++){
				count[i] = 0;
			}
			for(int i = 0; i < result.size(); i++){
				for(int j = 0; j < array.length; j++){
					if(array[j] == result.get(i) && count[j] == 0){
						count[j] = 1;
						break;
					}
				}
			}
			int temp = 0;
			for(int i = 0; i < count.length; i++){
				if(count[i] == 1){
					temp++;
				}
			}
			if(temp == result.size()){
				satisfy = true;
			}
			if(satisfy){
				results.addFirst(new LinkedList<Integer>(result));
			}
			//return;
		}
		for(int i = index; i < array.length; i++){
			result.addFirst(array[i]);				
			subsets(results, result, array, index + 1);
			result.poll();
		}
		return;
	}
}