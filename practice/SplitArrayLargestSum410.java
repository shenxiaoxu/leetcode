/*410. Split Array Largest Sum
Hard

1418

76

Add to List

Share
Given an array which consists of non-negative integers and an integer m, you can split the array into m non-empty continuous subarrays.
 Write an algorithm to minimize the largest sum among these m subarrays.

Note:
If n is the length of array, assume the following constraints are satisfied:

1 ≤ n ≤ 1000
1 ≤ m ≤ min(50, n)
Examples:

Input:
nums = [7,2,5,10,8]
m = 2

Output:
18

Explanation:
There are four ways to split nums into two subarrays.
The best way is to split it into [7,2,5] and [10,8],
where the largest sum among the two subarrays is only 18.*/
class Solution {//time complexity is n2
    public int splitArray(int[] nums, int m) {
    	int n = nums.length;
        int[][] dp = new int[n][n];
        for(int i = 0; i < nums.length; i++){
        	for(int j = i; j < nums.length; j++){
        		dp[i][j] = sum(nums, i, j);
        	}
        }
        int result = 0;
        rSplitArray(nums, dp, m, 0, result, n - 1);//array split into m slice, what's the biggest number.
        return result;
    }
    private int sum(int[] nums, int i, int j){
    	int result = 0;
    	for(int k = i; k <=j;k++){
    		result+=nums[k];
    	}
    	return result;
    }
    private void rSplitArray(int[] nums, int[][] dp, int m, int temp, int result, int idx){
    	if(m > 0 && idx <= 0) return;
    	if(m < 0 && idx > 0) return;
    	if(m == 0){result = Math.min(temp, result); return;}
    	for(int i = idx; i >= 0; i--){
    		temp += dp[i][idx];
    		rSplitArray(nums, dp, m - 1, temp, result, i - 1);
    		temp -= dp[i][idx];
    	}
    }
}

class Solution {
    public int splitArray(int[] nums, int m) {
        int n = nums.length;
        int[][] f = new int[n + 1][m + 1];
        int[] sub = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= m; j++) {
                f[i][j] = Integer.MAX_VALUE;
            }
        }
        for (int i = 0; i < n; i++) {
            sub[i + 1] = sub[i] + nums[i];
        }
        f[0][0] = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                for (int k = 0; k < i; k++) {
                    f[i][j] = Math.min(f[i][j], Math.max(f[k][j - 1], sub[i] - sub[k]));
                }
            }
        }
        return f[n][m];        
    }
}










