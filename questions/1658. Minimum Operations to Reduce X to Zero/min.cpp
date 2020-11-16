class Solution {
public:
    int minOperations(vector<int>& nums, int x) {
        int res = INT_MIN, target = -x, sum = 0;
        for(int i : nums){
            target += i;
        }
        if(target == 0) return nums.size();
        unordered_map<int, int> m;
        m[0] = -1;
        for(int i = 0; i < nums.size(); i++){
            sum += nums[i];
            if(m.count(sum - target)){
                res = max(res, i - m[sum - target]);
            }
            m[sum] = i;
        }
        return res == INT_MIN?-1:nums.size() - res;
    }
};
