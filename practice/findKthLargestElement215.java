/*
215. Kth Largest Element in an Array

Find the kth largest element in an unsorted array. Note that it is the kth largest element in the sorted order, not the kth distinct element.

Example 1:

Input: [3,2,1,5,6,4] and k = 2
Output: 5
Example 2:

Input: [3,2,3,1,2,4,5,5,6] and k = 4
Output: 4
Note: 
You may assume k is always valid, 1 ≤ k ≤ array's length.

3,2,1,5,6,4
2


*/
import java.util.*;
class findKthLargestElement215{
	public static void main(String[] args){
		int[] array1 = {3,2,1,5,6,4};
		int[] array2 = {3,2,3,1,2,4,5,5,6};
		int k1 = 2;
		int k2 = 4;
		findKthLargestElement215 object = new findKthLargestElement215();
		//System.out.println(object.findKthLargestSolution2(array1, k1));
		System.out.println(object.findKthLargestSolution2(array2, k2));

	}
	public int findKthLargest(int[] array, int k){
		PriorityQueue<Integer> queue = new PriorityQueue<Integer>();
		for(int i = 0; i < array.length; i++){
			queue.add(array[i]);
		}
		int number = array.length - k;
		while(queue.size() != 0){
			if(number == 0){
				return queue.peek();
			}else{
				queue.poll();
				number--;
			}
		}
		return 0;
	}
	public int findKthLargestSolution2(int[] array, int k){
		if(k < 0 || array == null || k > array.length) return 0;
		int targetK = array.length - k + 1;
		randomize(array);
		int left = 0;
		int right = array.length - 1;
		while(left <= right){
			int pivot = partition(array, left, right);
			System.out.println("pivot" + pivot);
			if(pivot == targetK - 1){
				return array[pivot];
			}else if(pivot < targetK - 1){
				left = pivot + 1;
			}else{
				right = pivot - 1;
			}
		}
		return array[left];
	}
	private void randomize(int[] array){
		Random rand = new Random();
		for(int i = array.length - 1; i > 0; i--){
			int r = rand.nextInt(i + 1);
			swap(array, i, r);
		}
	}
	private void swap(int[] array, int l, int r){
		int temp = array[l];
		array[l] = array[r];
		array[r] = temp;
	}
	private int partition(int[] array, int left, int right){
		int slow = left - 1;
		int fast = left;
	
		while(fast <= right){
			if(array[fast] < array[right]){
				swap(array, fast++, ++slow);
			}else{
				fast++;
			}
		}
		swap(array, ++slow, right);
		return slow;
	}
}











