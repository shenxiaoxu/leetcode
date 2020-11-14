class Solution {
public:
    int minimumDeletions(string s) {
        int n = s.size(), bcount = 0, res = INT_MAX;
        vector<int> A(n);
        A[n - 1] = (s[n - 1]=='a'?1:0);
        for(int i = n - 2; i >= 0; i--){
            A[i] = A[i + 1] + (s[i]=='a'?1:0);
        }
        for(int i = 0; i < n; i++){
            if(s[i] == 'b'){
                res = min(res, bcount + A[i]);
                bcount++;
            }
        }
        res = min(res, bcount);
        return res == INT_MAX?0:res;
    }
};
