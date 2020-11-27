/*
395. Longest Substring with At Least K Repeating Characters
Given a string s and an integer k, return the length of the longest substring of s such that 
the frequency of each character in this substring is greater than or equal to k.

Example 1:

Input: s = "aaabb", k = 3
Output: 3
Explanation: The longest substring is "aaa", as 'a' is repeated 3 times.
Example 2:

Input: s = "ababbc", k = 2
Output: 5
Explanation: The longest substring is "ababb", as 'a' is repeated 2 times and 'b' is repeated 3 times.
*/
import java.util.*;
class longest{
	public int longestKCharacter(String s, int k){
		int[] count = new int[26];
		int res = 0, unique = 0;
		for(char c: s.toCharArray()){
			if(count[(int)(c - 'a')] == 0) unique++;
			count[(int)(c - 'a')]++;
		}
		
		for(int i = 1; i <= unique; i++){
			int uni = 0, left = 0, right = 0, noGreaterThanK = 0;
			int[] cur = new int[26];
			while(right < s.length()){
				if(uni <= i){
					int idx = (int)(s.charAt(right)-'a');
					if(cur[idx] == 0){
						uni++;
					}
					cur[idx]++;
					if(cur[idx] == k){
						noGreaterThanK += 1;
					}
					right++;
				}else{
					
					int idx = (int)(s.charAt(left) - 'a');
					cur[idx]--;
					if(cur[idx] == 0){
						uni--;
					} 
					if(cur[idx] == k - 1){
						noGreaterThanK -= 1;
					}
					left++;
					
				}
				if(uni == i && noGreaterThanK == uni){
					res = Math.max(res, right - left);
				}
			}
		}
		return res;
	}
	public static void main(String[] args){
		String s1 = "baaabcb";
		String s2 = "ababacb";
		longest l = new longest();
		System.out.println(l.longestKCharacter(s1, 3));
		System.out.println(l.longestKCharacter(s2, 3));
	}
}
