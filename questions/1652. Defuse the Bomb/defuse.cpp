class Solution {
public:
    vector<int> decrypt(vector<int>& code, int k) {
        int n = code.size();
        vector<int> res(n);
        if(k == 0) return res;
        for(int i = 0; i < n; i++){
            if(k > 0){
                for(int s = i + 1; s < i + k + 1; s++){
                    res[i]+=code[s % n];
                }
            }else{
                for(int s = i - 1; s > i + k - 1; s--){
                    res[i] += code[(s + n)%n];
                }
            }
        }
        return res;
    }
};
