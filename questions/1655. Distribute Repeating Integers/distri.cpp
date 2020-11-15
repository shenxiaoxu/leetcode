class Solution {
public:
    bool canDistribute(vector<int>& nums, vector<int>& quantity) {
        unordered_map<int, int> m;
        for(int i: nums){
            m[i] += 1;
        }
        vector<int> count;
        for(auto i = m.begin(); i != m.end(); ++i){
            count.push_back(i->second);
        }
        sort(count.begin(), count.end());
        sort(quantity.begin(), quantity.end());
        reverse(quantity.begin(), quantity.end());
        return dfs(count, quantity, 0);
    }
    bool dfs(vector<int>& count, vector<int>& quantity, int level){
        if(level == quantity.size()){
            return true;
        }
        for(auto it = count.begin(); it != count.end(); ++it){
            if(*it >= quantity[level]){
                *it -= quantity[level];
                if(dfs(count, quantity, level + 1)){
                    return true;
                }
                *it += quantity[level];
            }
        }
        return false;
    }
};
