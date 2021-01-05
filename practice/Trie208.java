/*
208.implement trie(prefix tree)
implement a trie with insert, search, and startwith methods
trie trie = new trie();
trie.insert("apple");
trie.search("apple") return true;
trie.search("app") return false;
trie.startsWith("app") return true;
trie.insert("app");
trie.search("app") return true;
class Trie{
	public Trie(){
	
	}
	public void insert(String word){
	
	}
	public boolean search(String word){
	
	}
	public boolean startsWith(String prefix){
	
	}
}
*/
import java.util.*;
class Trie{
	TrieNode root;
	public static void main(String[] args){
		Trie trie = new Trie();
		trie.insert("apple");
		System.out.println(trie.search("apple"));
		System.out.println(trie.search("app"));
		System.out.println(trie.startWith("app"));
		trie.insert("app");
		System.out.println(trie.search("app"));
	}
	public Trie(){
		char empty = '1';
		root= new TrieNode(empty);
	}
	public void insert(String word){
		TrieNode head = root;
		for(int i = 0; i < word.length(); i++){
			char temp = word.charAt(i);
			
			boolean find = false;
			for(int j = 0; j < head.next.size(); j++){
				if(head.next.get(j).value == temp){
					find = true;
					head = head.next.get(j);
					break;
				}	
			}
			if(!find){
				TrieNode node = new TrieNode(temp);
				head.next.add(node);
				head = node;	
				System.out.println("current: " + head.value);
			}	
		}
		char flag = '1';
		TrieNode endNode = new TrieNode(flag);
		head.next.add(endNode);
	}
	public boolean search(String word){
		TrieNode head = root;
		for(int i = 0; i < word.length(); i++){
			char temp = word.charAt(i);
			LinkedList<TrieNode> list = head.next;
			int find = -1;
			for(int j = 0; j < list.size(); j++){
				
				if(list.get(j).value == temp){
					//System.out.println("list value: " + list.get(j).value);
					find = j;
					break;
				}
			}
			if(find == -1){
				return false;
			}else{
				head = list.get(find);
			}

		}
		char flag = '1';
		for(int k = 0; k < head.next.size(); k++){
			if(head.next.get(k).value == flag){
				return true;
			}
		}
		return false;
	}
	public boolean startWith(String word){
		TrieNode head = root;
		for(int i = 0; i < word.length(); i++){
			char temp = word.charAt(i);
			LinkedList<TrieNode> list = head.next;
			int find = -1;
			for(int j = 0; j < list.size(); j++){
				if(list.get(j).value == temp){
					//System.out.println("list value: " + list.get(j).value);
					find = j;
					break;
				}
			}
			if(find == -1){
				return false;
			}else{
				head = list.get(find);
			}
		}
		return true;	
	}
}
class TrieNode{
	char value;
	LinkedList<TrieNode> next;
	TrieNode(char x){
		value = x;
		next = new LinkedList<TrieNode>();
	}
}