/*739. Daily Temperatures
Medium

2186

68

Add to List

Share
Given a list of daily temperatures T, return a list such that, for each day in the input, tells you how many days you would have to wait until a warmer temperature. 
 If there is no future day for which this is possible, put 0 instead.

For example, given the list of temperatures T = [73, 74, 75, 71, 69, 72, 76, 73], your output should be [1, 1, 4, 2, 1, 1, 0, 0].

Note: The length of temperatures will be in the range [1, 30000]. Each temperature will be an integer in the range [30, 100].

Accepted
127,827
Submissions
205,872
*/
class Solution {
    public int[] dailyTemperatures(int[] T) {
        Stack<Integer> store = new Stack<Integer>();
        int[] result = new int[T.length];
        for(int i = 0; i < T.length; i++){
        	while(!store.isEmpty() && T[i] > T[store.peek()]){
        		int idx = store.pop();
        		result[idx] = i - idx;
        	}
        	store.push(i);
        }
        return result
    }
}