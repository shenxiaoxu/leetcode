/*
93. Restore IP Addresses

Given a string containing only digits, restore it by returning all possible valid IP address combinations.

Example:

Input: "25525511135"
Output: ["255.255.11.135", "255.255.111.35"]
attention: 1111, 0000
*/
import java.util.*;
class RestoreIpAddresses93{
	public static void main(String[] args){
		String input = "25525511135";
		String input2 = "1111";
		RestoreIpAddresses93 object = new RestoreIpAddresses93();
		System.out.println(object.restoreIpAddresses(input2));
	}
    public List<String> restoreIpAddresses(String s) {
		LinkedList<String> result = new LinkedList<String>();
		if(s == "" || s.length() > 12) return result;
		restoreIpAddressesSolution2(s, 0,"",result);
		return result;        
    }	
	public static void restoreIpAddresses(String input, int index, String temp, int count, LinkedList<String> result){
		if(count >4){
			return;
		}
		if(index > input.length()){
			return;
		}
		if(index == input.length()  && count == 4){
			result.add(temp);
			return;
		}
		for(int i = index + 1; i <= input.length(); i++){
			String temp1 = "";
			temp1 += input.substring(index, i);

			if(temp1.length() <= 3 && temp1.length() >= 1&& Integer.parseInt(temp1) <= 255)
			{
				String previous = temp;
				if(temp == ""){
					temp = temp1;
				}else{
					temp = temp + "." + temp1;
				}
				//System.out.println("temp: " + temp);
				restoreIpAddresses(input, i, temp, count + 1, result);
				temp = previous;			
			}
			
		}
	}
	public void restoreIpAddressesSolution2(String input, int field, String current, LinkedList<String> result){
		//System.out.println("current:" + current + "field:" + field + "input" + input);
		if(field == 4 && input.equals("")){
			result.add(current.substring(1));
			return;
		}
		if(field == 4 || input.length() == 0) return;
		else{
			restoreIpAddressesSolution2(input.substring(1), field + 1, current + '.' + input.substring(0,1), result);
			if(input.length() > 1 && input.charAt(0) != '0'){
				restoreIpAddressesSolution2(input.substring(2), field + 1, current + '.' + input.substring(0,2), result);
				if(input.length() > 2 && Integer.valueOf(input.substring(0,3)) <= 255){
					restoreIpAddressesSolution2(input.substring(3), field + 1, current + '.' + input.substring(0,3), result);
				}
			}
		}
	}
}









