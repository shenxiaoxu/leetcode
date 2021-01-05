/*
8.String to Integer (atoi)
implement atoi converts a string to an integer.
discards whitespace
start character, take optional plus or minus, interprets as a numerical value.
in:42
out:42
in-42
out-42
input 4193 with words
out:4193
input words and 987
out:0
input:-91283472332
output:-2147483648 int_min(-231)

solution:
if white space, continue to non white space
if char between 0-9 while(0-9) transfer to number,
if character not between 0-9, return 0
if < Integer.min or > Integer.max return min or max. 
*/
import java.lang.*;
class MyAtoi{
	public static int myAtoi(String str){
		str = str.trim();
		boolean negative = false;
		int answer = 0;
		for(int i = 0; i < str.length(); i++){
			if(i == 0 && str.charAt(0) == '-'){
				negative = true;
				continue;
			}
			if(str.charAt(i) < '0' || str.charAt(i) > '9'){
				return 0;
			}
			while(i < str.length() && str.charAt(i) >= '0' && str.charAt(i) <= '9'){
				if(answer > Integer.MAX_VALUE / 10 || (answer == Integer.MAX_VALUE/10 && str.charAt(i) == '7')){
					return negative ? Integer.MIN_VALUE:Integer.MAX_VALUE;
				}
				answer = ((int)str.charAt(i) - (int)'0') + answer* 10;
				i++;
			}
			break;
		}
		answer = negative ? (-answer): answer;

		return answer;
	}
	public static void main(String[] args){
		String test = "42";
		String test2 = "-42";
		String test3 = "4193 with words"; 
		String test4 = "words and 987";
		String test5 = "-91283472332";  

		System.out.println(myAtoi(test));
		System.out.println(myAtoi(test2));
		System.out.println(myAtoi(test3));
		System.out.println(myAtoi(test4));
		System.out.println(myAtoi(test5));
	}
}