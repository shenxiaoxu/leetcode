/*
139. Word Break

Given a non-empty string s and a dictionary wordDict containing a list of non-empty words, determine if s can be segmented into a space-separated sequence of one or more dictionary words.

Note:

The same word in the dictionary may be reused multiple times in the segmentation.
You may assume the dictionary does not contain duplicate words.
Example 1:

Input: s = "leetcode", wordDict = ["leet", "code"]
Output: true
Explanation: Return true because "leetcode" can be segmented as "leet code".
Example 2:

Input: s = "applepenapple", wordDict = ["apple", "pen"]
Output: true
Explanation: Return true because "applepenapple" can be segmented as "apple pen apple".
             Note that you are allowed to reuse a dictionary word.
Example 3:

Input: s = "catsandog", wordDict = ["cats", "dog", "sand", "and", "cat"]
Output: false*/
import java.util.*;
class wordBreak139{
	public static void main(String[] args){
		LinkedList<String> dictionary = new LinkedList<String>();
		dictionary.add("cats");
		dictionary.add("dog");
		dictionary.add("and");
		String input = "catsandog";
		wordBreak139 object = new wordBreak139();
		System.out.println(object.wordBreakSolution2(input, dictionary));
	}
	public static boolean wordBreak(String input, LinkedList<String> dictionary, int index, String temp){
		
		if(index == input.length()){
			return true;
		}
		boolean result = false;
		for(int i = index + 1; i <= input.length(); i++){
			String check = input.substring(index, i);
			if(dictionary.indexOf(check) != -1){
				result = wordBreak(input, dictionary, i, check);
				if(result){
					return true;
				}
			}
		}
		return result;
	}
	public boolean wordBreakSolution2(String s, List<String> wordDict) {
        HashSet<String> set = new HashSet<String>();
        for(String str: wordDict){
        	set.add(str);
        }

        boolean[] breakable = new boolean[s.length() + 1];
        breakable[0] = true;
        //breakable[i] = breakable[i - j] is true and words(i-j, i) is in dictionary, j from 0-i 
        for(int i = 0; i <= s.length(); i++){
        	for(int j = i; j > 0; j--){
        		String sub = s.substring(i - j, i);
        		if(set.contains(sub)){
        			if(breakable[i - j] == true){
        				breakable[i] = true;
        				break;
        			}
        		}
        	}
        }
        return breakable[s.length()];

    }
}







































