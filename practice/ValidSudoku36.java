/*36. Valid Sudoku
Medium

1276

410

Add to List

Share
Determine if a 9x9 Sudoku board is valid. Only the filled cells need to be validated according to the following rules:

Each row must contain the digits 1-9 without repetition.
Each column must contain the digits 1-9 without repetition.
Each of the 9 3x3 sub-boxes of the grid must contain the digits 1-9 without repetition.

A partially filled sudoku which is valid.

The Sudoku board could be partially filled, where empty cells are filled with the character '.'.

Example 1:

Input:
[
  ["5","3",".",".","7",".",".",".","."],
  ["6",".",".","1","9","5",".",".","."],
  [".","9","8",".",".",".",".","6","."],
  ["8",".",".",".","6",".",".",".","3"],
  ["4",".",".","8",".","3",".",".","1"],
  ["7",".",".",".","2",".",".",".","6"],
  [".","6",".",".",".",".","2","8","."],
  [".",".",".","4","1","9",".",".","5"],
  [".",".",".",".","8",".",".","7","9"]
]
Output: true
Example 2:

Input:
[
  ["8","3",".",".","7",".",".",".","."],
  ["6",".",".","1","9","5",".",".","."],
  [".","9","8",".",".",".",".","6","."],
  ["8",".",".",".","6",".",".",".","3"],
  ["4",".",".","8",".","3",".",".","1"],
  ["7",".",".",".","2",".",".",".","6"],
  [".","6",".",".",".",".","2","8","."],
  [".",".",".","4","1","9",".",".","5"],
  [".",".",".",".","8",".",".","7","9"]
]
Output: false
Explanation: Same as Example 1, except with the 5 in the top left corner being 
    modified to 8. Since there are two 8's in the top left 3x3 sub-box, it is invalid.
Note:

A Sudoku board (partially filled) could be valid but is not necessarily solvable.
Only the filled cells need to be validated according to the mentioned rules.
The given board contain only digits 1-9 and the character '.'.
The given board size is always 9x9.*/
class Solution {
    public boolean isValidSudoku(char[][] board) {
      HashMap<Integer, Integer>[] rows = new HashMap[9];
      HashMap<Integer, Integer>[] cols = new HashMap[9];
      HashMap<Integer, Integer>[] boxindex = new HashMap[9];
      for(int i = 0; i < 9; i++){
        rows[i] = new HashMap<Integer, Integer>();
        cols[i] = new HashMap<Integer, Integer>();
        boxindex[i] = new HashMap<Integer, Integer>();
      }

      for(int i = 0; i < 9; i++){
        for(int j = 0; j < 9; j++){
          if(board[i][j] != '.'){
            int n = board[i][j] - '0';
            rows[i].put(n, rows[i].getOrDefault(n, 0) + 1);
            cols[j].put(n, cols[j].getOrDefault(n, 0) + 1);
            int index = (i/3) 3 + (j/3);
            boxindex[index].put(n, boxindex[index].getOrDefault(n, 0) + 1);
            if(rows[i].get(n) > 1 || cols[j].get(n) > 1 || boxindex[index].get(n) > 1){
              return false;
            }
          }
        }
      }
      return true;
    }
}


























