/*
49.group anagrams
given an array of strings, group anagrams together.
in["eat","tea","tan","ate","nat","bat"]
out
[
	["ate","eat","tea"],
	["nat","tan"],
	["bat"]
]
*/
import java.util.*;
class GroupAnagrams{
	public static void main(String[] args){
		LinkedList<String> input = new LinkedList<String>();
		input.add("eat");
		input.add("tea");
		input.add("tan");
		input.add("ate");
		input.add("nat");
		input.add("bat");
		System.out.println(groupAnagrams(input));
	}
	public static LinkedList<LinkedList<String>> groupAnagrams(LinkedList<String> input){
		LinkedList<LinkedList<String>> results = new  LinkedList<LinkedList<String>>();
		Hashtable<String, LinkedList<String>> table = new Hashtable<String, LinkedList<String>>();
		for(int i = 0; i < input.size(); i++){
			String temp = input.get(i);
			char[] tempArray = temp.toCharArray();
			Arrays.sort(tempArray);
			String sortedtemp = new String(tempArray);
			if(table.containsKey(sortedtemp)){
				table.get(sortedtemp).addFirst(temp);
			}else{
				table.put(sortedtemp,new LinkedList<String>());
				table.get(sortedtemp).addFirst(temp);
			}
		}
		Set<String> keys = table.keySet();
		for(Iterator it = keys.iterator();it.hasNext() ;){
			String s = (String)it.next();
			LinkedList<String> a = table.get(s);
			results.add(a);
		}

		return results;

	}
}