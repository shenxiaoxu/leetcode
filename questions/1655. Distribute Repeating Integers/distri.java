class Solution {
    public boolean canDistribute(int[] nums, int[] quantity) {
        HashMap<Integer, Integer> map = new HashMap();
        for(int i : nums){
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        int[] count = new int[map.size()];
        int idx = 0;
        for(int i : map.keySet()){
            count[idx++] = map.get(i);
        }
        Arrays.sort(count);
        quantity = Arrays.stream(quantity).boxed().sorted((a,b)->b.compareTo(a)).mapToInt(i->i).toArray();
        return dfs(count, quantity, 0);
    }
    private boolean dfs(int[] count, int[] quantity, int level){
        if(level == quantity.length){
            return true;
        }
        for(int i = 0; i < count.length; i++){
            if(count[i] >= quantity[level]){
                count[i] -= quantity[level];
                if(dfs(count, quantity, level + 1)){
                    return true;
                }
                count[i] += quantity[level];
            }
        }
        return false;
    }
}
