/*
76. Minimum Window Substring

Given a string S and a string T, find the minimum window in S which will contain all the characters in T in complexity O(n).

Example:

Input: S = "ADOBECODEBANC", T = "ABC"
Output: "BANC"
Note:

If there is no such window in S that covers all characters in T, return the empty string "".
If there is such window, you are guaranteed that there will always be only one unique minimum window in S.
*/
import java.util.*;
class Solution {
    public String minWindow(String s, String t) {
    	if(s.length() == 0 || t.length() == 0) return "";
        Map<Character, Integer> dicT = new HashMap<Character, Integer>();
        Map<Character, Integer> windowCount = new HashMap<Character, Integer>();
        List<Pair<Integer, Character>> filteredS = new ArrayList<Pair<Integer, Character>>();

        for(int i = 0; i < t.length(); i++){
        	char tChar = t.charAt(i);
        	int number = dicT.getOrDefault(tChar, 0);
        	dicT.put(tChar, number + 1);
        }
        int required = dicT.size();

        for(int i = 0; i < s.length(); i++){
        	char sChar = s.charAt(i);
        	if(dicT.containsKey(sChar)){
        		filteredS.add(new Pair<Integer, Character>(i, sChar));
        	}
        }

        int l = 0;
        int r = 0;

        int[] answer = {-1,0,0};
        int formed = 0;

        while(r < filteredS.size()){
        	char indexChar = filteredS.get(r).getValue();
        	int count = windowCount.getOrDefault(indexChar, 0);
        	windowCount.put(indexChar, count + 1);

        	if(dicT.containsKey(indexChar) && dicT.get(indexChar).intValue() == windowCount.get(indexChar).intValue()){
        		formed++;
        	}
        	
        	while(l <= r && formed == required){
        		char c = filteredS.get(l).getValue();
        		
        		int start = filteredS.get(l).getKey();;
        		int end = filteredS.get(r).getKey();
        		int length = end - start + 1;
        		if(answer[0] == -1 || length < answer[0]){
        			answer[0] = length;
        			answer[1] = start;
        			answer[2] = end;
        		}

  
        		int leftCount = windowCount.get(c);
        		windowCount.put(c, leftCount - 1);
        		if(dicT.containsKey(c) && windowCount.get(c).intValue() < dicT.get(c).intValue()){
        			formed--;
        		}
        		l++;        			        		
        	}
        	r++;
        }
        return answer[0] == -1? "" : s.substring(answer[1], answer[2] + 1);
    }
}











