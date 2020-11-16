class Solution {
    public List<List<Integer>> removeInterval(int[][] intervals, int[] toBeRemoved) {
        List<List<Integer>> res = new ArrayList();
        int s = toBeRemoved[0], e = toBeRemoved[1];
        for(int[] in: intervals){
            if(s >= in[1] || e <= in[0]) res.add(Arrays.asList(in[0], in[1]));
            else{
                if(s > in[0]){
                    res.add(Arrays.asList(in[0], s));
                }
                if(e < in[1]){
                    res.add(Arrays.asList(e, in[1]));
                }
            }
        }
        return res;
    }
}
