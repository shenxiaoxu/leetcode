/*97. Interleaving String
Hard

Given s1, s2, s3, find whether s3 is formed by the interleaving of s1 and s2.

Example 1:

Input: s1 = "aabcc", s2 = "dbbca", s3 = "aadbbcbcac"
Output: true
Example 2:

Input: s1 = "aabcc", s2 = "dbbca", s3 = "aadbbbaccc"
Output: false
*/
class InterleavingString97 {
    public boolean isInterleave(String s1, String s2, String s3) {
        if(s1 == null || s2 == null || s2 == null) return false;
        if(s1.length() + s2.length() != s3.length()) return false;
        boolean[][] match = new boolean[s1.length() + 1][s2.length() + 1];
        match[0][0] = true;
        int s1Len = 0;
        int s2Len = 0;
        for(int idx = 0; idx < s1.length() + s2.length() + 1; idx++){
        	for(s1Len = 0; s1Len <= idx + 1 && s1Len <= s1.length(); s1Len++){
        		s2Len = idx + 1 - s1Len;
        		if(s2Len > s2.length()) continue;
        		if((s1Len > 0 && match[s1Len - 1][s2Len] && s1.charAt(s1Len - 1) == s3.charAt(idx))|| 
        			(s2Len > 0 && match[s1Len][s2Len - 1] && s2.charAt(s2Len - 1) == s3.charAt(idx))){
        			match[s1Len][s2Len] = true;
        		}
        	}
        }
        return match[s1.length()][s2.length()];
    }
}
