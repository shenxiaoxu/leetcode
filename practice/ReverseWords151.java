/*
151. reverse words in a string
in:"the sky is blue"
out:"blue is sky the"
input may contain leading or trailing spaces, should not contain leading or trailing spaces.
you need to reduce multiple spaces between two words to a single space in the reversed string.
*/
import java.util.*;
class ReverseWords{
	public static void main(String[] args){
		String input = "the sky is blue";
		System.out.println(reverseWords(input));
	}
	public static String reverseWords(String input){
		LinkedList<String> list = new LinkedList<String>();
		for(int i = 0; i < input.length(); i++){
			while(i < input.length() && input.charAt(i) == ' '){
				i++;
			}
			
			int start = i;
			while(i < input.length() && input.charAt(i) >= 'a' && input.charAt(i) <= 'z'){
				i++;
			}
			String temp = input.substring(start, i);
			//System.out.println("temp: " + temp);
			list.add(temp);
		}
		String result = "";
		while(list.size() != 0){
			result += list.pollLast() + " ";
		}
		return result;
	}
}