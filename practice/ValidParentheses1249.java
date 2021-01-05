/*1249. Minimum Remove to Make Valid Parentheses
Medium

348

10

Add to List

Share
Given a string s of '(' , ')' and lowercase English characters. 

Your task is to remove the minimum number of parentheses ( '(' or ')', in any positions ) so that the resulting parentheses string is valid and return any valid string.

Formally, a parentheses string is valid if and only if:

It is the empty string, contains only lowercase characters, or
It can be written as AB (A concatenated with B), where A and B are valid strings, or
It can be written as (A), where A is a valid string.
question:
is () is valid
but ((A)) is not valid?
design:
iterate through string, if it's left and right number, if is more than 1 number remove it?
*/
class Solution {
    public String minRemoveToMakeValid(String s) {
        String result;
        Deque<Character> stack = new ArrayDeque<Character>();

        for(int i = 0; i < s.length; i++){
        	Character c = s.charAt(i);
        	if(c == "(" || c == ")"){
        		if(c == "("){
        			stack.push(c);
        		}else{
        			String tmp = "";
        			
        			while(!stack.isEmpty() && stack.peek() != "("){
        				tmp = stack.pop() + tmp;
        			}
        			if(stack.isEmpty()) continue;
        			tmp = stack.pop() + tmp + ")";//add "(" to the front of string.
        			result += tmp;
        		}
        	}else{
        		stack.push(c);
        	}
        }
        return result;
    }


    
}
