/*
127. Word Ladder
Given two words (beginWord and endWord), and a dictionary's word list, find the length of shortest transformation sequence from beginWord to endWord, such that:

Only one letter can be changed at a time.
Each transformed word must exist in the word list. Note that beginWord is not a transformed word.
Note:

Return 0 if there is no such transformation sequence.
All words have the same length.
All words contain only lowercase alphabetic characters.
You may assume no duplicates in the word list.
You may assume beginWord and endWord are non-empty and are not the same.
Example 1:

Input:
beginWord = "hit",
endWord = "cog",
wordList = ["hot","dot","dog","lot","log","cog"]

Output: 5

Explanation: As one shortest transformation is "hit" -> "hot" -> "dot" -> "dog" -> "cog",
return its length 5.
Example 2:

Input:
beginWord = "hit"
endWord = "cog"
wordList = ["hot","dot","dog","lot","log"]

Output: 0

Explanation: The endWord "cog" is not in wordList, therefore no possible transformation.

solution:
bfs, hashset, map, queue.
attention:
1. string compare using compare to in java
2.bfs counting step use up queue then count + 1
3. chararry to string using new String.
4. differ function wants to update the character then change it back or no right result.
5. use build map function.
*/
import java.util.*;
class WordLadder127{
	HashMap<String, List<String>> map = new HashMap<String, List<String>>();
	public void buildMap(String beginWord, List<String> wordList){
		

        for(String word:wordList){
        	List<String> diffWord = new LinkedList<String>();
        	map.put(word, diffWord);
        	for(String nxt: wordList){
        		if(different(word, nxt) == 1){
        			map.get(word).add(nxt);
        		}
        	}    	
        }
        if(!map.containsKey(beginWord)){
        	List<String> diffWord = new LinkedList<String>();
        	map.put(beginWord, diffWord);
       		for(String nxt: wordList){
        		if(different(beginWord, nxt) == 1){
        			map.get(beginWord).add(nxt);
        		}
        	}      
    	}		
	}
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if(beginWord.equals(endWord)) return 0;
        buildMap(beginWord, wordList);
        Queue<String> queue = new LinkedList<String>();
        HashSet<String> doneSet = new HashSet<String>();
        int step = 1;
        
        queue.add(beginWord);
        doneSet.add(beginWord);

        while(queue.size() != 0){
        	int size = queue.size();
        	for(int i = 0; i < size; i++){
	        	String temp = queue.poll();
	        	List<String> list = map.get(temp);

	        	for(String next : list){

	        		if(next.compareTo(endWord) == 0){
	        			return step + 1;
	        		}
	        		if(list.size() != 0 && !doneSet.contains(next)){

	        			queue.offer(next);
	        			doneSet.add(next);
	        		}
	        	}
        	}
        	step++;
        }
        return 0;
    }
    public List<String> differ(String word, List<String> wordList){
    	List<String> result = new LinkedList<String>();
    	char[] array = word.toCharArray();
    	char ori;
    	for(int i = 0; i < array.length; i++){
    		ori = array[i];
    		for(char j = 'a'; j <= 'z'; j++){
    			array[i] = j;
				String temp = new String(array);
    			if(temp.compareTo(word)!=0 && wordList.contains(temp)){
    				result.add(temp);
    			}    			    			
    		}
    		array[i] = ori;
    	}

    	return result;
    }
    public int different(String s, String t){
    	int count = 0;
    	for(int i = 0; i < s.length(); i++){
    		if(s.charAt(i) != t.charAt(i)){
    			count++;
    		}
    	}
    	return count;
    }
	public static void main(String[] args){
		List<String> wordList = new LinkedList<String>();
		wordList.add("hot");
		wordList.add("dot");
		wordList.add("dog");
		wordList.add("lot");
		wordList.add("log");
		wordList.add("cog");
		String beginWord = "hit";
		String endWord = "cog";
		WordLadder127 object = new WordLadder127();
		System.out.println(object.ladderLength(beginWord, endWord, wordList));
	}    
}











