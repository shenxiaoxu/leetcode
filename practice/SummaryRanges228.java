/*228. Summary Ranges
Medium

532

475

Add to List

Share
Given a sorted integer array without duplicates, return the summary of its ranges.

Example 1:

Input:  [0,1,2,4,5,7]
Output: ["0->2","4->5","7"]
Explanation: 0,1,2 form a continuous range; 4,5 form a continuous range.
Example 2:

Input:  [0,2,3,4,6,8,9]
Output: ["0","2->4","6","8->9"]
Explanation: 2,3,4 form a continuous range; 8,9 form a continuous range.
algorithm:
iterate through array, two pointer ps, pe, if num[pe] = num[pe] - 1, pe++; else there is range from ps to pe, then ps = pe.
*/
class Solution {//time complexity is o(n)
    public List<String> summaryRanges(int[] nums) {
 		List<String>  result = new ArrayList();
 		if(nums.length == 0) return result;
 		if(nums.length == 1){
 			String s = String.valueOf((char)(nums[0] + '0'));
 			result.add(s);
 			return result;
 		}
 		int ps = 0, pe = 1;
 		while(pe < nums.length){
 			while(nums[pe] == nums[pe - 1] + 1){pe++;}
 			//start to pe - 1 is the new range
 			String range = "";
 			if(ps == pe - 1){range = (char)(nums[ps] + '0');}
 			else{range = (char)(nums[ps] + '0') + "->" + (char)(nums[pe - 1] + '0')};
 			ps = pe;
 			pe++;
 			result.add(range);
 		}
 		if(ps == nums.length - 1){String range = (char)(nums[ps] + '0'); result.add(range);}//one left
 		return result;     
    }
}


public class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> summary = new ArrayList<>();
        for (int i = 0, j = 0; j < nums.length; ++j) {
            // check if j + 1 extends the range [nums[i], nums[j]]
            if (j + 1 < nums.length && nums[j + 1] == nums[j] + 1)
                continue;
            // put the range [nums[i], nums[j]] into the list
            if (i == j)
                summary.add(nums[i] + "");
            else
                summary.add(nums[i] + "->" + nums[j]);
            i = j + 1;
        }
        return summary;
    }
}