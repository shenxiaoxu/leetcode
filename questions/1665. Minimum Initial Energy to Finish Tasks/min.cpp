class Solution {
public:
    int minimumEffort(vector<vector<int>>& tasks) {
        sort(tasks.begin(), tasks.end(), [this](vector<int>&a, vector<int>&b){return (a[0]-a[1])<(b[0]-b[1]);});
        int cur=0, ans = 0;
        for(vector<int>& task: tasks){
            if(task[1] > cur){
                ans += task[1] - cur;
                cur = task[1];
            }
            cur -= task[0];
        }
        return ans;
    }
};
