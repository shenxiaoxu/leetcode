/*498. Diagonal Traverse
Medium

576

284

Add to List

Share
Given a matrix of M x N elements (M rows, N columns), return all elements of the matrix in diagonal order as shown in the below image.

 

Example:

Input:
[
 [ 1, 2, 3 ],
 [ 4, 5, 6 ],
 [ 7, 8, 9 ]
]

Output:  [1,2,4,7,5,3,6,8,9]

Explanation:

 

Note:

The total number of elements of the given matrix will not exceed 10,000.
from [0,n] [n,0]
*/
class Solution {
    public int[] findDiagonalOrder(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[] result = new int[m*n];
        int sign = 1;
        int idx = 0;
        for(int i = 0; i < m; i++){
        	int r = i;
        	while(r > c){
        		result[idx] = matrix[r--][c++];
        	}
        	int c = i;
        		result[idx] = matrix[i + 1][j - 1];
        	}
        	
        
        return result;
    }
}