/*55. Jump Game
Medium

3031

270

Add to List

Share
Given an array of non-negative integers, you are initially positioned at the first index of the array.

Each element in the array represents your maximum jump length at that position.

Determine if you are able to reach the last index.

Example 1:

Input: [2,3,1,1,4]
Output: true
Explanation: Jump 1 step from index 0 to 1, then 3 steps to the last index.
Example 2:

Input: [3,2,1,0,4]
Output: false
Explanation: You will always arrive at index 3 no matter what. Its maximum
             jump length is 0, which makes it impossible to reach the last index.

*/
class Solution {
enum Index{
	Good, Bad, Unknown
}    
    public boolean canJump(int[] nums) {
        Index[] dp = new Index[nums.length];
        for(int i = 0; i < nums.length; i++){
        	dp[i] = Index.Unknown;
        }
        dp[nums.length - 1] = Index.Good;
        for(int i = nums.length - 2; i>=0; i--){
        	int farestJump = i + nums[i];
        	for(j = i + 1; j <= farestJump; j++){
        		if(j < nums.length && nums[j] == Index.Good){
        			dp[i] = Index.Good;
        			break;
        		}
        	}
        }
        return dp[0] == Index.Good?1:0;
    }
}             