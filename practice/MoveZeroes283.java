/*283. Move Zeroes
Easy

3044

102

Add to List

Share
Given an array nums, write a function to move all 0's to the end of it while maintaining the relative order of the non-zero elements.

Example:

Input: [0,1,0,3,12]
Output: [1,3,12,0,0]
Note:

You must do this in-place without making a copy of the array.
Minimize the total number of operations.*/
class Solution {
    public void moveZeroes(int[] nums) {
        int zero = 0;
        for(int i = 0; i < nums.length; i++){
        	if(nums[i] == 0) zero++; continue;
        	if(i - zero >= 0){
        		nums[i - zero] = nums[i];
        	}
        }
        for(int i = nums.length - 1; i >=nums.length - zero;i--){
        	nums[i] = 0;
        }
    }
}

