/*415. Add Strings
Easy

719

217

Add to List

Share
Given two non-negative integers num1 and num2 represented as string, return the sum of num1 and num2.

Note:

The length of both num1 and num2 is < 5100.
Both num1 and num2 contains only digits 0-9.
Both num1 and num2 does not contain any leading zero.
You must not use any built-in BigInteger library or convert the inputs to integer directly.*/
class Solution {
    public String addStrings(String num1, String num2) {
    	if(num1.length() == 0) return num2;
    	if(num2.length() == 0) return num1;
    	int l1 = num1.length() - 1;
    	int l2 = num2.length() - 1;
    	if(l1 == 0 || l2 == 0) return l1==0?l2:l1;
    	StringBuilder sb = new StringBuilder();
    	int carry = 0;
    	while(l1 != -1 || l2 != -1){
    		int n1 = 0;
    		int n2 = 0;
    		if(l1 != -1){
    			n1 = Integer.valueOf(num1.charAt(l1--));
    		}
    		if(l2 != -1){
    			n2 = Integer.valueOf(num1.charAt(l2--));
    		}
    		int p1 = (n1+n2+carry)%10;
    		sb.append(Character.valueOf(p1));
    		carry = (n1+n2+carry)/10;
    	}
    	if(carry == 1) sb.append("1");
    	return sb.reverse().toString();      
    }
}

public class Solution {
    public String addStrings(String num1, String num2) {
        StringBuilder sb = new StringBuilder();
        int carry = 0;
        for(int i = num1.length() - 1, j = num2.length() - 1; i >= 0 || j >= 0 || carry == 1; i--, j--){
            int x = i < 0 ? 0 : num1.charAt(i) - '0';
            int y = j < 0 ? 0 : num2.charAt(j) - '0';
            sb.append((x + y + carry) % 10);
            carry = (x + y + carry) / 10;
        }
        return sb.reverse().toString();
    }
}