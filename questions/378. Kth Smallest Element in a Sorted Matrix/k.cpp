class Solution {
    
public:
    struct compare{
      bool operator()(const vector<int>& lhs, const vector<int>& rhs) const{
          return lhs[0] > rhs[0];
      }  
    };
    int kthSmallest(vector<vector<int>>& matrix, int k) {
        priority_queue<vector<int>, vector<vector<int>>, compare> pq;
        int m = matrix.size(), n = matrix[0].size(), ans = 0;
        for(int i = 0; i < min(m, k); i++){
            pq.push(vector<int>{matrix[i][0], i, 0});
        }
        while(k--){
            vector<int> v = pq.top();
            ans = v[0];
            pq.pop();
            if(v[2] < n - 1){
                pq.push(vector<int>{matrix[v[1]][v[2] + 1], v[1], v[2] + 1});
            }
        }
        return ans;
    }
};
