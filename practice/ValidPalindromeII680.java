/*680. Valid Palindrome II
Easy

1216

89

Add to List

Share
Given a non-empty string s, you may delete at most one character. Judge whether you can make it a palindrome.

Example 1:
Input: "aba"
Output: True
Example 2:
Input: "abca"
Output: True
Explanation: You could delete the character 'c'.*/
class Solution {
    public boolean validPalindrome(String s) {  	
        List<Integer> result = check(s);
        if(result.size() == 0) return true;
        StringBuilder sb = new StringBuilder(s);
        StringBuilder sb1 = new StringBuilder(s);
        sb.delete(result.get(0));
        sb1.delete(result.get(1));
        if(check(sb.toString()).size() == 0) return true;
        if(check(sb1.toString()).size() == 0) return true;
        return false;
    }
    private List<Integer> check(String s){
    	List<Integer> result = new ArrayList();
    	int start = 0;
    	int end = s.length - 1;
    	while(start < end){
    		if(s.charAt(start) == s.charAt(end)){
    			start++;
    			end--;
    		}else{break;}
    	}
    	if(start < end){
    		result.add(start);
    		result.add(end);
    	}
    	return result;
    }
}

class Solution {
    public boolean isPalindromeRange(String s, int i, int j) {
        for (int k = i; k <= i + (j - i) / 2; k++) {
            if (s.charAt(k) != s.charAt(j - k + i)) return false;
        }
        return true;
    }
    public boolean validPalindrome(String s) {
        for (int i = 0; i < s.length() / 2; i++) {
            if (s.charAt(i) != s.charAt(s.length() - 1 - i)) {
                int j = s.length() - 1 - i;
                return (isPalindromeRange(s, i+1, j) ||
                        isPalindromeRange(s, i, j-1));
            }
        }
        return true;
    }
}