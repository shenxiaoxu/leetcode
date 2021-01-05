/*
162.find peak element
a peak element is an element that is greater than its neighbors.
input:[1,2,3,1]
out:2
input:[1,2,1,3,5,6,4]
out:1 or 5
your solution should be in logarithmic complexity
*/
class findPeakElement{
	public static void main(String[] args){
		int[] input = {4,3,2,1};
		int[] input2 = {1,2,3,4,5,6};
		System.out.println(findPeakElement(input));
		System.out.println(findPeakElement(input2));
	}
	public static int findPeakElement(int[] array){
		int left = 0;
		int right = array.length - 1;
		while(left < right){
			int mid = left + (right - left)/2;
			if(array[mid]<array[mid+1]){
				left = mid+1;
			}else{
				right = mid;
			}
		}
		return right;
		
	}
}