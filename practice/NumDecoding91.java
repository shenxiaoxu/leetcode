/*
91.decode ways

a->1
b->2
number of ways to decode it
in:"12"
out:2. ab (1,2) L(12)
in:"226"
out:3 "bz"(2 26) VF"22 6" "BBF" 2 2 6
*/
import java.util.*;
class NumDecoding{
	public static void main(String[] args){
		String input = "226";
		String input2 = "12";
		LinkedList<LinkedList<String>> results = new LinkedList<LinkedList<String>>();
		numDecoding(input2, new LinkedList<>(), results, 0);
		System.out.println(results.size());
	}
	public static void numDecoding(String input, LinkedList<String> result, LinkedList<LinkedList<String>> results, int index){
		if(index > input.length()){
			return;
		}
		String resultString="";
		for(int i = 0; i < result.size();i++){
			resultString += result.get(i);
		}
		if(resultString.length() == input.length()){
			System.out.println(result);
			results.add(new LinkedList<String>(result));
			return;
		}

		for(int i = index; i < input.length(); i++){
			for(int j = 1; j <= 2; j++){
				if(i + j <= input.length()){
					String temp = input.substring(i, i + j);
					//System.out.println(temp);
					if(Integer.parseInt(temp) <= 26){
						result.addFirst(temp);
						numDecoding(input,result, results, i + j);
						result.poll();					
					}
				}				
			}
		}
	}
}