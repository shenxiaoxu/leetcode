/*
53. Maximum Subarray
Easy

6299

271

Add to List

Share
Given an integer array nums, find the contiguous subarray (containing at least one number) which has the largest sum and return its sum.

Example:

Input: [-2,1,-3,4,-1,2,1,-5,4],
Output: 6
Explanation: [4,-1,2,1] has the largest sum = 6.
Follow up:

If you have figured out the O(n) solution, try coding another solution using the divide and conquer approach, which is more subtle.
*/

class Solution {
    public int maxSubArray(int[] nums) {
    	if(nums.length == 0) return 0;
        int globalMax = nums[0];
        
        for(int i = 1; i<nums.length;i++){
        	if(nums[i - 1] > 0) nums[i]+=nums[i-1];
        	globalMax = Math.max(globalMax, nums[i]);
        }
        return globalMax;
    }
    public int maxSubArray(int[] nums){
    	if(nums.length == 0) return 0;
    	int result = helper(nums, 0, nums.length - 1);
    	return result;
    }
    public int helper(int[] nums, int left, int right){
    	if(left == right) return nums[left];
    	int p = (left + right)/2;
    	int leftSum = helper(nums, left, p);
    	int rightSum = helper(nums, p + 1, right);
    	int crossSum = crossSum(nums, left, right, p);

    	return Math.max(Math.max(leftSum, rightSum), crossSum);
    }
    public int crossSum(int[] nums, int left, int right, int p){
    	if(left == right) return nums[left];
    	int curLeft = 0;
    	int sumLeft = Integer,MIN_VALUE;
    	int curRight = 0;
    	int sumRight = Integer.MIN_VALUE;

    	for(int i = p; i > left - 1; --i){
    		curLeft += nums[i];
    		sumLeft = Math.max(curLeft, sumLeft);
    	}

    	for(int i = p + 1; i < right + 1; ++i){
    		curRight += nums[i];
    		sumRight = Math.max(curRight, sumRight);
    	}

    	return sumLeft + sumRight;    	
    }
}







