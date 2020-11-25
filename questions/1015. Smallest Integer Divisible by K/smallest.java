/*
1015. Smallest Integer Divisible by K
Medium

Given a positive integer K, you need to find the length of the smallest positive integer N such that N is divisible by K, and N only contains the digit 1.

Return the length of N. If there is no such N, return -1.

Note: N may not fit in a 64-bit signed integer.
*/
class Solution {
    public int smallestRepunitDivByK(int k) {
        int d = k%10;
		if(!(d== 1 || d == 3 || d == 7 || d==9)) return -1;
		HashSet<Integer> set = new HashSet();
		int prev = 0;
		for(int i = 1; i < k + 1; i++){
			int remain = (prev *10+ 1)%k;
			if(remain == 0){
				return i;
			}
			if(set.contains(remain)) return -1;
			prev = remain;
			set.add(remain);
		}
		return -1;        
    }
}
