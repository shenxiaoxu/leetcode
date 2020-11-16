class OrderedStream {
vector<string> arr;
int ptr = 1;  
public:
  
    OrderedStream(int n): arr(n + 1){}
    vector<string> insert(int id, string value) {
        vector<string> res;
        arr[id] = value;
        if(id == ptr){
            while(ptr < arr.size() && !arr[ptr].empty()){
                res.push_back(arr[ptr]);
                ++ptr;
            }
        }
        return res;
    }
};

/**
 * Your OrderedStream object will be instantiated and called as such:
 * OrderedStream* obj = new OrderedStream(n);
 * vector<string> param_1 = obj->insert(id,value);
 */
