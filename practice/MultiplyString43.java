/*
43. Multiply Strings
Medium

1441

666

Add to List

Share
Given two non-negative integers num1 and num2 represented as strings, return the product of num1 and num2, also represented as a string.

Example 1:

Input: num1 = "2", num2 = "3"
Output: "6"
Example 2:

Input: num1 = "123", num2 = "456"
Output: "56088"
Note:

The length of both num1 and num2 is < 110.
Both num1 and num2 contain only digits 0-9.
Both num1 and num2 do not contain any leading zero, except the number 0 itself.
You must not use any built-in BigInteger library or convert the inputs to integer directly.
attention: 
multiply string num1 * num2, i index j index = i + j, i + j + 1 

*/
class Solution {
    public String multiply(String num1, String num2) {
    	int len1 = num1.length;
    	int len2 = num2.length;
    	int[] position = new int[len1 + len2];
    	for(int i = len1 - 1; i >= 0; i--){
    		for(int j = len2 - 1; j >= 0; j--){
    			int n1 = num1.charAt(i) - '0';
    			int n2 = num2.charAt(j) - '0';
    			int p1 = i + j;
    			int p2 = i + j + 1;
    			int sum = n1 * n2 + position[p2];

    			position[p1] += sum/10;
    			position[p2] = sum%10;

    		}
    	}
    	StringBuilder sb = new StringBuilder();
    	for(int p:position){
    		if(!(sb.length == 0 && p == 0)){
    			sb.append(p);
    		}
    	}
    	return sb.length() == 0?"0":sb.toString();    	
    }
}







