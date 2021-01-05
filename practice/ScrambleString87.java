/*
87. Scramble String
Given a string s1, we may represent it as a binary tree by partitioning it to two non-empty substrings recursively.

Below is one possible representation of s1 = "great":

    great
   /    \
  gr    eat
 / \    /  \
g   r  e   at
           / \
          a   t
To scramble the string, we may choose any non-leaf node and swap its two children.

For example, if we choose the node "gr" and swap its two children, it produces a scrambled string "rgeat".

    rgeat
   /    \
  rg    eat
 / \    /  \
r   g  e   at
           / \
          a   t
We say that "rgeat" is a scrambled string of "great".

Similarly, if we continue to swap the children of nodes "eat" and "at", it produces a scrambled string "rgtae".

    rgtae
   /    \
  rg    tae
 / \    /  \
r   g  ta  e
       / \
      t   a
We say that "rgtae" is a scrambled string of "great".

Given two strings s1 and s2 of the same length, determine if s2 is a scrambled string of s1.

Example 1:

Input: s1 = "great", s2 = "rgeat"
Output: true
Example 2:

Input: s1 = "abcde", s2 = "caebd"
Output: false
*/
class Solution {
    public boolean isScramble(String s1, String s2) {
        if(s1 == null || s2 == null || s1.length() != s2.length()) return false;
        if(s1.length() != s2.length()) return false;
        if(s1.length() == 1 && s2.length() == 1 && s1.charAt(0) == s2.charAt(0)) return true;
        char[] s1Array = s1.toCharArray();
        char[] s2Array = s2.toCharArray();
        Arrays.sort(s1Array);
        Arrays.sort(s2Array);
        String s1New = new String(s1Array);
        String s2New = new String(s2Array);
        if(s1New.compareTo(s2New) != 0){
        	return false;
        }

        for(int length = 1; i < s1.length(); length++){
        	String s1Left = s1.substring(0, length);
        	String s1Right = s1.substring(length, s1.length());
        	if((isScramble(s1Left, s2.substring(0,length)) && isScramble(s1Right, s2.substring(length, s2.length())))||
        		(isScramble(s1Left, s2.substring(s2.length() - length, s2.length())) && isScramble(s1Right, s2.substring(0, s2.length() - length)))){
        		return true;
        	}
        }

        return false;
    }
}
































