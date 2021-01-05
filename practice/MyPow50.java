/*
50.pow(x,n) implement pow(x,n),which calculates x raised to power n
in:2.000,10
out:1024.000
in:2.1000,3
out:9.261
in:2.000,-2
out:0.2500
note:-100<x<100
n is a 32 bit signed integer, -231,231 - 1
solution: from n to 0, recuring multiply x, if n is negative, return reverse.
*/
import java.util.*;
class MyPow{
	public static void main(String[] args){
		double number1 = 2.000;
		int times1 = 10;
		double number2 = 2.100;
		int times2 = 3;
		double number3 = 2.000;
		int times3 = -2;
		System.out.println(pow(number1,times1));
		System.out.println(pow(number2,times2));
		System.out.println(pow(number3,times3));
	}
	public static double pow(double x, int n){
		boolean flag = false;
		double result = 1;
		if(n < 0){flag = true;}else{flag = false;}
		n = Math.abs(n);
		for(int i = 0; i < n; i++){
			result = result * x;
		}
		if(flag){
			result = 1/result;
		}
		return result;
	}
}