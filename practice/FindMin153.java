/*
153.find minimum in rotated sorted array
in:[3,4,5,1,2]
out:1
*/
class FindMin{
	public static void main(String[] args){
		int[] nums = {4,5,6,7,0,1,2};
		int[] nums1 = {3,4,5,1,2};
		int result = search(nums, 0, nums.length - 1, Integer.MAX_VALUE);
		int result2 = search(nums1, 0, nums1.length - 1, Integer.MAX_VALUE);
		System.out.println(result);
		System.out.println(result2);
	}
	public static int search(int[] nums, int start, int end, int minimum){
		int pivot = (start + end)/2;
		if(start > end){
			return minimum;
		}
		if(minimum > nums[pivot]){
			System.out.println("minimum: " + nums[pivot]);
			minimum = nums[pivot];
		}

		int result = Integer.MAX_VALUE;
		int result2 = Integer.MAX_VALUE;
		if(nums[start] < nums[pivot]){
			result = search(nums, pivot + 1, end, minimum);
			if(nums[start] < minimum){
				minimum = nums[start];
			}
			result = Math.min(result, minimum);
		}
		if(nums[pivot] < nums[end]){
			result2 = search(nums, start, pivot - 1, minimum);
			if(nums[pivot] < minimum){
				minimum = nums[pivot];
			}
			result2 = Math.min(result2, minimum);
		}
		return Math.min(result, result2);
	}
}