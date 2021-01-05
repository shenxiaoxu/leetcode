/*60. Permutation Sequence
Medium

1167

286

Add to List

Share
The set [1,2,3,...,n] contains a total of n! unique permutations.

By listing and labeling all of the permutations in order, we get the following sequence for n = 3:

"123"
"132"
"213"
"231"
"312"
"321"
Given n and k, return the kth permutation sequence.

Note:

Given n will be between 1 and 9 inclusive.
Given k will be between 1 and n! inclusive.
Example 1:

Input: n = 3, k = 3
Output: "213"
Example 2:

Input: n = 4, k = 9
Output: "2314"
*/

class Solution {
    public String getPermutation(int n, int k) {
    	List<Integer> nums = new ArrayList(){{add(1);}};
		int[] factor = new int[n];
		factor[0] = 1;

		for(int i = 1; i < n; i++){
			factor[i] = factor[i - 1] * i;
			nums.add(i + 1);
		}
		k--;
		StringBuilder sb = new StringBuilder();
		for(int i = n - 1; i > -1;i--){
			int idx = k / factor[i];
			k -= idx*factor[i];
			sb.append(nums.get(idx));
			nums.remove(idx);
		}
		return sb.toString();        
    }
}








