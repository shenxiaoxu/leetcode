/*679. 24 Game
Hard

590

118

Add to List

Share
You have 4 cards each containing a number from 1 to 9. You need to judge whether they could operated through *, /, +, -, (, ) to get the value of 24.

Example 1:
Input: [4, 1, 8, 7]
Output: True
Explanation: (8-4) * (7-1) = 24
Example 2:
Input: [1, 2, 1, 2]
Output: False
Note:
The division operator / represents real division, not integer division. For example, 4 / (1 - 2/3) = 12.
Every operation done is between two numbers. In particular, we cannot use - as a unary operator. For example, with [1, 1, 1, 1] as input, the expression -1 - 1 - 1 - 1 is not allowed.
You cannot concatenate numbers together. For example, if the input is [1, 2, 1, 2], we cannot write this as 12 + 12.*/
class Solution {
	char[] operator = {'+','-','*','/'};
	char[] parentheses = {'(',')', ''};
    public boolean judgePoint24(int[] nums) {
        int[] visited = new visited[nums.length];
        boolean result = rBuildString(nums, visited, 0);
        return result;
    }
    private boolean rBuildString(int[] nums, int[] visited, int numlevel, int operatorl, int parenthesesl){
    	Stack<Integer> s = new Stack<Integer>();
    	for(int i = 0; i < visited.length; i++){
    		for(int j = 0; j < operator; j++){
    			char op = operator[j];
    		}
    		for()
    	}
    }
}

class Solution {
    public boolean judgePoint24(int[] nums) {
        List<Double> list = new ArrayList<>();
        for (int i : nums) {
            list.add((double) i);
        }
        return dfs(list);
    }

    // 每次dfs都是选取两张牌
    private boolean dfs(List<Double> list) {
        if (list.size() == 1) {
            // 如果此时list只剩下了一张牌
            if (Math.abs(list.get(0)- 24.0) < 0.001) {
                return true;
            }
            return false;
        }
        
        // 选取两张牌
        for(int i = 0; i < list.size(); i++) {
            for(int j = i + 1; j < list.size(); j++) {
                // 对于每下一个可能的产生的组合
                for (double c : compute(list.get(i), list.get(j))) {
                    List<Double> nextRound = new ArrayList<>();
                    // 将他们加入到下一个list循环中去
                    nextRound.add(c);
                    for(int k = 0; k < list.size(); k++) {
                        if(k == j || k == i) continue;
                        nextRound.add(list.get(k));
                    }
                    if(dfs(nextRound)) return true;
                }
            }
        }
        return false;

    }
    // 计算下一个可能产生的组合
    private List<Double> compute(double a, double b) {
        List<Double> res = Arrays.asList(a + b,a-b,b-a,a*b,a/b,b/a);
        return res;
    }
}
