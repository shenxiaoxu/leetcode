class Solution {
public:
    int atMostNGivenDigitSet(vector<string>& digits, int n) {
        string digit = to_string(n);
        int nl = digit.size(), res = 0, dl = digits.size();
        for(int i = 1; i < nl; i++){
            res += pow(dl, i);
        }
        for(int i = 0; i < nl; i++){
            bool sameNumber = false;
            for(string& d : digits){
                if(d[0] < digit[i]){
                    res += pow(dl, nl - i - 1);
                }else if(d[0] == digit[i]){
                    sameNumber = true;
                }
            }
            if(!sameNumber) return res;
        }
        return res + 1;
    }
};
