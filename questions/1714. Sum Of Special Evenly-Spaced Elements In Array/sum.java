/*
You are given a 0-indexed integer array nums consisting of n non-negative integers.

You are also given an array queries, where queries[i] = [xi, yi]. The answer to the ith query is the sum of all nums[j] where xi <= j < n and (j - xi) is 
divisible by yi.

Return an array answer where answer.length == queries.length and answer[i] is the answer to the ith query modulo 109 + 7.
*/
class Solution {
    public int[] solve(int[] nums, int[][] queries) {
        int mod = (int)1e9+7;
        int n = nums.length;
        int dividepoint = (int)Math.floor(Math.sqrt(n));
        int[] res = new int[queries.length];
        Map<Integer, Map> prefix = new HashMap();
        for(int i = 0; i < queries.length; i++){
            int x = queries[i][0], y = queries[i][1];
            if(y > dividepoint){
                int sm = 0;
                while(x < n){
                    sm += nums[x];
                    sm %= mod;
                    x += y;
                }
                res[i] = sm;
            }else{
                int startpoint = x%y;
                if(!prefix.containsKey(y)){
                    prefix.put(y, new HashMap<Integer, List>());
                }
                if(!prefix.get(y).containsKey(startpoint)){
                    List<Integer> curprefix = new ArrayList();
                    int curstartpoint = startpoint;
                    int sm = 0;
                    curprefix.add(0);
                    while(curstartpoint < n){
                        sm += nums[curstartpoint];
                        sm %= mod;
                        curstartpoint += y;
                        curprefix.add(sm);
                    }
                    prefix.get(y).put(startpoint, curprefix);
                    
                }
                List<Integer> curprefix = (List)prefix.get(y).get(startpoint);
                //System.out.println(curprefix);
                res[i] = (curprefix.get(curprefix.size() - 1) - curprefix.get(x/y) + mod)%mod;
            }
        }
        return res;
    }
}