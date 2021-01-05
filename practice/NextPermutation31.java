/*
31.next permutation, which rearrage numbers into lexicographically next greater permutation of numbers.
rearrange it as lowest possible order.
in 1,2,3 out: 1,3,2
in 3,2,1 out 1,2,3
in 1,1,5 out 1,5,1
replace in place and use constant memory
*/
import java.util.*;
class NextPermutation{
	public static void nextPermutation(int[] nums){
		int i = 0;
		while(i + 1 < nums.length && nums[i] > nums[i + 1]){
			i++;
		}
		if(i + 1 == nums.length){
			Arrays.sort(nums);
		}else{
			while(i + 1 < nums.length && nums[i] <= nums[i + 1]){
				i++;
			}
			int start = i;
			int end = nums.length - 1;
			while(start < end){
				if(nums[end - 1] < nums[end]){
					i = end;
					break;
				}
				end--;
			}

			if(i + 1 == nums.length || nums[i] > nums[i + 1] ){
				int firstNumberIndex = i - 1;
				int secondNumberIndex = i;
				int minimum = nums[i] - nums[i - 1];
				while(i < nums.length){
					if(nums[i] - nums[firstNumberIndex] < minimum){
						secondNumberIndex = i;
					}
					i++;
				}
				int temp = nums[firstNumberIndex];
				nums[firstNumberIndex] = nums[secondNumberIndex];
				nums[secondNumberIndex] = temp;

				Arrays.sort(nums, firstNumberIndex + 1, nums.length );
				
			}
		}
		for(int j = 0; j < nums.length; j++){
			System.out.println(nums[j]);
		}
	}

	public static void main(String[] args){
		int[] nums = {1,2,3,4};
		int[] nums1 = {3,2,0,1};
		int[] nums2 = {1,4,3,2};
		int[] nums3 = {2,3,1,4};
		nextPermutation(nums);
		nextPermutation(nums1);
		nextPermutation(nums2);
		nextPermutation(nums3);
	}
}