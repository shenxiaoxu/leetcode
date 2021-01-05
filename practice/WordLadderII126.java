/*126. Word Ladder II

Given two words (beginWord and endWord), and a dictionary's word list, find all shortest transformation sequence(s) from beginWord to endWord, such that:

Only one letter can be changed at a time
Each transformed word must exist in the word list. Note that beginWord is not a transformed word.
Note:

Return an empty list if there is no such transformation sequence.
All words have the same length.
All words contain only lowercase alphabetic characters.
You may assume no duplicates in the word list.
You may assume beginWord and endWord are non-empty and are not the same.
Example 1:

Input:
beginWord = "hit",
endWord = "cog",
wordList = ["hot","dot","dog","lot","log","cog"]

Output:
[
  ["hit","hot","dot","dog","cog"],
  ["hit","hot","lot","log","cog"]
]
Example 2:

Input:
beginWord = "hit"
endWord = "cog"
wordList = ["hot","dot","dog","lot","log"]

Output: []

Explanation: The endWord "cog" is not in wordList, therefore no possible transformation.
solution:
1.bfs find steps
record node steps to the end, 
2.dfs find solution
backtrack(if step bigger than step, cut it)
(if node step bigger than node step to the end, cut it)
attention:
1. mind step
2. mind backtracking 
*/
import java.util.*;
class WordLadderII126 {
 	HashMap<String, List<String>> map = new HashMap<String, List<String>>();
 	HashSet<String> doneSet = new HashSet<String>();
 	HashMap<String, Integer> deepMap = new HashMap<String, Integer>();
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
		WordLadderII126 object = new WordLadderII126();
		System.out.println(object.findLadders(beginWord, endWord, wordList));
	} 
	public void buildMap(String beginWord, List<String> wordList){
		HashSet<String> wordset = new HashSet<String>();
		wordset.add(beginWord);
        for(String word:wordList){
        	wordset.add(word); 	
        }
        for(String str: wordset){
        	map.put(str, new LinkedList<String>());
        	differ(str, wordset);
        }	
	}
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        List<List<String>> results = new LinkedList<List<String>>();
        LinkedList<String> curList = new LinkedList<String>(); 
        int steps = findSteps(beginWord, endWord, wordList);
        
        System.out.println("steps:" + steps);
        
        doneSet.clear();
        
        curList.add(endWord);
        doneSet.add(endWord);
        
        DFS(results, beginWord, curList, steps, 1);
        return results;

    }
    public void DFS(List<List<String>> results, String beginWord, LinkedList<String> wordList, int minLength, int deepLength){
    	String curString = wordList.get(0);
    	System.out.println("curString:" + curString + "deepLength:" + deepLength + "wordList:" + wordList.size());
    	if(wordList.size() > minLength){
    		return;
    	}else if(wordList.size() == minLength){
    		if(curString.compareTo(beginWord) == 0){
    			results.add(new LinkedList<String>(wordList));
    		}
    	}else{
    		List<String> nexListStr = map.get(curString);
    		for(String nextStr : nexListStr){
    			if(!doneSet.contains(nextStr) && deepMap.containsKey(nextStr) && (deepMap.get(nextStr) + deepLength) < minLength ){
    				wordList.addFirst(nextStr);
    				doneSet.add(nextStr);
    				DFS(results, beginWord, wordList, minLength, deepLength + 1);
    				wordList.removeFirst();
    				doneSet.remove(nextStr);
				}
    		}
    	}
    }
   	public int findSteps(String beginWord, String endWord, List<String> wordList) {
        if(beginWord.equals(endWord)) return 0;
        buildMap(beginWord, wordList);
        Queue<String> queue = new LinkedList<String>();
        int step = 1;
        
        queue.add(beginWord);
        deepMap.put(beginWord, 0);
        while(queue.size() != 0){
        	int size = queue.size();
        	for(int i = 0; i < size; i++){
	        	String temp = queue.poll();
	        	if(map.containsKey(temp)){
		        	List<String> list = map.get(temp);
		        	for(String next : list){
		        		if(next.compareTo(endWord) == 0){
		        			return step + 1;
		        		}
		        		if(list.size() != 0 && !deepMap.containsKey(next)){
		        			queue.offer(next);
		        			deepMap.put(next, step);
		        		}
		        	}
	        	}	
        	}
        	step++;
        }
        return 0;
    }    
    public void differ(String word, HashSet<String> wordList){
    	for(int i = 0; i < word.length(); i++){
    		StringBuilder s = new StringBuilder(word);
    		for(char j = 'a'; j <= 'z'; j++){
    			if(s.charAt(i) != j){
	    			s.setCharAt(i,j);
	    			if(wordList.contains(s.toString())){
	    				map.get(word).add(s.toString());
	    			}
    			}    			    			
    		}
    	}

    }
       
}









