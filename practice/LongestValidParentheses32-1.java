/*32. Longest Valid Parentheses
Hard

2803

120

Add to List

Share
Given a string containing just the characters '(' and ')', find the length of the longest valid (well-formed) parentheses substring.

Example 1:

Input: "(()"
Output: 2
Explanation: The longest valid parentheses substring is "()"
Example 2:

Input: ")()())"
Output: 4
Explanation: The longest valid parentheses substring is "()()"*/
class Solution {
    public int longestValidParentheses(String s) {
        Stack<Integer> stack = new Stack<Integer>();
        stack.push(-1);
        int maxans = 0;
        for(int i = 0; i < s.length(); i++){
        	if(s.charAt(i) == '('){
        		stack.push(i);
        	}else{
        		stack.pop();
        		if(stack.empty()){
        			stack.push(i);
        		}else{
        			maxans = Math.max(maxans, i - stack.peek());
        		}
        	}
        }
        return maxans;
    }
    public int longestValidParentheses(String s) {
        int left = 0;
        int right = 0;
        int maxans = 0;
        for(int i = 0; i < s.length(); i++){
        	if(s.charAt(i) == '('){
        		left++;
        	}else{
        		right++;
        	}
        	if(left == right){
        		maxans = Math.max(maxans, 2*left);
        	}else if(right > left){
        		left = right = 0;
        	}
        }
        left = right = 0;
        for(int i = s.length() - 1; i >= 0; i--){
        	if(s.charAt(i) == '('){
        		left++;
        	}else{
        		right++;
        	}
        	if(left == right){
        		maxans = Math.max(maxans, 2*left);
        	}else if(left > right){
        		left = right = 0;
        	}
        }
        return maxans;
    }
}
















