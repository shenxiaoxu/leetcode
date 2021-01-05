/*
34. Find First and Last Position of Element in Sorted Array
Medium

2597

116

Add to List

Share
Given an array of integers nums sorted in ascending order, find the starting and ending position of a given target value.

Your algorithm's runtime complexity must be in the order of O(log n).

If the target is not found in the array, return [-1, -1].

Example 1:

Input: nums = [5,7,7,8,8,10], target = 8
Output: [3,4]
Example 2:

Input: nums = [5,7,7,8,8,10], target = 6
Output: [-1,-1]
*/
class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] result = {-1,-1};
        int leftIdx = extremeIndex(nums, target, true);
        if(leftIdx == nums.length || nums[leftIdx] != target){
        	return result;
        }
        result[0] = leftIdx;
        result[1] = extremeIndex(nums, target, false) - 1;
        return result;

    }
    public int extremeIndex(int[] nums, int target, boolean left){
        int lo = 0;
        int hi = nums.length; 
        while(lo < hi){
        	int mid = (lo + hi)/2;
        	if(nums[mid] > target || (left && nums[mid] == target)){
        		hi = mid;
        	}else{
        		lo = mid + 1;
        	}
        }
        return lo;  	
    }
}