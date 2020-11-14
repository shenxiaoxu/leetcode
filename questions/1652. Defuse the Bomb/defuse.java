class Solution {
    public int[] decrypt(int[] code, int k) {
        int l = code.length;
        int[] res = new int[l];
        if(k == 0) return res;        
        for(int i = 0; i < l; i++){
            int pres = 0;
            if(k > 0){
                for(int s = i + 1; s < i + k + 1; s++){
                    pres += code[s%l];
                }
            }else{
                for(int s = i - 1; s > i + k - 1 ; s--){
                    pres += code[(s+l)%l];
                }                
            }
            res[i] = pres;
        }
        return res;
    }
}
