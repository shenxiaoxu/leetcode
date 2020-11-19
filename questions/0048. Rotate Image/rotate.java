class Solution {
    public void rotate(int[][] matrix) {
        reverse(matrix);
        for(int i = 0; i < matrix.length; i++){
            for(int j = i; j < matrix[0].length; j++){
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = tmp;
            }
        }
    }
    private void reverse(int[][] matrix){
        for(int i = 0; i < matrix.length/2; i++){
            int[] tmp = matrix[i];
            matrix[i] = matrix[matrix.length - i - 1];
            matrix[matrix.length - i - 1] = tmp;
        }
    }
}
