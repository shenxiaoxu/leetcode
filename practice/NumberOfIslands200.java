import java.util.ArrayList;
public class NumberOfIslands
{
    public static void main(String[] args){
    	int[][] array = {{1,1,1,1,0},{1,1,0,1,0},{1,1,0,0,0},{1,1,0,0,0},{0,0,0,0,0}};
        System.out.println(numberIslands(array));
    }
    public static int numberIslands(int[][] array){ 
        int number = 0;
        int[][] markedArray = new int[array.length][array[0].length];
        for(int i = 0; i < array.length;i++){
            for(int j = 0; j < array[0].length;j++){
                markedArray[i][j] = 0;
            }
        }
    	for(int i = 0; i < array.length;i++){
            for(int j = 0; j < array[0].length;j++){
                if(markedArray[i][j] == 0 && array[i][j] == 1){
                    number++;
                    recurringMark(array,markedArray,i,j); 
                }
            }
        }
        return number;        
    }
    public static void recurringMark(int[][] array, int[][] markedArray, int i, int j){
        if(i > array[0].length - 1|| i < 0 || j < 0 || j > array.length - 1 || array[i][j] == 0 || markedArray[i][j] == 1){
            return;
        }
        markedArray[i][j] = 1;
        recurringMark(array, markedArray, i + 1, j);
        recurringMark(array, markedArray, i - 1, j);
        recurringMark(array, markedArray, i, j + 1);
        recurringMark(array, markedArray, i, j - 1);
    }
}  