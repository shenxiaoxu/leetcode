/*
You are given a string s and two integers x and y. You can perform two types of operations any number of times.

Remove substring "ab" and gain x points.
For example, when removing "ab" from "cabxbae" it becomes "cxbae".
Remove substring "ba" and gain y points.
For example, when removing "ba" from "cabxbae" it becomes "cabxe".
Return the maximum points you can gain after applying the above operations on s.
*/
class Solution {
    public int maximumGain(String s, int x, int y) {
        char first = (x > y)?'a':'b';
        char second = (x > y)?'b':'a';
        int max = Math.max(x, y);
        int min = Math.min(x, y);
        int res = 0;
        Stack<Character> stack1 = new Stack();
        Stack<Character> stack2 = new Stack();
        for(char c: s.toCharArray()){
            if(!stack1.isEmpty() && stack1.peek() == first && c == second){
                stack1.pop();
                res += max;
            }else{
                stack1.push(c);
            }
        }
        while(!stack1.isEmpty()){
            char c = stack1.pop();
            if(!stack2.isEmpty() && stack2.peek() == first && c == second){
                stack2.pop();
                res += min;
            }else{
                stack2.push(c);
            }
        }
        return res;
    }
}