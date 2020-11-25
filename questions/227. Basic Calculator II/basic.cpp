class Solution {
public:
    int calculate(string s) {
        int cur_num = 0, res = 0;
        char sign = '+';
        stack<int> st;
        
        for(int i = 0; i < s.size(); i++){
            char c = s[i];
            if(c >= '0' && c <= '9'){
                cur_num = cur_num*10 + (int)(c-'0');
            }
            if(i == s.size() - 1 || (!(c >= '0' && c <= '9') && ' ' != c)){
                if(sign == '+'){
                    st.push(cur_num);
                }else if(sign == '-'){
                    st.push(-cur_num);
                }else if(sign == '*'){
                    int n = st.top();
                    st.pop();
                    st.push(n * cur_num);
                }else if(sign == '/'){
                    int n = st.top();
                    st.pop();
                    st.push(n/cur_num);
                }
                sign = c;
                cur_num = 0;
            }
        }
        while(!st.empty()){
            res += st.top();
            st.pop();
        }
        return res;
    }
};
