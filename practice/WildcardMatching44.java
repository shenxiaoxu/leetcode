/*44. Wildcard Matching
Hard

1582

92

Add to List

Share
Given an input string (s) and a pattern (p), implement wildcard pattern matching with support for '?' and '*'.

'?' Matches any single character.
'*' Matches any sequence of characters (including the empty sequence).
The matching should cover the entire input string (not partial).

Note:

s could be empty and contains only lowercase letters a-z.
p could be empty and contains only lowercase letters a-z, and characters like ? or *.
Example 1:

Input:
s = "aa"
p = "a"
Output: false
Explanation: "a" does not match the entire string "aa".
Example 2:

Input:
s = "aa"
p = "*"
Output: true
Explanation: '*' matches any sequence.
Example 3:

Input:
s = "cb"
p = "?a"
Output: false
Explanation: '?' matches 'c', but the second letter is 'a', which does not match 'b'.
Example 4:

Input:
s = "adceb"
p = "*a*b"
Output: true
Explanation: The first '*' matches the empty sequence, while the second '*' matches the substring "dce".
Example 5:

Input:
s = "acdcb"
p = "a*c?b"
Output: false*/
//attention: aa, *;
//attention adceb, *a*b


class Solution {
    public boolean isMatch(String s, String p) {
        boolean[][] dp = new boolean[p.length() + 1][s.length() + 1];
        dp[0][0] = true;

        for(int i = 1; i < s.length(); i++){
        	dp[0][i] = false;
        }

        for(int i = 1; i < p.length(); i++){
        	if(p.charAt(i - 1) == '?'){
        		dp[i][0] = false;
        	}else if(p.charAt(i - 1) == '*'){
        		dp[i][0] = dp[i - 1][0];
        	}else{
        		dp[i][0] = false;
        	}
        }
        for(int i = 1; i < p.length() + 1; i++){
        	for(int j = 1; j < s.length() + 1; j++){
        		if(p.charAt(i - 1) == '*'){
        			dp[i][j] = dp[i - 1][j] || dp[i][j - 1] || dp[i - 1][j - 1];
        		}else if(p.charAt(i - 1) == '?'){
        			dp[i][j] = dp[i - 1][j - 1];
        		}else{
        			if(p.charAt(i - 1) == s.charAt(j - 1)){
        				dp[i][j] = dp[i - 1][j - 1];
        			}else{
        				dp[i][j] = false;
        			}
        		}
        	}
        }
        return dp[p.length()][s.length()];
    }
    // attention all pIdx < pLen O(min(s,p)) for best case and O(SlongP) for average case.
    public boolean isMatch(String s, String p) {
    	int sIdx = 0;
    	int pIdx = 0;
    	int startIdx = -1;
    	int sTmpIdx = -1;

    	int sLen = s.length();
    	int pLen = p.length();

    	while(sIdx < sLen){
    		//if character is same or character is '?', the add both pointer
    		if(pIdx < pLen && (s.charAt(sIdx) == p.charAt(pIdx) || p.charAt(pIdx) == '?')){
    			sIdx++;
    			pIdx++;
    		}else if(pIdx < pLen && p.charAt(pIdx) == '*'){//try p matches no sequence.
    			startIdx = pIdx;
    			sTmpIdx = sIdx;
    			pIdx++;
    		}else if(startIdx == -1){//if p and s is not equal or run out of pattern
    			return false;
    		}else{//use * match one more string
    			pIdx = startIdx + 1;
    			sIdx = sTmpIdx + 1;
    			sTmpIdx = sIdx;
    		}
    	}
    	while(pIdx < pLen){// attention while need to add.
    		if(p.charAt(pIdx) != '*') return false;
    		pIdx++;
    	}
    	return true;
    }
}


























