/*85. Maximal Rectangle

Given a 2D binary matrix filled with 0's and 1's, find the largest rectangle containing only 1's and return its area.

Example:

Input:
[
  ["1","0","1","0","0"],
  ["1","0","1","1","1"],
  ["1","1","1","1","1"],
  ["1","0","0","1","0"]
]
Output: 6
solution:
cur_left cur_right, left[], right[], height[],keep update cur_left, cur_right.
if encounter 0, update cur_left or cur_right, else update left[], right[] to maxleft and min right to keep rectangele larger.
final result will be (right - left)*height

*/
class Solution {
    public int maximalRectangle(char[][] matrix) {
    	if(matrix.length == 0) return 0;
        int m = matrix.length;
        int n = matrix[0].length;
        int[] left = new int[n];
        int[] right = new int[n];
        int[] height = new int[n];
        int result = 0;
        Arrays.fill(right, n);

        for(int i = 0; i < m; i++){
        	int cur_left = 0;
        	int cur_right = n;//every time to reset cur_left and cur_right;
        	for(int j = 0; j < n; j++){
        		if(matrix[i][j] == '0'){
        			height[j] = 0;
        		}else{
        			height[j]++;
        		}
        	}

        	for(int j = 0; j < n; j++){
        		if(matrix[i][j] == '0'){
        			left[j] = 0;
        			cur_left = j+1;
        		}else{
        			left[j] = Math.max(left[j], cur_left);
        		}
        	}

        	for(int j = n - 1; j>=0; j--){
        		if(matrix[i][j] == '0'){
        			right[j] = n;
        			cur_right = j;
        		}else{
        			right[j] = Math.min(right[j], cur_right);
        		}
        	}

        	for(int j = 0; j < n; j++){
        		result = Math.max(result, (right[j] - left[j])*height[j]);
        	}
        }
        return result;
    }


}