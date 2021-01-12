/*
You are given an integer array jobs, where jobs[i] is the amount of time it takes to complete the ith job.

There are k workers that you can assign jobs to. Each job should be assigned to exactly one worker. The working time of a worker is the sum of the time it takes 
to complete all jobs assigned to them. Your goal is to devise an optimal assignment such that the maximum working time of any worker is minimized.

Return the minimum possible maximum working time of any assignment.
*/
class Solution {
    int res = Integer.MAX_VALUE;
    public int minimumTimeRequired(int[] jobs, int k) {
        int[] workload = new int[k + 1];
        dfs(workload, jobs, 0);
        return res;
    }
    private void dfs(int[] workload, int[] jobs, int idx){
        if(idx == jobs.length){
            int max = 0;
            for(int i = 1; i < workload.length; i++){
                max = Math.max(max, workload[i]);
            }
            res = Math.min(res, max);
            return;
        }
        HashSet<Integer> seen = new HashSet();
        for(int i = 1; i <= workload.length - 1; i++){
            if(workload[i] + jobs[idx] >= this.res) continue;
            if(seen.contains(workload[i])) continue;
            seen.add(workload[i]);
            workload[i] += jobs[idx];
            dfs(workload, jobs, idx + 1);
            workload[i] -= jobs[idx];
        }
    }
}