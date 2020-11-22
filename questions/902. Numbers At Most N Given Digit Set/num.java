class Solution {
    public int atMostNGivenDigitSet(String[] digits, int n) {
        String str = String.valueOf(n);
        int sl = str.length(), dl = digits.length, res = 0;
        for(int i = 1; i < sl; i++){
            res += Math.pow(dl, i);
        }
        for(int i = 0; i < sl; i++){
            boolean sameNumber = false;
            for(String s: digits){
                if(s.charAt(0) < str.charAt(i)){
                    res += Math.pow(dl, sl - i - 1);
                }else if(s.charAt(0) == str.charAt(i)){
                    sameNumber = true;
                }
            }
            if(!sameNumber) return res;
        }
        return res + 1;
    }
}
