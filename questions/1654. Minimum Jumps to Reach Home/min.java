class Solution {
    public int minimumJumps(int[] forbidden, int a, int b, int x) {
        int l = forbidden.length, max_v = 0;
        for(int i = 0; i < l; i++){
            max_v = Math.max(forbidden[i], max_v);
        }
        max_v = Math.max(max_v, x) + a + b;
        int[] arr = new int[max_v + 1];
        Arrays.fill(arr, Integer.MAX_VALUE);
        arr[0] = 0;
        for(int i = 0; i < l; i++){
            arr[forbidden[i]] = -1;
        }
        Queue<Integer> queue = new LinkedList();
        queue.add(0);
        while(!queue.isEmpty()){
            int cur = queue.poll();
            //System.out.println(cur);
            if(cur + a <= max_v && arr[cur + a] > arr[cur] + 1){
                arr[cur + a] = arr[cur] + 1;
                queue.add(cur + a);
            }
            if(cur - b > 0 && arr[cur - b] > arr[cur] + 1){
                arr[cur - b] = arr[cur] + 1;
                if(cur - b + a <= max_v && arr[cur - b + a] > arr[cur] + 2){
                    arr[cur - b + a] = arr[cur] + 2;
                    queue.add(cur - b + a);
                }
            }
        }
        return arr[x] == Integer.MAX_VALUE? -1: arr[x];
    }
}
