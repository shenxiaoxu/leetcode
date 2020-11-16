class Solution {
public:
    vector<vector<int>> removeInterval(vector<vector<int>>& intervals, vector<int>& toBeRemoved) {
        vector<vector<int>> res;
        int s = toBeRemoved[0], e = toBeRemoved[1];
        for(auto& inter: intervals){
            if(inter[0] >= e || inter[1] <= s) res.push_back(inter);
            else{
                if(s > inter[0]){
                    res.push_back({inter[0], s});
                }
                if(e < inter[1]){
                    res.push_back({e, inter[1]});
                }
            }
        }
        return res;
    }
};
