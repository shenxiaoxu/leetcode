/*
33. search in rotated sorted array
suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.
given a target balue to search. if found in array, return its index, otherwise return -1.
in: nums= [4,5,6,7,0,1,2], target = 0
out:4
in:nums = [4,5,6,7,0,1,2], target = 3
out:-1
solution:
 pivot = (start + end )/ 2
 nums[pivot] > nums[start] && target < nums[pivot] && target > nums[start] recuring find in previous part
 nums[pivot] > nums[start] && target > nums[pivot]  pivot ++; until find element or nums[pivot] < nums[end] recurring find in latter part
 nums[pivot] < nums[start] && target > nums[pivot] recuring find in latter part
 nums[pivot] < nums[start] && target < nums[pivot] recuring find in latter part pivot ++; 
 until find element or nums[pivot] > nums[start] recurring find in previous part
*/
class Search{
	public static void main(String[] args){
		int[] nums = {4,5,6,7,0,1,2};
		int result = search(nums, 0, 0, nums.length - 1);
		int result2 = search(nums, 3, 0, nums.length - 1);
		System.out.println(result);
		System.out.println(result2);
	}
	public static int search(int[] nums, int target, int start, int end){
		int pivot = (start + end)/2;
		if(start > end){
			return -1;
		}
		if(nums[pivot] == target){
			return pivot;
		}

		int result = -1;
		int result2 = -1;
		if(nums[start] <= target && nums[pivot] > target){
			result = search(nums, target, start, pivot);
		}else{
			result = search(nums, target, pivot + 1, end);
		}
		if(nums[pivot] <= target && target < nums[end]){
			result2 = search(nums, target, pivot, end);
		}else{
			result2 = search(nums, target, start, pivot - 1);
		}
		if(result != -1)
			return result;
		if(result2 != -1)
			return result2;
		return -1;
	}
}