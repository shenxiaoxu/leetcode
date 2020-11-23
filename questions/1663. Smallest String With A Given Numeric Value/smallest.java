class Solution {
    public String getSmallestString(int n, int k) {
        StringBuilder str = new StringBuilder();
        for(int i = 0; i < n; i++){
            str.append('a');
        }
        k -= n;
        int i = n - 1;
        while(k > 0){
            int tmp = Math.min(k, 25);
            str.setCharAt(i, (char)((int)str.charAt(i) + tmp));
            k -= tmp;
            i--;
        }
        return str.toString();
    }
}
