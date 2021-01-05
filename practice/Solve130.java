/*
130.surrounded regions
given a 2d board containing x and o, capture all regions surrounded by x
xxxx
xoox
xxox
xoxx

-->
xxxx
xxxx
xxxx
xoxx
*/
class Solve{
	public static void main(String[] args){
		char[][] board = {{'x','x','x','x'},{'x','o','o','x'},{'x','x','o','x'},{'x','o','x','x'}};
		int[][] marked = {{0,0,0,0},{0,0,0,0},{0,0,0,0},{0,0,0,0}};
		for(int i = 0; i < board.length; i++){
	    	for(int j = 0; j < board[0].length; j++){
	    		if(board[i][j] == 'o'){
					solve(board, i,j, marked);
				}
			}
		}
		for(int i = 0; i < board.length; i++){
	    	for(int j = 0; j < board[0].length; j++){
	    		
				System.out.print(board[i][j] + " ");	
			}
			System.out.println();
		}				
	}
	public static int solve(char[][] board, int horital, int vertical, int[][] marked){
	   	if(horital < 0 || horital >= board.length || vertical < 0 || vertical >= board[0].length){
	    	return 1;
	    }
	    if(marked[horital][vertical] == 1){
	    	return 0;
	    }
	    if(board[horital][vertical] == 'x'){
	    	return 0;
	    }


		int element1 = 0;
		int element2 = 0;
		int element3 = 0;
		int element4 = 0;
		marked[horital][vertical] = 1;
		board[horital][vertical] = 'x';
		System.out.println("horital: " + horital + "vertical: " + vertical);
		element1 = solve(board, horital + 1, vertical, marked);
		element2 = solve(board, horital, vertical + 1, marked);
		element3 = solve(board, horital - 1, vertical, marked);
		element4 = solve(board, horital, vertical - 1, marked);
		if(element1 == 1 || element2 == 1 || element3 == 1 || element4 == 1){
			marked[horital][vertical] = 0;
			board[horital][vertical] = 'o';
			return 1;
		}
		return 0;
	}

}