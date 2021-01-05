/*
81.search in rotated sorted arrayII
sorted array in ascending order is rotated at some pivot
[0,0,1,2,2,5,6] become [2,5,6,0,0,1,2]
in:[2,5,6,0,0,1,2] target = 0
out: true
in:[2,5,6,0,0,1,2] target = 3
out: false
*/
class SearchII{
	public static void main(String[] args){
		int[] nums = {2,0,0,0,0,0,2};
		boolean result = search(nums, -1, 0, nums.length - 1);
		boolean result2 = search(nums, 3, 0, nums.length - 1);
		System.out.println(result);
		System.out.println(result2);
	}
	public static boolean search(int[] nums, int target, int start, int end){
		int pivot = (start + end)/2;
		if(start > end){
			return false;
		}
		if(start == end && nums[pivot] != target){
			return false;
		}
		if(nums[pivot] == target){
			return true;
		}

		while(start <= end && nums[start] == nums[end] && target != nums[start]){
			start++;
			end--;
		}
		while(start <= end - 1 && nums[end] == nums[end - 1]){
			end--;
		}
		while(start + 1 <= end && nums[start] == nums[start + 1]){
			start++;
		}
		boolean result = false;
		boolean result2 = false;
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
		if(result)
			return true;
		if(result2)
			return true;
		return false;
	}
}