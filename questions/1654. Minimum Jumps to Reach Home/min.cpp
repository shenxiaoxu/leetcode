class Solution {
public:
    int minimumJumps(vector<int>& forbidden, int a, int b, int x) {
        int max_v = max(*max_element(forbidden.begin(), forbidden.end()), x) + a + b;
        vector<int> arr(max_v + 1, INT_MAX);
        arr[0] = 0;
        for(int pos: forbidden){
            arr[pos] = -1;
        }
        queue<int> q;
        q.push(0);
        while(!q.empty()){
            int cur = q.front();
            q.pop();
            if(cur + a <= max_v && arr[cur + a] > arr[cur] + 1){
                arr[cur + a] = arr[cur] + 1;
                q.push(cur + a);
            }
            if(cur - b > 0 && arr[cur - b] > arr[cur] + 1){
                arr[cur - b] = arr[cur] + 1;
                if(cur - b + a <= max_v && arr[cur - b + a] > arr[cur] + 2){
                    arr[cur - b + a] = arr[cur] + 2;
                    q.push(cur - b + a);
                }
            }
        }
        return arr[x] == INT_MAX?-1:arr[x];
    }
};
