/*
79. Word Search

Given a 2D board and a word, find if the word exists in the grid.

The word can be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those horizontally or vertically neighboring. The same letter cell may not be used more than once.

Example:

board =
[
  ['A','B','C','E'],
  ['S','F','C','S'],
  ['A','D','E','E']
]

Given word = "ABCCED", return true.
Given word = "SEE", return true.
Given word = "ABCB", return false.
*/

class Solution {
    public boolean exist(char[][] board, String word) {
        boolean[][] visited = new boolean[board.length][board[0].length];
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                if(board[i][j] == word.charAt(0)){
                    boolean result = existRec(i, j, 0, visited, board, word);
                    if(result){
                        return true;
                    }
                }
            }
        }
        return false;
    }
    
    public boolean existRec(int i, int j, int index, boolean visited[][],char[][] board, String word){
        if(index == word.length()){
            return true;
        }        
        if(i<0 || i> board.length - 1) return false;
        if(j<0 || j> board[0].length - 1) return false;
        if(word.charAt(index) != board[i][j]) return false;
        if(visited[i][j] == true) return false;
        int[] rowOffset = {0,1,0,-1};
        int[] colOffset = {-1,0,1,0};
        for(int d = 0; d< 4;d++){
            visited[i][j] = true;
            boolean result = existRec(i + rowOffset[d], j + colOffset[d], index + 1, visited, board, word);
            if(result) return true;
            visited[i][j] = false;
        } 
        return false;               
    }
}