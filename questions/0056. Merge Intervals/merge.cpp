class Solution {
public:
    vector<vector<int>> merge(vector<vector<int>>& intervals) {
        sort(intervals.begin(), intervals.end(), [](vector<int>& a, vector<int>& b){return a[0]< b[0];});
        vector<vector<int>> res;
        res.push_back(intervals[0]);
        for(vector<int>& ele: intervals){
            if(ele[0] <= res.back()[1]){
                res.back()[1] = max(res.back()[1], ele[1]);
            }else{
                res.push_back(ele);
            }
        }
        return res;
    }
};
