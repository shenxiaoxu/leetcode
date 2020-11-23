class Solution {
public:
    string getSmallestString(int n, int k) {
        string s(n, 'a');
        k -= n;
        int i = n - 1;
        while(k > 0){
            int tmp = min(k, 25);
            s[i] += tmp;
            k -= tmp;
            i--;
        }
        return s;
    }
};
