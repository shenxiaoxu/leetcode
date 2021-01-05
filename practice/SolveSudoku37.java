/*
37.sudoku solver
write a program to solve a suduku puzzle by filling empty cells
each of digits 1-9 must occur exactly once in each row
53..7....
6..195...
.98....6.
8...6...3
4..8.3..1
7...2...6
.6....28.
...419..5
....8..79
*/
class SolveSudoku{
	public static void main(String[] args){
		char[][] board = {
		 {'5','3','.','.','7','.','.','.','.'},
		 {'6','.','.','1','9','5','.','.','.'},
		{'.','9','8','.','.','.','.','6','.'},
		{'8','.','.','.','6','.','.','.','3'},
		{'4','.','.','8','.','3','.','.','1'},
		{'7','.','.','.','2','.','.','.','6'},
		{'.','6','.','.','.','.','2','8','.'},
		{'.','.','.','4','1','9','.','.','5'},
		{'.','.','.','.','8','.','.','7','9'}
		};
		solveSudoku(board);
		for(int i = 0; i < board.length; i++){
			for(int j = 0; j < board[0].length; j++){
				System.out.print(board[i][j]);
			}
			System.out.println();
		}
	}
	public static void solveSudoku(char[][] board){
		solveSudokuDFS(board, 0,0);
	}
	public static boolean solveSudokuDFS(char[][] board, int i, int j){
		if(i == 9) return true;
		if(j >= 9){
			return solveSudokuDFS(board, i + 1, 0);
		}
		
		if(board[i][j] == '.'){
			for(int k = 1; k <= 9; k++){
				board[i][j] = (char)(k + '0');
				if(isValid(board, i, j)){
					 if(solveSudokuDFS(board, i, j + 1)){
					 	return true;
					 }
				}
				board[i][j] = '.';
			}
		}else{
			return solveSudokuDFS(board, i, j + 1);
		}
		return false;
	}
	public static boolean isValid(char[][] board, int i, int j){
		for(int col = 0; col< 9; col++){
			if(col != j && board[i][col] == board[i][j]){
				return false;
			}
		}
		for(int row = 0; row< 9; row++){
			if(row !=  i&& board[i][j] == board[row][j]){
				return false;
			}
		}
		for(int row = i/3*3; row < i/3*3 + 3; row++){
			for(int col = j/3*3; col < j/3*3 + 3; col++){
				if((row != i || col != j) && board[i][j] == board[row][col]){
					return false;
				}
			}
		}
		return true;
	}
}