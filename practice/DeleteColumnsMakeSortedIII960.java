/*960. Delete Columns to Make Sorted III
We are given an array A of N lowercase letter strings, all of the same length.

Now, we may choose any set of deletion indices, and for each string, we delete all the characters in those indices.

For example, if we have an array A = ["babca","bbazb"] and deletion indices {0, 1, 4}, then the final array after deletions is ["bc","az"].

Suppose we chose a set of deletion indices D such that after deletions, the final array has every element (row) in lexicographic order.

For clarity, A[0] is in lexicographic order (ie. A[0][0] <= A[0][1] <= ... <= A[0][A[0].length - 1]), A[1] is in lexicographic order (ie. A[1][0] <= A[1][1] <= ... <= A[1][A[1].length - 1]), and so on.

Return the minimum possible value of D.length.

 

Example 1:

Input: ["babca","bbazb"]
Output: 3
Explanation: After deleting columns 0, 1, and 4, the final array is A = ["bc", "az"].
Both these rows are individually in lexicographic order (ie. A[0][0] <= A[0][1] and A[1][0] <= A[1][1]).
Note that A[0] > A[1] - the array A isn't necessarily in lexicographic order.
Example 2:

Input: ["edcba"]
Output: 4
Explanation: If we delete less than 4 columns, the only row won't be lexicographically sorted.
Example 3:

Input: ["ghi","def","abc"]
Output: 0
Explanation: All rows are already lexicographically sorted.
 

Note:

1 <= A.length <= 100
1 <= A[i].length <= 100
//solution:
assume dp[i][j] is the minimal step to make input sorted, i means length is i, j means there are j strings.
dp[i][j] = if(input[i][j] > input[i - 1][j]) , max(dp[i - 1][j] + 1, dp[i - 1][j])
babca dp[0] = 1 dp[1] = 1 dp[j] = max(dp[i] + 1, 1) dp[i] means from 0 to i, minimal step to make it sorted.
think as non-descending sequence.

*/

class DeleteColumnsMakeSortedIII960{
	public static void main(String[] args){
		String[] input = {"babca","bbazb"};
		String[] input2 = {"edcba"};
		String[] input3 = {"ghi","def","abc"};
		String[] input4 = {"aabbaa","baabab","aaabab"};
		System.out.println(DeleteColumnsMakeSorted(input));
		System.out.println(DeleteColumnsMakeSorted(input2));
		System.out.println(DeleteColumnsMakeSorted(input3));
		System.out.println(DeleteColumnsMakeSorted(input4));
	}
	public static int DeleteColumnsMakeSorted(String[] input){
		int count = 0;
		int[] dp = new int[input[0].length()];
		dp[0] = 1;
		int answer = 0;
		for(int i = 1; i < input[0].length(); i++){
			dp[i] = 1;
			for(int k = 0; k < i; k++){
				boolean isOk = true;
				for(int j = 0; j < input.length; j++){				
					if(input[j].charAt(i) < input[j].charAt(k)){
						isOk = false;
						break;
					}
				}

				if(!isOk) continue;
				else{
					dp[i] = Math.max(dp[i],dp[k] + 1);
				}
			}
			answer = Math.max(answer, dp[i]);			
		}
		return input[0].length() - answer;
	}
}

























