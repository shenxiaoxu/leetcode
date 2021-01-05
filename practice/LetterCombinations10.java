/*
17. Letter Combinations of a Phone Number
Medium

Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number could represent.

A mapping of digit to letters (just like on the telephone buttons) is given below. Note that 1 does not map to any letters.



Example:

Input: "23"
Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
Note:

Although the above answer is in lexicographical order, your answer could be in any order you want.
*/
import java.util.*;
class LetterCombinations{
	public static ArrayList<String> letterCombination(int number){
		Hashtable<Integer, String> store = new Hashtable<Integer, String>();
		store.put(2,"abc");
		store.put(3,"def");
		store.put(4,"ghi");
		store.put(5,"jkl");
		store.put(6,"mno");
		store.put(7,"pqrs");
		store.put(8,"tuv");
		store.put(9,"wxyz");
		ArrayList<String> input = new ArrayList<String>();
		while(number > 0){
			input.add(store.get(number % 10));
			number = number/10;
		}
		ArrayList<String> result = new ArrayList<String>();
		recurringCombination(input, "", result, 0);
		return result;

	}
	public static void recurringCombination(ArrayList<String> input, String sub, ArrayList<String> result, int index){
		
		if(index >= input.size() && sub.length() == input.size()){
			result.add(sub);
			return;
		}
		
		String temp = input.get(index);
		for(int j = 0; j < temp.length(); j++){
			recurringCombination(input, sub + temp.charAt(j), result, index + 1);
		}
		
		return;
	}
	public static void main(String[] args){
		int test1 = 23;
		System.out.println(letterCombination(test1));
	}
}