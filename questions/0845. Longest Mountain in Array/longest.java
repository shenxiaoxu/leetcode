class Solution {
    public int longestMountain(int[] arr) {
        int l = arr.length, res = 0;
        int[] up = new int[l];
        int[] down = new int[l];
        for(int i = l - 2; i>=0; i--){
            if(arr[i] > arr[i + 1]) down[i] = down[i + 1] + 1;
        }
        for(int i = 0; i < l; i++){
            if(i > 0 && arr[i] > arr[i - 1]) up[i] = up[i - 1] + 1;
            if(up[i] > 0 && down[i] > 0) res = Math.max(res, down[i] + up[i] + 1);
        }
        return res;
    }
}
