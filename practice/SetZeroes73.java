/*
73.set matrix zeroes
given a mn matrix, if an element is 0, set entire row and column to 0. do it in-place
[
[1,1,1],
[1,0,1],
[1,1,1]
]
out:
[
[1,0,1],
[0,0,0],
[1,0,1]
]
*/
class SetZeroes{
	public static void main(String[] args){
		int[][] array = {{1,1,1},{1,1,1},{1,0,1}};
		setZeroes(array);
		for(int i = 0; i < array.length; i++){
			for(int j = 0; j < array[0].length; j++){
				System.out.println(array[i][j]);
			}
		}		
	}
	public static void setZeroes(int[][] array){
		for(int i = 0; i < array.length; i++){
			for(int j = 0; j < array[0].length; j++){
				if(array[i][j] == 0){
					array[0][j] = 0;
					array[i][0] = 0;
				}
			}
		}	
		for(int i = 0; i < array.length; i++){
			if(array[i][0] == 0){
				for(int j = 0; j < array[0].length; j++){
					array[i][j] = 0;
				}
			}
		}
		for(int i = 0; i < array[0].length; i++){
			if(array[0][i] == 0){
				for(int j = 0; j < array.length; j++){
					array[j][i] = 0;
				}
			}
		}

	}
}