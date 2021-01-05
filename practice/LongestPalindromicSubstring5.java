/*
Given a string s, find the longest palindromic substring in s. You may assume that the maximum length of s is 1000.

Example 1:

Input: "babad"
Output: "bab"
Note: "aba" is also a valid answer.
Example 2:

Input: "cbbd"
Output: "bb"
*/
import java.util.LinkedList;
public class LongestPalindromicSubstring5
{

    public static void main(String[] args)
    {
        String stringTest = new String("babad");
        String stringTestTwo = new String("cbbd");
        String stringTestThree = new String("a");
        LongestPalindromicSubstring5 object = new LongestPalindromicSubstring5();
        System.out.println(object.findLongestPalindromicSubstringSolution2(stringTest));
        System.out.println(object.findLongestPalindromicSubstringSolution2(stringTestTwo));
        System.out.println(object.findLongestPalindromicSubstringSolution2(stringTestThree));
    }
    public static String findLongestPalindromicSubstring(String input)
    {
        String longestStrinFirst = "";
        String longestStrinSecond = "";      
        for(int i =0;i < input.length();i++){
            int nextIndex = i + 1;
            int beforeIndex = i - 1;
            while(nextIndex < input.length() && beforeIndex >= 0 && input.charAt(beforeIndex) == input.charAt(nextIndex)){
                    String temp = input.substring(beforeIndex, nextIndex + 1);
                    if(temp.length() > longestStrinFirst.length()){
                        longestStrinFirst = temp;
                    }
                    longestStrinFirst = input.substring(beforeIndex, nextIndex + 1);
                    System.out.println(beforeIndex + "+1 " + nextIndex);
                    System.out.println(longestStrinFirst);
                    nextIndex++;
                    beforeIndex--;
            }
            nextIndex = i + 1;
            beforeIndex = i;
            while(nextIndex < input.length() && beforeIndex >= 0 && input.charAt(beforeIndex) == input.charAt(nextIndex)){
                    String temp = input.substring(beforeIndex, nextIndex + 1);
                    if(temp.length() > longestStrinSecond.length()){
                        longestStrinSecond = temp;
                    }
                    System.out.println(beforeIndex + "+2 " + nextIndex);
                    System.out.println(longestStrinSecond);                    
                    nextIndex++;
                    beforeIndex--;                    
            }            
        }
        if(longestStrinFirst.length() > longestStrinSecond.length()){
            return longestStrinFirst;
        }else{
            return longestStrinSecond;
        }
    }
    public String findLongestPalindromicSubstringSolution2(String s){
        if(s.length() == 0) return "";
        int len = s.length();
        boolean[][] dp = new boolean[len][len];
        int start = 0;
        int length = 0;
        for(int i = 0; i < len; i++){
            dp[i][i] = true;
        }
        char[] charArray = s.toCharArray();
        for(int j = 0; j < len - 1; j++){
            if(charArray[j] == charArray[j + 1]){
                dp[j][j + 1] = true;
                start = j;
                length = 1;
            }else{
                dp[j][j + 1]= false;
            }
        }
        for(int i = 2; i < len; i++){
            for(int j = 0; i + j < len; j++){
                if(charArray[j] == charArray[i + j] && dp[j + 1][i + j - 1]){
                    dp[j][i + j]= true;
                    start = j;
                    length = i;
                    System.out.println("start:" + start + "length:" + length);
                }else{
                    dp[j][i + j]= false;
                }
            }
        }
        return s.substring(start, start + length + 1);
    }
}













