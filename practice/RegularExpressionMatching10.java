/*10. Regular Expression Matching
Hard

Given an input string (s) and a pattern (p), implement regular expression matching with support for '.' and '*'.

'.' Matches any single character.
'*' Matches zero or more of the preceding element.
The matching should cover the entire input string (not partial).

Note:

s could be empty and contains only lowercase letters a-z.
p could be empty and contains only lowercase letters a-z, and characters like . or *.
Example 1:

Input:
s = "aa"
p = "a"
Output: false
Explanation: "a" does not match the entire string "aa".
Example 2:

Input:
s = "aa"
p = "a*"
Output: true
Explanation: '*' means zero or more of the preceding element, 'a'. Therefore, by repeating 'a' once, it becomes "aa".
Example 3:

Input:
s = "ab"
p = ".*"
Output: true
Explanation: ".*" means "zero or more (*) of any character (.)".
Example 4:

Input:
s = "aab"
p = "c*a*b"
Output: true
Explanation: c can be repeated 0 times, a can be repeated 1 time. Therefore, it matches "aab".
Example 5:

Input:
s = "mississippi"
p = "mis*is*p*."
Output: false

*/

class RegularExpressionMatching10{
	public static void main(String[] args){
		String s = "aa";
		String p = "a";

		String s1 = "aa";
		String p1 = "a*";

		String s2 = "ab";
		String p2 = ".*";

		String s3 = "aab";
		String p3 = "c*a*b";		

		String s4 = "mississippi";
		String p4 = "mis*is*p*";

		String s5 = "a";
		String p5 = ".*..a*";

		RegularExpressionMatching10 object = new RegularExpressionMatching10();
		//System.out.println(object.isMatchSolution2(s,p));
		//System.out.println(object.isMatchSolution2(s1,p1));
		//System.out.println(object.isMatchSolution2(s2,p2));
		//System.out.println(object.isMatchSolution2(s3,p3));
		//System.out.println(object.isMatchSolution2(s4,p4));
		System.out.println(object.isMatchSolution2(s5,p5));		
	}
	public boolean isMatch(String s, String p){
		int index1 = 0;
		int index2 = 0;
		while(index1 != s.length() && index2 != p.length()){
			char s1 = s.charAt(index1);
			char s2 = p.charAt(index2);
			System.out.println("s1: " + s1 + " s2:" + s2);
			if(s1 == '.' || s2 == '.'){
				index1++;
				index2++;
				continue;
			}
			if(s1 == '*'){
				char previous = s.charAt(index1 - 1);
				if(previous == '.'){
					return true;
				}
				s2 = p.charAt(index2 - 1);
				while(index2 + 1 <= p.length() && previous == s2){
					s2 = p.charAt(index2);
					index2++;
				}
				index2--;
				index1++;
			}
			if(s2 == '*'){
				char previous = p.charAt(index2 - 1);
				if(previous == '.'){
					return true;
				}
				s1 = s.charAt(index1 - 1);
				while(index1 + 1 <= s.length() && previous == s1){
					s1 = s.charAt(index1);
					index1++;					
				}
				index1--;
				index2++;
			}
			
			if(index1 == s.length() && index2 == p.length()){
				return true;
			}
			s1 = s.charAt(index1);
			s2 = p.charAt(index2);
			if(s1 == s2){
				index1++;
				index2++;
			}else{
				if(index1 <= s.length() - 2 && s.charAt(index1 + 1)== '*'){
					index1=index1+2;
					continue;
				}
				if(index2 <= p.length() - 2 && p.charAt(index2 + 1)== '*'){
					index2=index2+2;
					continue;
				}
				break;
			}
		}
		if(index1 != s.length() || index2 != p.length()){
			return false;
		}
		return true;
	}
	/*
	aa, a*
	TFF
	FTF
	TTT
	ab, .*
	TFF
	FTF
	TTT
	aab, c*a*b
	mississippi mis*is*p*
	"a",".*..a*"
	TF
	F
	T
	F
	T
	F
	T
	*/
	public boolean isMatchSolution2(String s, String p){
		if(s == "" || p == "") return false;
		boolean[][] dp = new boolean[p.length() + 1][s.length() + 1];
		dp[0][0] = true;
		for(int i = 1; i < s.length() + 1; i++){
			dp[0][i] = false;
		}
		for(int j = 1; j < p.length() + 1; j++){
			if(j == 1){dp[j][0]= false; continue;}
			if(p.charAt(j - 1) == '*'){
				dp[j][0] = dp[j - 2][0];
			}else{
				dp[j][0] = false;
			}
		}
		for(int i = 1; i < s.length() + 1; i++){
			for(int j = 1; j < p.length() + 1; j++){
				if(p.charAt(j - 1) == '.' || p.charAt(j - 1) == s.charAt(i - 1)){
					dp[j][i] = dp[j - 1][i - 1];
				}else if(p.charAt(j - 1) == '*'){
					if(s.charAt(i - 1) == p.charAt(j - 2) || p.charAt(j - 2) == '.'){
						dp[j][i] = dp[j - 2][i] || dp[j][i - 1];
					}else{
						dp[j][i] = dp[j - 2][i];
					}
				}
			}
		}
		return dp[p.length()][s.length()];
	}
}














