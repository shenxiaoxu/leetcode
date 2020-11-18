class Solution {
    public int[][] merge(int[][] intervals) {
        if(intervals.length <= 1) return intervals;
        Arrays.sort(intervals, (a,b)->Integer.compare(a[0],b[0]));
        List<int[]> res = new ArrayList();
        int[] newInterval = intervals[0];
        res.add(newInterval);
        for(int[] ele: intervals){
            if(ele[0] <= newInterval[1]){
                newInterval[1] = Math.max(newInterval[1], ele[1]);
            }else{
                newInterval = ele;
                res.add(newInterval);
            }
        }
        
        return res.toArray(new int[res.size()][]);
    }
}
