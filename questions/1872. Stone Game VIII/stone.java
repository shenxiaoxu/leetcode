class Solution {
    public int stoneGameVIII(int[] stones) {
        for(int i = 1; i < stones.length; i++){
            stones[i] += stones[i - 1];
        }
        int dp = stones[stones.length - 1];
        for(int i = stones.length - 2; i > 0; i--){
            dp = Math.max(dp, stones[i] - dp);
        }
        return dp;
    }
}