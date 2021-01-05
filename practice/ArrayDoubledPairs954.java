/*954. Array of Doubled Pairs
Given an array of integers A with even length, return true if and only if it is possible to reorder it such that A[2 * i + 1] = 2 * A[2 * i] for every 0 <= i < len(A) / 2.

 

Example 1:

Input: [3,1,3,6]
Output: false
Example 2:

Input: [2,1,2,6]
Output: false
Example 3:

Input: [4,-2,2,-4]
Output: true
Explanation: We can take two groups, [-2,-4] and [2,4] to form [-2,-4,2,4] or [2,4,-2,-4].
Example 4:

Input: [1,2,4,16,8,4]
Output: false
 

Note:

0 <= A.length <= 30000
A.length is even
-100000 <= A[i] <= 100000
solution:
take two groups, one group integer is twice larger than another group. hashmap integer, if half of integer is in the map, mark is true, check all hashmap if it's all true
if it's all true, return true, otherwise return false;
-4,-2,2,4
-2,-1,1,2
-8,-4,4,8
*/
import java.util.*;
class ArrayDoubledPairs954{
	public static void main(String[] args){
		int[] array1 = {2,4,8,16};
		int[] array2 = {3,1,3,6};
		int[] array3 = {2,1,2,6};
		int[] array4 = {4,-2,2,-4};
		int[] array5 = {1,2,4,16,8,4};
		int[] array6 = {4,-4,4,-2,-4,-8};
		//System.out.println(ArrayDoubledPairs(array1));
		//System.out.println(ArrayDoubledPairs(array2));
		//System.out.println(ArrayDoubledPairs(array3));
		//System.out.println(ArrayDoubledPairs(array4));
		//System.out.println(ArrayDoubledPairs(array5));
		System.out.println(ArrayDoubledPairs(array6));
	}
	/*
	public static boolean ArrayDoubledPairs(int[] array){
		int[] solution = new int[array.length];
		int[] doublearray = new int[array.length];
		int[] halfarray = new int[array.length];
		for(int i = 0; i < array.length;i++){
			doublearray[i] = array[i] * 2;
		}
		for(int i = 0; i < array.length;i++){
			halfarray[i] = array[i] / 2;
		}		
		
		int count = 0;
		int[] countArray = new int[100001];
		for(int i = 0; i < 100001;i++){
			countArray[i] = -1;
		}
		for(int i = 0; i < array.length;i++){
			countArray[array[i]] = 1;
		}
		for(int j = 0; j < doublearray.length;j++){
			if(countArray[doublearray[j]] == 1){
				count++;
			}
		}
		if(count != doublearray.length/2){
			return false;
		}
		count = 0;
		for(int j = 0; j < halfarray.length;j++){
			if(countArray[halfarray[j]] == 1){
				count++;
			}
		}
		if(count != halfarray.length/2){
			return false;
		}		
		return true;		
	}
	first solution
	*/

	public static boolean ArrayDoubledPairs(int[] array){
		Map<Integer, Integer> dictionary = new HashMap<Integer, Integer>();
		SortedSet<Integer> keys = new TreeSet<Integer>(new Comparator<Integer>(){
			public int compare(Integer a, Integer b){
				if(Math.abs(a) == Math.abs(b)){
					return a<b?a:b;
				}else{
					return Math.abs(a) - Math.abs(b);
				}
			}
		});
		for(int i = 0; i < array.length; i++){
			if(dictionary.containsKey(array[i])){
				int result = dictionary.get(array[i]) + 1;
				dictionary.put(array[i],result);
			}else{
				dictionary.put(array[i], 1);
			}
		}
		Set<Map.Entry<Integer, Integer>> setmap = dictionary.entrySet();
		Iterator<Map.Entry<Integer, Integer>> it = setmap.iterator();
		while(it.hasNext()){
			Map.Entry<Integer, Integer> entry= it.next();
			keys.add(entry.getKey());
		}
		for(Integer a : keys){
			System.out.println(" integer:" + a);
			if(dictionary.containsKey(a) && dictionary.containsKey(2*a) && dictionary.get(a) > dictionary.get(2*a)) return false;
			//if(!dictionary.containsKey(a)) return false;
			if(dictionary.containsKey(a) && dictionary.get(a) == 0) {
				continue;
			}
			
			if(dictionary.containsKey(a) && dictionary.containsKey(2*a)){
				int result = dictionary.get(2*a) - dictionary.get(a);
				dictionary.put(2*a,result);
			}else{
				return false;
			}
		
		}
		return true;
	}
}

//[4,-4,4,-2,-4,-8]
		//int[] array1 = {2,4,8,16};
		//int[] array2 = {3,1,3,6};
		//int[] array3 = {2,1,2,6};
		//int[] array4 = {4,-2,2,-4};
		//int[] array5 = {1,2,4,16,8,4};



















