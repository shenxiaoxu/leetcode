/*
312. Burst Balloons

Given n balloons, indexed from 0 to n-1. Each balloon is painted with a number on it represented by array nums. You are asked to burst all the balloons. If the you burst balloon i you will get nums[left] * nums[i] * nums[right] coins. Here left and right are adjacent indices of i. After the burst, the left and right then becomes adjacent.

Find the maximum coins you can collect by bursting the balloons wisely.

Note:

You may imagine nums[-1] = nums[n] = 1. They are not real therefore you can not burst them.
0 ≤ n ≤ 500, 0 ≤ nums[i] ≤ 100
Example:

Input: [3,1,5,8]
Output: 167 
Explanation: nums = [3,1,5,8] --> [3,5,8] -->   [3,8]   -->  [8]  --> []
             coins =  3*1*5      +  3*5*8    +  1*3*8      + 1*8*1   = 167
*/
class BurstBalloons312{
	public static void main(String[] args){
		int[] array = new int[4];
		array[0] = 3;
		array[1] = 1;
		array[2] = 5;
		array[3] = 8;
		BurstBalloons312 object = new BurstBalloons312();
		System.out.println(object.maxCoins(array));
	}
    public int maxCoins(int[] nums) {
    	int[] coins = new int[nums.length + 2];
    	int n = 1;
    	for(int c:nums){
    		if(c!=0){
    			coins[n++] = c;
    		}
    	}
    	coins[0] = coins[n++] = 1;
        
        int[][] maxCoins = new int[n][n];
        for(int dist = 2; dist < n; dist++){
        	for(int left = 0; left + dist < n; left++){
        		int right = left + dist;
        		for(int i = left + 1; i <= right - 1; i++){
        			maxCoins[left][right] = Math.max(maxCoins[left][right],coins[i] * coins[left] * coins[right] + maxCoins[left][i] + maxCoins[i][right]);
        		}

        	}
        }
        return maxCoins[0][n - 1];
    }
}










