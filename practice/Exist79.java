/*
79.word search
given a 2d board and a word, find if the word exists in the grid.
board
[
[a,b,c,e]
[s,f,c,s]
[a,d,e,e]
]
abcced return true
see return true
abcb return false
*/
class Exist{
	public static void main(String[] args){
		String target = "abcced";
		String target1 = "see";
		String target2 = "abcb";
		char[][] board = {{'a','b','c','e'},{'s','f','c','s'},{'a','d','e','e'}};
		System.out.println(board(board, target2));
	}
	public static boolean board(char[][] board, String target){
		int[][] markedArray = new int[board.length][board[0].length];
		for(int i = 0; i < board.length; i++){
			for(int j = 0; j < board[0].length;j++){
				markedArray[i][j] = 0;
			}
		}
		for(int i = 0; i < board.length; i++){
			for(int j = 0; j < board[0].length; j++){
				if(board[i][j] == target.charAt(0)){
					if(exist(board, target, 0, i, j, markedArray)){
						return true;
					}
				}		
			}
		}
		return false;		
	}
	public static boolean exist(char[][] board, String target, int index, int horital, int vertical, int[][] markedArray){
		if(horital < 0 || vertical < 0 || horital >= board.length || vertical >= board[0].length){
			return false;
		}
		if(markedArray[horital][vertical] == 1 ){
			return false;
		}
		if(board[horital][vertical] != target.charAt(index)){
			return false;
		}
		if(index == target.length() - 1){
			return true;
		}
		boolean result1 = false;
		boolean result2 = false;
		boolean result3 = false;
		boolean result4 = false;
		if(board[horital][vertical] == target.charAt(index)){
			markedArray[horital][vertical] = 1;
			result1 =  exist(board, target, index + 1, horital + 1, vertical, markedArray);
			result2 =  exist(board, target, index + 1, horital, vertical + 1, markedArray);
			result3 =  exist(board, target, index + 1, horital - 1, vertical, markedArray);
			result4 =  exist(board, target, index + 1, horital, vertical - 1, markedArray);
			markedArray[horital][vertical] = 0;			
		}

		return result1 || result2 || result3 || result4;
	}
}