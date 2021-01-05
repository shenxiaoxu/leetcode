/*
32.longest valid parentheses
given a string containing just '(' and ')', find length of longest valid parentheses substring.
in:"(()"
out:2
in")()())"
out:4
*/
import java.util.*;
class LongestValidParentheses{
	public static void main(String[] args){
		String test1 = "(()";
		String test2 = ")()())";
		System.out.println(LongestParentheses(test1));
		System.out.println(LongestParentheses(test2));
	}
	public static int LongestParentheses(String input){
		Stack<Integer> stack = new Stack<Integer>();
		int start = 0;
		int res = 0;
		for(int i = 0; i < input.length(); i++){
			if(input.charAt(i) == '('){
				stack.push(i);
			}else{
				if(stack.empty()){
					start = i+1;
				}else{
					stack.pop();
					res = stack.empty()?Math.max(i-start+1,res):Math.max(res,i-stack.peek());
				}
			}
		}
		return res;
	}
}