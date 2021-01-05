/*
43.mutiply strings
given two non-negative integers num1 and num2 represented as strings, return product of num1 and num2, also represented as a string.
in: num1 = "2", num2 = "3" out:"6"
in: num1 = "123" num2 = "456",out:"56088"
the length of both num1 and num2 is < 110
both num1 and num2 contain digits 0-9
both num1 and num2 don't contain leading zero,except number 0 iteself.
solution:
for num1
for num2
multiple each digit, each add togeter and append to the end.
special attention to already max integer maxium number, then need to each digit convert to string then add.
*/
import java.util.*;
class Multiply{
	public static void main(String[] args){
		String s = "2";
		String s1 = "3";
		String s2 = "123";
		String s3 = "456";
		System.out.println(multiply(s, s1));
		System.out.println(multiply(s2, s3));
	}
	public static String multiply(String first, String second){
		char[] array1 = first.toCharArray();
		char[] array2 = second.toCharArray();
		String result;
		LinkedList<String> temps = new LinkedList<String>();
		int carry = 0;
		for(int i = array1.length - 1;i >=0;i-- ){
			int firstDigit = convertCharToInt(array1[i]);
			String temp = "";
			for(int j = array2.length - 1; j>=0;j--){
				int secondDigit = convertCharToInt(array2[j]);
				
				temp = convertIntToChar(secondDigit * firstDigit % 10 + carry) + temp;
				carry = secondDigit * firstDigit / 10;
				
			}
			if(carry == 1){
				temp = "1" + temp;
				carry = 0;
			}
			System.out.println("iteration" + temp);
			temps.addLast(temp);
		}
		System.out.println("adds" + temps);
		int recuringTime = 1;
		while(temps.size() != 1){
			String temp1 = temps.get(0);
			String temp2 = temps.get(1);
			String temp3 = "";
			for(int j = 0; j < recuringTime; j++){
				temp3 = temp1.charAt(temp1.length() - 1 - j) + temp3;
			}
			System.out.println("temp3before" + temp3);
			int carryAdd = 0;
			int index1 = temp1.length() - recuringTime - 1;
			int index2 = temp2.length() - 1;
			while(index1 != -1){

				temp3  = convertIntToChar((convertCharToInt(temp1.charAt(index1)) + convertCharToInt(temp2.charAt(index2)))%10 + carryAdd) + temp3;
				carryAdd = (convertCharToInt(temp1.charAt(index1)) + convertCharToInt(temp2.charAt(index2)))/10;
				index1--;
				index2--;
				
			}
			int last = 0;
			if(index2 == 0){
				last = convertCharToInt(temp2.charAt(0));
			}
			if(carryAdd != 0){
				temp3  = convertIntToChar(carryAdd + last) + temp3;
			}
			System.out.println("temp3" + temp3);
			recuringTime++;
			temps.poll();
			temps.poll();
			temps.addFirst(temp3);
			System.out.println("adds" + temps);
		}
		return temps.get(0);
	}
	public static int convertCharToInt(char a){
		return (int)(a - '0');
	}
	public static char convertIntToChar(int a){
		return (char)(a + '0');
	}
}
