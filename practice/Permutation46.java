/*
46. Permutations
Medium

3054

93

Add to List

Share
Given a collection of distinct integers, return all possible permutations.

Example:

Input: [1,2,3]
Output:
[
  [1,2,3],
  [1,3,2],
  [2,1,3],
  [2,3,1],
  [3,1,2],
  [3,2,1]
]
*/
class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList();
        if(nums.length == 0) return result;
        int[] visited = new int[nums.length];
        permuteHelper(result, new ArrayList<Integer>(), visited, nums);
        return result;
    }
    public void permuteHelper(List<List<Integer>> result, List<Integer> cur, int[] visited, int[] nums){
        if(cur.size() == nums.length){
            result.add(new ArrayList<Integer>(cur));
            return;
        }
        for(int i = 0; i < nums.length; i++){
        	if(visited[i] != 1){
        		visited[i] = 1;
            	cur.add(nums[i]);
            	permuteHelper(result, cur, visited, nums);
            	cur.remove(cur.size() - 1);
            	visited[i] = 0;
        	}
        }
    }
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new ArrayList();
        if(nums.length == 0) return result;
        int[] visited = new int[nums.length];
        Arrays.sort(nums);
        permuteHelper(result, new ArrayList<Integer>(), visited, nums);
        return result;
    }
    public void permuteHelper(List<List<Integer>> result, List<Integer> cur, int[] visited, int[] nums){
        if(cur.size() == nums.length){
            result.add(new ArrayList<Integer>(cur));
            return;
        }
        for(int i = 0; i < nums.length; i++){
        	if(i > 0 && !visited[i - 1] && nums[i - 1] == nums[i]) continue;
        	if(visited[i] != 1){
        		visited[i] = 1;
            	cur.add(nums[i]);
            	permuteHelper(result, cur, visited, nums);
            	cur.remove(cur.size() - 1);
            	visited[i] = 0;
        	}
        }
    }    
}






