class OrderedStream {
    String[] arr;
    int ptr;
    public OrderedStream(int n) {
        arr = new String[n];
        ptr = 0;
    }
    
    public List<String> insert(int id, String value) {
        List<String> res = new ArrayList();
        arr[id - 1] = value;
        if(ptr == id - 1){
            while(ptr < arr.length && arr[ptr] != null){
                res.add(arr[ptr++]);
            }
        }
        return res;
    }
}

/**
 * Your OrderedStream object will be instantiated and called as such:
 * OrderedStream obj = new OrderedStream(n);
 * List<String> param_1 = obj.insert(id,value);
 */
