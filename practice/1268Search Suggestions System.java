/*1268. Search Suggestions System
Medium

248

67

Add to List

Share
Given an array of strings products and a string searchWord. We want to design a system that suggests at most three product names from products after each character of searchWord is typed. Suggested products should have common prefix with the searchWord. If there are more than three products with a common prefix return the three lexicographically minimums products.

Return list of lists of the suggested products after each character of searchWord is typed. 

 

Example 1:

Input: products = ["mobile","mouse","moneypot","monitor","mousepad"], searchWord = "mouse"
Output: [
["mobile","moneypot","monitor"],
["mobile","moneypot","monitor"],
["mouse","mousepad"],
["mouse","mousepad"],
["mouse","mousepad"]
]
Explanation: products sorted lexicographically = ["mobile","moneypot","monitor","mouse","mousepad"]
After typing m and mo all products match and we show user ["mobile","moneypot","monitor"]
After typing mou, mous and mouse the system suggests ["mouse","mousepad"]
Example 2:

Input: products = ["havana"], searchWord = "havana"
Output: [["havana"],["havana"],["havana"],["havana"],["havana"],["havana"]]
Example 3:

Input: products = ["bags","baggage","banner","box","cloths"], searchWord = "bags"
Output: [["baggage","bags","banner"],["baggage","bags","banner"],["baggage","bags"],["bags"]]
Example 4:

Input: products = ["havana"], searchWord = "tatiana"
Output: [[],[],[],[],[],[],[]]
 

Constraints:

1 <= products.length <= 1000
There are no repeated elements in products.
1 <= Σ products[i].length <= 2 * 10^4
All characters of products[i] are lower-case English letters.
1 <= searchWord.length <= 1000
All characters of searchWord are lower-case English letters.*/
class Solution {//time complexity build trie using l*m, l is string array length, m is longest word length, search word sort is logm, m is how many words in current
	//trie node, 
	class TrieNode{
		char cur;
		Map<Character, TrieNode> map;
		List<String> wordsR;
		public TrieNode(char c){
			cur = c;
			map = new HashMap();
			wordsR = new ArrayList();
		}
	}
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        TrieNode root = new TrieNode('0');
        //create trie
        for(String str: products){
        	char[] array = str.toCharArray();
        	TrieNode node = root;
        	for(int i = 0; i < array.length; i++){
        		char cur = array[i];
        		if(!node.map.containsKey(cur)){
        			node.map.put(cur, new TrieNode(cur));
        		}
        		node = node.map.get(cur);
        		node.wordsR.add(str);
        	}
        }
        //get search word
        List<List<String>> result = new ArrayList();
        TrieNode node = root;
        for(char c:searchWord.toCharArray()){
        	if(node.map.containsKey(c)){
        		List<String> temp = getThreeWord(node.map.get(c).wordsR);
        		result.add(temp);
        	}else{
                for(int i = searchWord.length() - result.size() - 1; i>=0; i--){
                    result.add(new ArrayList<String>());
                }
        		break;
        	}
        	node = node.map.get(c);
        }
        return result;
    }
    private List<String> getThreeWord(List<String> input){
    	List<String> result = new ArrayList();
    	PriorityQueue<String> queue = new PriorityQueue<String>(new Comparator<String>(){
    		public int compare(String s1, String s2){
    			return s1.compareTo(s2);
    		}
    	});
    	for(String s:input){queue.offer(s);}
    	while(!queue.isEmpty()){
    		if(result.size() < 3){
    			result.add(queue.poll());
    		}else{
    			break;
    		}
    	}
    	return result;
    }
}















