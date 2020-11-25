class Solution {
    public int calculate(String s) {
        Stack<Integer> stack = new Stack();
        int num = 0;
        char sign = '+';
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(Character.isDigit(c)){
                num = num * 10 + (int)(c - '0');
            }
            if(i == s.length() - 1 || (!Character.isDigit(c) && c != ' ')){
                if(sign == '+'){
                    stack.push(num);
                }else if(sign == '-'){
                    stack.push(-num);
                }else if(sign == '*'){
                    stack.push(num*stack.pop());
                }else if(sign == '/'){
                    stack.push(stack.pop()/num);
                }
                sign = c;
                num = 0;
            }
        }
        for(int i : stack){
            num += i;
        }
        return num;
    }
}
