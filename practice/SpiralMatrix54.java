/*54. Spiral Matrix

Given a matrix of m x n elements (m rows, n columns), return all elements of the matrix in spiral order.

Example 1:

Input:
[
 [ 1, 2, 3 ],
 [ 4, 5, 6 ],
 [ 7, 8, 9 ]
]
Output: [1,2,3,6,9,8,7,4,5]
Example 2:

Input:
[
  [1, 2, 3, 4],
  [5, 6, 7, 8],
  [9,10,11,12]
]
Output: [1,2,3,4,8,12,11,10,9,5,6,7]
*/
class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList();

        int r1 = 0;
        int r2 = matrix.length - 1;

        if(matrix.length == 0) return result;

        int c1 = 0;
        int c2 = matrix[0].length - 1;

        while(r1 <= r2 && c1 <= c2){
        	for(int i = c1; i <= c2; i++){
        		result.add(matrix[r1][i]);
        	}
        	for(int i = r1 + 1; i <= r2; i++){
        		result.add(matrix[i][c2]);
        	}
        	if(r1 < r2 && c1 < c2){//not duplicate result
        		for(int j = c2 - 1; j > c1; j--){
        			result.add(matrix[r2][j]);
        		}
        		for(int j = r2; j > r1; j--){
        			result.add(matrix[j][c1]);
        		}
        	}
        	c1++;
        	c2--;
        	r1++;
        	r2--;
        }
        return result;
    }
}







