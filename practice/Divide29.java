/*
29.divide two integers.
given two integers divident and divisor, divide two integers without using multiplication, division and mod operator.
return the quotient after dividing dividend by divisor.
the integer division should truncate toward zero.
in: diviend = 10, divisor = 3
out:3
in: divident = 7, divisor = -3
out:-2
both divident and divisor will be 32-bit
the divisor will never be 0.
assume we are dealing environment which could only store integers within 32bit signed integer
[-231,231-1],for the purpose, assume that function return 231-1 when division result overflows.
for loop divident - divisor
time++
if divisor is negative, symbol
result overflow?
*/
class Divide{
	public static void main(String[] args){
		int dividend1 = 10;
		int divisor1 = 3;
		int dividend2 = 7;
		int divisor2 = -3;
		System.out.println(divide(dividend1,divisor1));
		System.out.println(divide(dividend2,divisor2));
	}
	public static int divide(int divident, int divisor){
		int time  = 0;
		boolean negative = false;
		negative = ((divident < 0 && divisor <0) || (divident > 0 && divisor > 0) )? false:true;
		int absdivident = Math.abs(divident);
		int absdivisor = Math.abs(divisor);		
		while(absdivident > absdivisor){
			absdivident = absdivident - absdivisor;
			time++;
		}
		return negative? -time: time;
	}
}