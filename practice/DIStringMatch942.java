/*942. DI String Match
Easy

Given a string S that only contains "I" (increase) or "D" (decrease), let N = S.length.

Return any permutation A of [0, 1, ..., N] such that for all i = 0, ..., N-1:

If S[i] == "I", then A[i] < A[i+1]
If S[i] == "D", then A[i] > A[i+1]
 

Example 1:

Input: "IDID"
Output: [0,4,1,3,2]
Example 2:

Input: "III"
Output: [0,1,2,3]
Example 3:

Input: "DDI"
Output: [3,2,0,1]
 

Note:

1 <= S.length <= 10000
S only contains characters "I" or "D".
stuck:
numberic can't fill out all the numbers.
keep the number at recode, leave i + 1;
*/
class DIStringMatch942 {
	public static void main(String[] args){
		String input1 = "IDID";
		String input2 = "III";
		String input3 = "DDI";
		DIStringMatch942 object = new DIStringMatch942();
		object.diStringMatch(input1);
		object.diStringMatch(input2);
		object.diStringMatch(input3);
	}
    public int[] diStringMatch(String S) {
        int lo = 0;
        int hi = S.length();
        int[] result = new int[S.length() + 1];
        for(int i = 0; i < S.length(); i++){
        	if(S.charAt(i) == 'I'){
        		result[i] = lo++;
        	}else{
        		result[i] = hi--;      		
        	}
        }
        result[S.length()] = lo;
        return result;
    }
}