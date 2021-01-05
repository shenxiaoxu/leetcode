/*
34. find first and last position of element in sorted array.
given an array of integers nums sorted in ascending order, find starting and ending position of a given target value.
O(logn)
if target is not found in array, return [-1,-1]
in:nums =[5,7,7,8,8,10], target = 8
out:[3,4]
in:nums = [5,7,7,8,8,10],target = 6
out:[-1,-1]
solution:
binary search for target number, find it, then recuring find start and end.
*/
class SearchRange{
	public static void main(String[] args){
		int[] nums = {5,7,7,8,8,10};
		int[] nums2 = {5,7,7,8,8,10};
		int[] result = {0,0};
		int[] result2 = {0,0};
		result = searchRange(nums, 8, 0, nums.length - 1);
		result2 = searchRange(nums2, 6, 0, nums.length - 1);
		for(int i = 0; i < result.length;i++){
			System.out.println(result[i]);
		}
		for(int i = 0; i < result2.length;i++){
			System.out.println(result2[i]);
		}		
	}
	public static int[] searchRange(int[] nums, int target, int start, int end){
		int pivot = (start + end)/2;
		if(start >= end){
			int[] result = new int[2];
			result[0] = -1;
			result[1] = -1;
			return result;
		}
		if(nums[pivot] == target){
			int[] result = new int[2];
			int startIndex = pivot;
			int endIndex = pivot;
			while(nums[startIndex] == target || nums[endIndex] == target){
				if(nums[startIndex] == target){
					startIndex--;
				}
				if(nums[endIndex] == target){
					endIndex++;
				}
			}
			result[0] = startIndex + 1;
			result[1] = endIndex - 1;
			return result;
		}

		if(nums[pivot] > target){
			return searchRange(nums, target, start, pivot - 1);
		}else{
			return searchRange(nums, target, pivot + 1, end);
		}

	}
}