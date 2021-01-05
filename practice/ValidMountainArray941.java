/*941. Valid Mountain Array
Easy

Given an array A of integers, return true if and only if it is a valid mountain array.

Recall that A is a mountain array if and only if:

A.length >= 3
There exists some i with 0 < i < A.length - 1 such that:
A[0] < A[1] < ... A[i-1] < A[i]
A[i] > A[i+1] > ... > A[A.length - 1]


 

Example 1:

Input: [2,1]
Output: false
Example 2:

Input: [3,5,5]
Output: false
Example 3:

Input: [0,3,2,1]
Output: true
 

Note:

0 <= A.length <= 10000
0 <= A[i] <= 10000 
*/
class ValidMountainArray941{
	public static void main(String[] args){
		int[] input1 = {2,1};
		int[] input2 = {3,5,5};
		int[] input3 = {0,3,2,1};
		int[] input4 = {0,2,3,3,5,2,1,0};
		int[] input5 = {0,1,2,4,2,1};
		ValidMountainArray941 object = new ValidMountainArray941();
		System.out.println(object.MountainArraySolution2(input1));
		System.out.println(object.MountainArraySolution2(input2));
		System.out.println(object.MountainArraySolution2(input3));
		System.out.println(object.MountainArraySolution2(input4));
		System.out.println(object.MountainArraySolution2(input5));
	}
	public boolean MountainArray(int[] array){
		for(int i = 1; i < array.length-1; i++){
			int element = array[i];
			int ori = element;
			int low = i - 1;
			int high = i + 1;
			boolean flag = true;
			while(low >= 0){
				if(array[low] >= element){
					flag = false;
					break;
				}else{
					if(low == 0 && array[low] < element){
						break;
					}
					element = array[low];
					low--;
				}
			}
			element = ori;
			while(high <= array.length - 1){
				if(array[high] >= element){
					flag = false;
					break;
				}else{
					if(high == array.length - 1 && array[high] < element){
						break;
					}
					element = array[high];
					high++;
				}				
			}
			//System.out.println("low" + low + "high" + high + "flag" + flag);
			if(low == 0 && high == array.length - 1 && flag == true){
				return true;
			}
		}
		return false;
	}
	public boolean MountainArraySolution2(int[] array){
		int N = array.length;
		int i = 0;
		while(i + 1 < N && array[i + 1] > array[i])
			i = i + 1;
		if(i == 0 || i == N - 1)
			return false;
		while(i + 1 < N && array[i + 1] < array[i])
			i = i + 1;
		return i == N - 1;
	}
}