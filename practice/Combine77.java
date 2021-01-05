/*
77.combinations
given n,k return all possible combinations of k out of n
n = 4, k = 2
out
[
[2,4],
[3,4],
[2,3],
[1,2],
[1,3],
[1,4]
]
*/
import java.util.*;
class Combine{
	public static void main(String[] args){
		int n = 4; 
		int k = 2;
		LinkedList<LinkedList<Integer>> results = new LinkedList<LinkedList<Integer>>();
		combine(results, new LinkedList<Integer>(), n,k);
		System.out.println(results);
	}
	public static void combine(LinkedList<LinkedList<Integer>> results, LinkedList<Integer> result, int n, int k){
		if(result.size() == k ){
			Collections.sort(result);
			if(results.indexOf(result) == -1){
				results.addFirst(new LinkedList<Integer>(result));
			}
			return;
		}
		for(int i = 1; i <= n; i++){
			if(result.indexOf(i) == -1){
				 result.addFirst(i);				
				 combine(results, result, n, k);
				 result.poll();
			}
		}
		return;
	}
}