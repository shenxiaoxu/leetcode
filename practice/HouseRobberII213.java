/*
213. House Robber II
Medium

You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed. All houses at this place are arranged in a circle. That means the first house is the neighbor of the last one. Meanwhile, adjacent houses have security system connected and it will automatically contact the police if two adjacent houses were broken into on the same night.

Given a list of non-negative integers representing the amount of money of each house, determine the maximum amount of money you can rob tonight without alerting the police.

Example 1:

Input: [2,3,2]
Output: 3
Explanation: You cannot rob house 1 (money = 2) and then rob house 3 (money = 2),
             because they are adjacent houses.
Example 2:

Input: [1,2,3,1]
Output: 4
Explanation: Rob house 1 (money = 1) and then rob house 3 (money = 3).
             Total amount you can rob = 1 + 3 = 4.
*/
class HouseRobberII213{
	public static void main(String[] args){
		int[] array = {2,3,2};
		int[] array2 = {1,2,3,1};
		HouseRobberII213 object = new HouseRobberII213();
		System.out.println(object.rob(array));
		System.out.println(object.rob(array2));
	}

    public int rob(int[] nums) {
     	int result_rb = 0;
        int result_nrb = 0;
     	int previous_rb = 0;
        int previous_nrb = 0;
     	int prepre_rb = 0;
        int prepre_nrb = 0;
     	
     	if(nums.length == 0) return 0;
     	if(nums.length == 1) return nums[0];
     	if(nums.length == 2) return Math.max(nums[0],nums[1]);
     	prepre_rb = nums[0];
     	previous_rb = Math.max(nums[0], nums[1]);
        prepre_nrb = 0;
        previous_nrb = nums[1];

     	for(int i = 2; i < nums.length; i++){
     		if(i == nums.length - 1){
                result_rb = previous_rb;
                result_nrb = Math.max((nums[i] + prepre_nrb), previous_nrb);
                break;
            }
            result_rb = Math.max((nums[i] + prepre_rb), previous_rb);
     		prepre_rb = previous_rb;
     		previous_rb = result_rb;
            result_nrb = Math.max((nums[i] + prepre_nrb), previous_nrb);
            prepre_nrb = previous_nrb;
            previous_nrb = result_nrb;

     	}
     	return Math.max(result_rb, result_nrb);   
    }    	
}







