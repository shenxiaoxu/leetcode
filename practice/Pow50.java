/*50. Pow(x, n)
Medium

1170

2636

Add to List

Share
Implement pow(x, n), which calculates x raised to the power n (xn).

Example 1:

Input: 2.00000, 10
Output: 1024.00000
Example 2:

Input: 2.10000, 3
Output: 9.26100
Example 3:

Input: 2.00000, -2
Output: 0.25000
Explanation: 2-2 = 1/22 = 1/4 = 0.25
Note:

-100.0 < x < 100.0
n is a 32-bit signed integer, within the range [−231, 231 − 1]*/
class Solution {
    public double myPow(double x, int n) {
 		long N = n;
 		if(n < 0){
 			x = 1/x;
 			N = -N;
 		}
 		return fastPow(x, N);       
    }
    public double fastPow(double x, long N){
    	if(N == 0) return 1.0;

    	double half = fastPow(x, N/2);
    	double result = 0;
    	if(N % 2 == 0){
    		result =half * half;
    	}else{
    		result = half * half * x;
    	}

    	return result;
    }
    public double myPow(double x, int n){
    	long N = n;
    	if(n < 0){
    		x = 1/x;
    		N = -N;
    	}
    	double ans = 1;
    	double current_product = x;//current_product and answ is different
    	for(int i = N; i > 0; i=i/2){
    		if(i % 2 == 1){
    			ans = ans * current_product;
    		}
    		current_product = current_product * current_product;
    		
    	}
    	return ans;
    }
}

























