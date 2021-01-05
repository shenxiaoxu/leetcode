/*
[LeetCode] 918. Maximum Sum Circular Subarray 环形子数组的最大和 



Given a circular array C of integers represented by A, find the maximum possible sum of a non-empty subarray of C.
Here, a circular array means the end of the array connects to the beginning of the array.  (Formally, C[i] = A[i] when 0 <= i < A.length, and C[i+A.length] = C[i] when i >= 0.)
Also, a subarray may only include each element of the fixed buffer A at most once.  (Formally, for a subarray C[i], C[i+1], ..., C[j], there does not exist i <= k1, k2 <= j with k1 % A.length = k2 % A.length.)
Example 1:
Input: [1,-2,3,-2]
Output: 3
Explanation: Subarray [3] has maximum sum 3
Example 2:
Input: [5,-3,5]
Output: 10 Explanation: Subarray [5,5] has maximum sum 5 + 5 = 10
Example 3:
Input: [3,-1,2,-1]
Output: 4
Explanation: Subarray [2,-1,3] has maximum sum 2 + (-1) + 3 = 4
Example 4:
Input: [3,-2,2,-3]
Output: 3 Explanation: Subarray [3] and [3,-2,2] both have maximum sum 3
Example 5:
Input: [-2,-3,-1]
Output: -1 Explanation: Subarray [-1] has maximum sum -1
Note:
-30000 <= A[i] <= 30000
1 <= A.length <= 30000
algorithm:
from start to end, find start and end of circular array. if it doesn't find, start and end remains
if add up smaller than negative, don't include it in.

*/
class MaximumCircularSubArray{
	public void main(String[] args){
		int[] test1 = [1,-2,3,-2];
		int[] test2 = [5,-3,5];
		int[] test3 = [3,-1,2,-1];
		int[] test4 = [3,-2,2,-3];
		int[] test5 = [-2,-3,-1];
	}
	public int maximumSubArray(int[] input){
		int startCircular = 0;
		int endCircular = input.length;
		for(int i = 0; i < input.length;i++){
			for(int j = i+1; j < input.length;j++){
				if(input[i] == input[j]){
					startCircular = i;
					endCircular = j;
				}
			}
		}
		int maximum= Integer.MIN_VALUE;
		int startIndex = 0;
		int endIndex = startIndex;
		for(int i = 0; i <= endCircular; i++){
			while(input[startIndex] < 0){
				startIndex++;
			}
			while(input[endIndex + 1] + input[endIndex + 2] >=0){
				endIndex++;
			}
			int temp = 0;
			for(int j = startIndex; j <=endIndex; j++){
				temp += input[j];
			}
			if(temp > maximum){
				maximum = temp;
			}
		}
		return maximum;
	}
}
