/*
140. Word Break II
Given a non-empty string s and a dictionary wordDict containing a list of non-empty words, add spaces in s to construct a sentence where each word is a valid dictionary word. Return all such possible sentences.

Note:

The same word in the dictionary may be reused multiple times in the segmentation.
You may assume the dictionary does not contain duplicate words.
Example 1:

Input:
s = "catsanddog"
wordDict = ["cat", "cats", "and", "sand", "dog"]
Output:
[
  "cats and dog",
  "cat sand dog"
]
Example 2:

Input:
s = "pineapplepenapple"
wordDict = ["apple", "pen", "applepen", "pine", "pineapple"]
Output:
[
  "pine apple pen apple",
  "pineapple pen apple",
  "pine applepen apple"
]
Explanation: Note that you are allowed to reuse a dictionary word.
Example 3:

Input:
s = "catsandog"
wordDict = ["cats", "dog", "sand", "and", "cat"]
Output:
[]
attention:
1.for(int i=0; i<= s.length();i++){ don't forget =, 
because, substring method
2.don't forget termination method
*/
import java.util.*;
class wordBreakII140 {
	public static void main(String[] args){
		List<String> dictionary = new LinkedList<String>();
		dictionary.add("cats");
		dictionary.add("dog");
		dictionary.add("and");
		dictionary.add("cat");
		dictionary.add("sand");
		String input = "catsanddog";
		wordBreakII140 object = new wordBreakII140();
		System.out.println(object.wordBreak(input, dictionary));
	}	
    public List<String> wordBreak(String s, List<String> wordDict) {
     	HashSet<String> hashset = new HashSet<String>();
     	HashMap<String, List<String>> map = new HashMap<String, List<String>>();
     	for(String word: wordDict){
     		hashset.add(word);
     	}
     	List<String> result = wordBreakHelper(s, hashset, map);
     	return result;   
    }
    public List<String> wordBreakHelper(String s, HashSet<String> hashset, HashMap<String, List<String>> map){
    	if(map.containsKey(s)){
    		return map.get(s);
    	}
    	if(s.length() == 0) return null;
    	List<String> result = new LinkedList<String>();
    	for(int i=0; i<= s.length();i++){
    		String sub = s.substring(0,i);
    		List<String> partRes = null;
    		if(hashset.contains(sub)){
	    		partRes = wordBreakHelper(s.substring(i), hashset, map);
	    		if(partRes == null){
	    			result.add(sub);
	    		}else{
	    			for(String part:partRes){
	    				part = sub + " " + part;
	    				result.add(part);
	    			}
	    		}
    		}
    	}
    	map.put(s, result);
    	return result;
    }
}























