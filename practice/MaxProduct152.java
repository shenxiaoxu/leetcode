/*
152.maximum product subarray
given an integer arraynums, find contiguous subarray within array which has largest product.
in:[2,3,-2,4]
out:6
in:[-2,0,-1]
out:0
*/
class MaxProduct{
	public static void main(String[] args){
		int[] array1 = {2,3,-2,4};
		int[] array2 = {-2,0,-1};
		System.out.println(maxProduct(array1, 0, array1.length-1, Integer.MIN_VALUE));
		System.out.println(maxProduct(array2, 0, array2.length-1, Integer.MIN_VALUE));
	}
	public static int maxProduct(int[] array, int start, int end, int maximum){
		if(start > end){
			return maximum;
		}
		int result = 1;
		int result1;
		int result2;
		for(int i = start; i <=end; i++){
			result = result * array[i];
		}
		if(result > maximum){
			maximum = result;
			System.out.println("maximum: " + maximum);
		}
		result1 = maxProduct(array, start + 1, end, maximum);
		result2 = maxProduct(array, start, end - 1, maximum);
		return Math.max(result1, result2);
	}
}