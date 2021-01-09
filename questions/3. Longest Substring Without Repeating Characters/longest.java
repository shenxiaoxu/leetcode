/*
Given a string s, find the length of the longest substring without repeating characters.
*/
class Solution {
    public int lengthOfLongestSubstring(String s) {
        int[] count = new int[256];
        int left = 0, right = 0, res = 0;
        while(right < s.length()){
            char c = s.charAt(right);
            count[(int)c]+=1;
            while(count[(int)c] > 1){
                count[(int)s.charAt(left)]-=1;
                left += 1;
            }
            res = Math.max(res, right - left + 1); 
            right += 1;
        }
        return res;
    }
}