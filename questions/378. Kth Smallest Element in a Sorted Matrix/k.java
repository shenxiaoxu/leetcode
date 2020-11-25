class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        int m = matrix.length, n = matrix[0].length, res = 0;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->a[0]-b[0]);
        for(int i = 0; i < Math.min(k, m); i++){
            pq.add(new int[]{matrix[i][0], i, 0});
        }
        while(k > 0){
            int[] t = pq.poll();
            res = t[0];
            if(t[2] + 1 < n){
                pq.add(new int[]{matrix[t[1]][t[2] + 1], t[1], t[2] + 1});
            }
            k -= 1;
        }
        return res;
    }
}
