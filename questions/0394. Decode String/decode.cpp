class Solution {
public:
    string decodeString(string s) {
        stack<int> nums;
        stack<string> strs;
        string cur, prev;
        int num = 0;
        for(char c : s){
            if(c == '['){
                nums.push(num);
                strs.push(cur);
                cur = "";
                num = 0;
            }else if(c == ']'){
                prev = strs.top();
                strs.pop();
                int t = nums.top();
                nums.pop();
                string tmp;
                for(int j = 0; j < t; j++){
                    tmp += cur;
                }
                cur = prev + tmp;
            }else if(isdigit(c)){
                num = num*10 + (c - '0');
            }else{
                cur += c;
            }
        }
        return cur;
    }
};
