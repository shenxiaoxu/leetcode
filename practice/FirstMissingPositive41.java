/*41. First Missing Positive
Hard

2629

715

Add to List

Share
Given an unsorted integer array, find the smallest missing positive integer.

Example 1:

Input: [1,2,0]
Output: 3
Example 2:

Input: [3,4,-1,1]
Output: 2
Example 3:

Input: [7,8,9,11,12]
Output: 1
Note:

Your algorithm should run in O(n) time and uses constant extra space.
*/
class Solution {
    public int firstMissingPositive(int[] nums) {
        int i = 0
        while(i < nums.length){
        	if(nums[i] >= 1 && nums[i] - 1 < nums.length && nums[nums[i] - 1] != nums[i]){
        		swap(nums, i, nums[i] - 1);
        	}else{
        		i++;
        	}
        }
        int i = 0;
        while(i < nums.length && nums[i] == nums[nums[i] - 1]){
        	i++;
        }
        return i + 1;
    }
    public void swap(int[] nums, int i, int j){
    	int tmp = nums[i];
    	nums[i] = nums[j];
    	nums[j] = tmp;
    }
}