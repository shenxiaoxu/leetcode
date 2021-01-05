/*
48.rotate  image
you are given an n*n matrix, rotate image by 90 degree(clockwise)
rotate image in-place, modify input directly
in
[
	[1,2,3],
	[4,5,6],
	[7,8,9]
]
out
[
	[7,4,1],
	[8,5,2],
	[9,6,3]
]

in
[
	[5,1,9,11],
	[2,4,8,10],
	[13,3,6,7],
	[15,14,12,16]
]
out
[
	[15,13,2,5],
	[14,3,4,1],
	[12,6,8,9],
	[16,7,10,11]
]
k,i --> i , lenght - 1 - k
i, length - 1 -k ---> length - 1 - k, length - 1 - i
length - 1 - k, length - 1 - i --->i,k
i,k ---> k, length - 1 - i 
*/

class Rotate{
	public static void main(String[] args){
		int[][] input = {{5,1,9,11},{2,4,8,10},{13,3,6,7},{15,14,12,16}};
		int length = input.length;
		for(int k = 0; k < input.length/2 ; k++){
			for(int i = k; i < input[0].length - 1 - k; i++){
				int temp = input[k][i];
				input[k][i] = input[length - 1 - i][k];
				input[length - 1 - i][k] = input[length - 1 - k][length - 1 - i];
				input[length - 1 - k][length - 1 - i] = input[i][length - 1 - k];
				input[i][length - 1 - k] = temp;
			}
		}
		for(int i =0; i < input.length; i++){
			for(int j = 0; j< input[0].length;j++){
				System.out.println(input[i][j]);
			}
		}
	}
}