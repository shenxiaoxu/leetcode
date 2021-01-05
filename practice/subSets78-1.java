/*
78. Subsets

Given a set of distinct integers, nums, return all possible subsets (the power set).

Note: The solution set must not contain duplicate subsets.

Example:

Input: nums = [1,2,3]
Output:
[
  [3],
  [1],
  [2],
  [1,2,3],
  [1,3],
  [2,3],
  [1,2],
  []
]
*/
import java.util.*;
class Solution {
	List<List<Integer>> result = new ArrayList();
	int n,k;
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> output = new LinkedList();
        output.add(new LinkedList<Integer>());
        for(int num: nums){
        	List<List<Integer>> newsubsets = new LinkedList();
        	for(List<Integer> set:output){
        		newsubsets.add(new LinkedList<Integer>(set){{add(num);}});
        	}
        	for(List<Integer> newsubset: newsubsets){
        		output.add(newsubset);
        	}
        }
        return output;        
    }
    public List<List<Integer>> subsetsII(int[] nums){
    	n = nums.length;
    	for(k = 0; k < n+1;i++){
    		backtrack(0, new ArrayList<Integer>(), nums);
    	}
    	return result;
    }
    public void backtrack(int first, ArrayList<Integer> cur, int[] nums){
    	if(cur.size() == k){
    		result.add(new ArrayList(cur));
    	}
    	for(int i = first; i < n; i++){
    		cur.add(nums[i]);
    		backtrack(first + 1, cur, nums);
    		cur.remove(cur.size() - 1);
    	}
    }
}













