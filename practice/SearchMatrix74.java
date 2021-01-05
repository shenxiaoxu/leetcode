/*
74.search a 2d matrix
algorithm that searches for a value in mn matrix, 
integers in each row are sorted from left to right.
first integer of each row is greater thatn the last integer of previous row.
matrix=[
[1,3,5,7],
[10,11,16,20],
[23,30,34,50]
]
target = 3
true
matrix = [
[1,3,5,7],
[10,11,16,20],
[23,30,34,50]
]
*/
class SearchMatrix{
	public static void main(String[] args){
		int[][] matrix ={{1,3,5,7},{10,11,16,20},{23,30,34,50}};
		int target = 50;
		System.out.println(searchMatrix(matrix, target));
	}
	public static boolean searchMatrix(int[][] matrix, int target){
		int[] result = new int[matrix.length];
		for(int i = 0; i < matrix.length; i++){
			result[i] = matrix[i][0] ;
		}
		if(target < matrix[0][0])
			return false;
		if(target > matrix[matrix.length - 1][matrix[0].length - 1])
			return false;
		int index = binarySearchRange(result, target, 0, result.length - 1);
		if(target > matrix[matrix.length - 1][0])
			index = matrix.length - 1;
		System.out.println("index" + index);
		int[] result2 = new int[matrix[0].length];
		for(int i = 0; i < result2.length; i++){
			result2[i] = matrix[index][i];
			System.out.println(result2[i]);
		}
		return binarySearch(result2, target, 0, result2.length - 1);

	}
	public static boolean binarySearch(int[] array, int target, int start, int end){
		if(start > end){
			return false;
		}
		int pivot = (start + end)/2;
		if(array[pivot] == target){
			return true;
		}
		if(array[pivot] < target){
			return binarySearch(array, target, pivot + 1, end);
		}else{
			return binarySearch(array, target, start, pivot - 1);
		}
	}
	public static int binarySearchRange(int[] array, int target, int start, int end){
		if(start > end){
			return 0;
		}
		int pivot = (start + end)/2;
		if(pivot + 1 < array.length && array[pivot + 1] > target && array[pivot] < target){
			return pivot;
		}
		if(array[pivot] < target){
			return binarySearchRange(array, target, pivot + 1, end);
		}else{
			return binarySearchRange(array, target, start, pivot - 1);
		}
	}	
}