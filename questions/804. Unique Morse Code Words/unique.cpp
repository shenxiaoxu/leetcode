class Solution {
public:
    int uniqueMorseRepresentations(vector<string>& words) {
        vector<string> map = {".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."
};
        unordered_map<string, int> d;
        for(string& word: words){
            string t = "";
            for(char c: word){
                t += map[c-'a'];
            }
            d[t]++;
        }
        return d.size();
    }
};
