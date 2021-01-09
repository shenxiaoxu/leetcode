/*
Given two words beginWord and endWord, and a dictionary wordList, return the length of the shortest transformation sequence from beginWord to endWord, 
such that:

Only one letter can be changed at a time.
Each transformed word must exist in the word list.
Return 0 if there is no such transformation sequence.
*/
class Solution{
	public int shortesTransformation(String beginWord, String endWord, List<String> wordlist){
		HashSet<String> dictionary = new HashSet();
		int step = 0;
		for(String str: wordlist){
			dictionary.add(str);
		}
		Queue<String> queue = new LinkedList();
		queue.add(beginWord);
		while(!queue.isEmpty()){
			int size = queue.size();
			for(int i = 0; i < size; i++){
				String cur = queue.poll();
				List<String> transferStrings = changeOneLetter(cur, dictionary);
				for(String str: transferStrings){
					if(str.equals(endWord)){
						return step + 1;
					}else{
						queue.add(str);
					}
				}
			}
			step += 1;
		}
		return step;
	}
	private List<String> changeOneLetter(String cur, HashSet<String> dictionary){
		StringBuilder sb = new StringBuilder(cur);
		List<String> res = new ArrayList();
		for(int i = 0; i < cur.length(); i++){
			StringBuilder temp = new StringBuilder(cur);
			for(char c = 'a'; c <= 'z'; c++){
				temp.setCharAt(i, c);
				if(dictionary.contains(temp.toString())){
					res.add(temp.toString());
					dictionary.remove(temp.toString());
				}
			}
		}
		return res;
	}
}