class Solution {
public:
    int lengthOfLongestSubstringTwoDistinct(string s) {
        int l = s.size(), left = 0, right = 0, res = 0;
        unordered_map<char, int> m;
        while(right < l){
            m[s[right]]++;
            if(m.size() > 2){
                while(m.size() > 2){
                    m[s[left]]--;
                    if(!m[s[left]]){
                        m.erase(s[left]);
                    }
                    left++;
                }    
            }
            res = max(res, right - left + 1);
            right++;
        }
        return res;
    }
};
