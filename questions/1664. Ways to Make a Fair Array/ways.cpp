class Solution {
public:
    int waysToMakeFair(vector<int>& nums) {
        int s1 = 0, s2 = 0, s3 = 0, s4 = 0, res = 0;
        for(int i = 0; i < nums.size(); i++){
            if(i % 2 == 0) s3+= nums[i];
            else s4 += nums[i];
        }
        for(int i = 0; i < nums.size(); i++){
            if(i%2 == 0){
                s3 -= nums[i];
            }else{
                s4 -= nums[i];
            }
            if(s3 + s2 == s4 + s1){res += 1;}
            if(i % 2 == 0){
                s1 += nums[i];
            }else{
                s2 += nums[i];
            }
        }
        return res;
    }
};
