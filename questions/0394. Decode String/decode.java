class Solution {
    public String decodeString(String s) {
        Stack<String> strS = new Stack();
        Stack<Integer> numS = new Stack();
        int curNum = 0;
        String curStr = "", prevString = "";
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(c == '['){
                strS.add(curStr);
                numS.add(curNum);
                curStr = "";
                curNum = 0;
            }else if(Character.isDigit(c)){
                curNum = curNum*10 + (int)(c-'0');
            }else if(c == ']'){
                int num = numS.pop();
                prevString = strS.pop();
                String temp = "";
                for(int j = 0; j < num; j++){
                    temp += curStr;
                }
                curStr = prevString + temp;
            }else{
                curStr += c;
            }
        }
        return curStr;
    }
}
