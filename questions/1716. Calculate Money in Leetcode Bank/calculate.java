/*
Hercy wants to save money for his first car. He puts money in the Leetcode bank every day.

He starts by putting in $1 on Monday, the first day. Every day from Tuesday to Sunday, he will put in $1 more than the day before. On every subsequent Monday, 
he will put in $1 more than the previous Monday.
Given n, return the total amount of money he will have in the Leetcode bank at the end of the nth day.
*/
class Solution{
	public int calculate(int n){
		int res = 0;
		int base = 1;
		for(int i = 1; i <= n; i++){
			res += (i - 1)% 7+base;
			if((i - 1)% 7 == 0){
				base += 1;
			}			
		}
		return res;
	}
}