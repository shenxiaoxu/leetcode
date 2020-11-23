class Solution {
    public int minimumEffort(int[][] tasks) {
        Arrays.sort(tasks, (a,b)->Integer.compare((a[0]-a[1]),(b[0]-b[1])));
        int ans = 0, cur = 0;
        for(int[] task: tasks){
            if(task[1] > cur){
                ans += task[1] - cur;
                cur = task[1];
            }
            cur -= task[0];
        }
        return ans;
    }
}
