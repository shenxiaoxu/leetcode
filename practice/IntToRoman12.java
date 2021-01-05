/*
12.integer to roman
symbo 
I 1
V 5
X 10
L 50
C 100
D 500
M 1000
largest to smallest from left to right, four IV, nine IX
I can be placed before V 5 and X 10 to make 4 and 9
X can be placed before L(50) and C(100) to make 40 and 90
C can be placed before D(500) and M(1000) to make 400 and 900.
in:4 out:IV
in:9 out:IX
in:58 out:LVIII
in:1994 out:MCMXCIV
solution:
div 10 mod 10---> trasfer to string add to end
div 100
div 1000
4,9 special 
*/
class IntToRoman{
	public static String IntToRoman(int input){
		String result = "";
		String[] romans = {"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};
		int[] integer = {1000,900,500,400,100,90,50,40,10,9,5,4,1};
		int count = 0;
		int index = 0;
		while(input > 0){
			count = input/integer[index];
			input = input % integer[index];
			while(count > 0){
				result += romans[index];
				count--;
			}
			index++;
		}
		return result;		
	}
	public static void main(String[] args){
		int test1 = 4;
		int test2 = 9;
		int test3 = 58;
		int test4 = 1994;
		System.out.println(IntToRoman(test1));
		System.out.println(IntToRoman(test2));
		System.out.println(IntToRoman(test3));
		System.out.println(IntToRoman(test4));
	}
}