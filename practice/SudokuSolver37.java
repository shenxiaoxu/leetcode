/*37. Sudoku Solver
Hard

1374

82

Add to List

Share
Write a program to solve a Sudoku puzzle by filling the empty cells.

A sudoku solution must satisfy all of the following rules:

Each of the digits 1-9 must occur exactly once in each row.
Each of the digits 1-9 must occur exactly once in each column.
Each of the the digits 1-9 must occur exactly once in each of the 9 3x3 sub-boxes of the grid.
Empty cells are indicated by the character '.'.


A sudoku puzzle...


...and its solution numbers marked in red.

Note:

The given board contain only digits 1-9 and the character '.'.
You may assume that the given Sudoku puzzle will have a single unique solution.
The given board size is always 9x9.*/

class Solution {
    public void solveSudoku(char[][] board) {
        boolean result;
        result = isValidSudokuHelper(board, 0, 0);
        return result;
    }
    public boolean isValidSudokuHelper(char[][] board, int row, int col){
        if(row == board.length && col == board[0].length) return true;
        if(row > board.length - 1 || row < 0 || col > board[0].length || col < 0) return false;
        
        char filledCharacter = board[row][col];
        for(int i = 0; i < board.length; i++){
            if(i != row && board[i][col] == board[row][col]) return false;
        }
        
        for(int i = 0; i < board[0].length; i++){
            if(i != col && board[row][i] == board[row][col]) return false;
        }
        int squareRow = row/3;
        int squareCol = col/3;
        for(int i = squareRow * 3; i <= squareRow + 3;i++){
            for(int j = squareCol * 3; j <= squareCol + 3;j++){
                if((i!=row || j !=col) && (board[i][j] == board[row][col])){
                    return false;
                }
            }
        }
        
        int[] rowDirection = {0, 1, 0, -1};
        int[] colDirection = {1, 0, -1, 0};
        boolean result = false;
        for(char temp = '0'; temp <= '9'; temp++){
            for(int i = 0; i < rowDirection.length; i++){
                result = isValidSudokuHelper(board, row + rowDirection[i], col + colDirection[j]);
                if(result) return true;
            }
        }
        return false;        
    }
}


class Solution {
	int n = 3; 
	int N = n*n;
	int[][] rows = new int[N][N + 1];
	int[][] cols = new int[N][N + 1];
	int[][] boxs = new int[N][N + 1];
	char board[][];
	boolean sudukuSolved = false;
    public void solveSudoku(char[][] board) {
    	this.board = board;
        for(int i = 0; i < N; i++){
        	for(int j = 0; j < N;j++){
        		if(board[i][j] != '.'){
        			int d = Character.getNumericValue(board[i][j]);
        			placeNumber(d, i, j);
        		}
        	}
        }
        backtrack(0,0);
    }
    public void placeNumber(int d, int row, int col){
    	int boxindex = row/n*n + col/n;
    	rows[row][d]++;
    	cols[col][d]++;
    	boxs[boxindex][d]++;
    	board[row][col] = (char)(d + '0');
    }
    public void removeNumber(int d, int row, int col){
    	int boxindex = row/n*n + col/n;
    	rows[row][d]--;
    	cols[col][d]--;
    	boxs[boxindex][d]--;
    	board[row][col] = '.';
    }
    public boolean couldPlace(int d, int row, int col){
    	int idx = (row/n) *n + col/n;
    	return rows[row][d] + columns[col][d] + boxes[idx][d] == 0;
    }
    public void placeNextNumber(int row, int col){
    	if(row == N - 1 && col == N - 1){
    		return true;
    	}else{
    		if(col == N - 1) backtrack(row + 1, 0);
    		else{
    			backtrack(row, col + 1);
    		}
    	}

    }
    public void backtrack(int row, int col){
		if(board[row][col] == '.'){
    	for(int i = 1; i < 10; i++){
    		if(couldPlace(i, row, col)){	    		
	    		placeNumber(i, row, col);
	    		placeNextNumber(row, col);
	    	}
	    	if(!sudukuSolved(row, col)) {
	    		removeNumber(i,row, col);
	    	}
    	}
    	}else{
    		placeNextNumber(row,col);
    	}
    }
}



































