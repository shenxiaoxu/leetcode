/*35. Search Insert Position

Given a sorted array and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order.

You may assume no duplicates in the array.

Example 1:

Input: [1,3,5,6], 5
Output: 2
Example 2:

Input: [1,3,5,6], 2
Output: 1
Example 3:

Input: [1,3,5,6], 7
Output: 4
Example 4:

Input: [1,3,5,6], 0
Output: 0
*/
class SearchInsert35{
    public int searchInsert(int[] nums, int target) {
     	if(nums.length == 0) return 0;
     	int result = searchInsertHelper(nums, target,0,nums.length - 1);
     	return result;   
    }
    public int searchInsertHelper(int[] nums, int target, int start, int end){
    	if(start > end) return start;
    	int mid = start + (end - start)/2;
    	int result = 0;
    	if(nums[mid] == target){
    		return mid;
    	}else if(nums[mid] < target){
    		result = searchInsertHelper(nums, target, mid + 1, end);
    	}else{
    		result = searchInsertHelper(nums, target, start, mid - 1);
    	}
    	return result;
    }	
}