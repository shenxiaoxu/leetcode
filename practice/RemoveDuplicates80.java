/*
80. remove duplicates from sorted array II
given a sorted array nums, remove duplicates in place that duplicates appeared at most twice and return the new length.
don't allocate extra space, do this by modifying input array in-place with o1 extra memory. passed by reference.
given nums = [1,1,1,2,2,3]
return length 5 with  1,1,2,2,3
given nums = [0,0,1,1,1,1,2,3,3]
return length 7 with 0,0,1,1,2,3,3
*/
import java.util.*;
class RemoveDuplicates{
	public static void main(String[] args){
		int[] nums1 ={1,1,1,2,2,3};
		int[] nums2 = {0,0,1,1,1,1,2,3,3};
		int length1 = 0;
		int length2 = 0;
		length1 = removeDuplicates(nums1);
		for(int i = 0; i <= length1; i++){
			System.out.println(nums1[i]);
		}
		length2 = removeDuplicates(nums2);
		for(int i = 0; i <= length2; i++){
			System.out.println(nums2[i]);
		}
	}
	public static int removeDuplicates(int[] nums){
		int count = 1;
		int endIndex = nums.length - 1;
		for(int i = 0; i <= endIndex; i++){
			int previous = nums[i];
			while(i + 1 < endIndex && nums[i + 1] == previous){
				count++;
				if(count > 2){
					swap(nums, i + 1, endIndex);
					endIndex--;
				}
				i++;
			}
			count = 1;
		}
		Arrays.sort(nums, 0, endIndex + 1);
		return endIndex;
	}
	public static void swap(int[]nums, int i, int j){
		int swap = 0;
		swap = nums[i];
		nums[i] = nums[j];
		nums[j] = swap;
	}
}