/*
131. palindrome partitioning
given a string s, partition s such that every substring of the partition is a palindrome.
return all possible palindrome partitioning of s.
in:aab
out:
[
[aa,b]
[a,a,b]
]
*/
import java.util.*;
class PartitionII{
	public static void main(String[] args){
		String s = "aab";
		LinkedList<LinkedList<String>> results = new LinkedList<LinkedList<String>>();
		partition(s, new LinkedList<String>(), "", 0, results);
		System.out.println(results);
	}
	public static void partition(String s, LinkedList<String> result, String temp, int index, LinkedList<LinkedList<String>>results){
		if(index > s.length()){
			return;
		}
		if(index == s.length()){
			System.out.println(result);			
			results.add(new LinkedList<String>(result));
			return;			
		}
		for(int i = index + 1; i <= s.length(); i++){
			temp = s.substring(index, i);
			if(isPalindrome(temp)){
				result.add(temp);
				partition(s, result, temp, i, results);
				result.pollLast();
			}
		}
	}
	public static boolean isPalindrome(String s){
		if(s.length() == 1){
			return true;
		}
		int start = 0;
		for(int i = s.length() - 1; i >=start; i--){
			if(s.charAt(i) != s.charAt(start)){
				return false;
			}
			start++;
		}
		return true;
	}
}