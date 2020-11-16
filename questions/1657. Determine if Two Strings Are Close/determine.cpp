class Solution {
public:
    bool closeStrings(string word1, string word2) {
        vector<int> a1(26,0), a2(26,0);
        set<char> s1, s2;
        for(int i = 0; i < word1.size(); i++){
            a1[(int)(word1[i] - 'a')]++;
            s1.insert(word1[i]);
        }
        for(int i = 0; i < word2.size(); i++){
            a2[(int)(word2[i] - 'a')]++;
            s2.insert(word2[i]);
        }
        sort(a1.begin(), a1.end());
        sort(a2.begin(), a2.end());
        return s1==s2 && a1==a2;
    }
};
