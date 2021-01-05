/*72. Edit Distance

Given two words word1 and word2, find the minimum number of operations required to convert word1 to word2.

You have the following 3 operations permitted on a word:

Insert a character
Delete a character
Replace a character
Example 1:

Input: word1 = "horse", word2 = "ros"
Output: 3
Explanation: 
horse -> rorse (replace 'h' with 'r')
rorse -> rose (remove 'r')
rose -> ros (remove 'e')
Example 2:

Input: word1 = "intention", word2 = "execution"
Output: 5
Explanation: 
intention -> inention (remove 't')
inention -> enention (replace 'i' with 'e')
enention -> exention (replace 'n' with 'x')
exention -> exection (replace 'n' with 'c')
exection -> execution (insert 'u')
attention:
dp[i][j] = min(dp[i - 1][j], dp[i][j - 1]) + 1, dp[i - 1][j - 1] + 1 if(word1 != word2) or dp[i - 1][j - 1])
dp[i][j] means from string i to string j needs distance.
*/

class Solution {
    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        if(m*n == 0){
        	return m+n;
        }
        int[][] dp = new int[n + 1][m + 1];

        for(int i = 0; i < n + 1; i++){
        	dp[i][0] = i;
        }
        for(int j = 0; j < m + 1; j++){
        	dp[0][j] = j;
        }
        for(int i = 1; i < n + 1; i++){
        	for(int j = 1; j < m + 1; j++){
        		int left = dp[i - 1][j];
        		int up = dp[i][j - 1];
        		int left_up = dp[i - 1][j - 1];
        		if(word1.charAt(j - 1) != word2.charAt(i - 1)){
        			left_up+=1;
        		}
        		dp[i][j] = Math.min(left + 1, Math.min(up + 1, left_up));
        	}
        }
        return dp[n][m];
    }
}












