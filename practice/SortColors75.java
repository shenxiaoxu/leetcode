/*
75.merge sort,one-pass using only constant space.
in[2,0,2,1,1,0]
out[0,0,1,1,2,2]
do it inplace and use new array, mergesort
insert sort
*/
class SortColors{
	public static void main(String[] args){
		int[] input = {2,0,8,1,1,0};
		sortColors(input,0,input.length - 1);
		for(int i = 0; i < input.length; i++){
			System.out.println(input[i]);
		}
	}
	public static void sortColors(int[] input, int start, int end){
		if(start >= end){
			return;
		}
		int pivot = (start + end)/2;
		sortColors(input, start, pivot);
		sortColors(input, pivot + 1, end);
		mergesort(input, start, pivot, end);
	}
	public static void mergesort(int[] input, int start, int pivot, int end){
		System.out.println("start:" + start + "pivot:" + pivot + "end:" + end);
		int[] sub1 = new int[pivot - start + 1];
		int[] sub2 = new int[end - pivot];
		int[] result = new int[end - start + 1];
		for(int i = 0; i < pivot - start + 1;i++){
			sub1[i] = input[start + i];
		}
		for(int j = 0; j < end - pivot;j++){
			sub2[j] = input[pivot + 1 + j];
		}
		int index1 = 0;
		int index2 = 0;
		int index3 = 0;
		while((index1 != sub1.length) && (index2 != sub2.length)){
			if(sub1[index1] < sub2[index2]){
				result[index3] = sub1[index1];
				index1++;
			}else{
				result[index3] = sub2[index2];
				index2++;
			}
			index3++;
		}
		if(index1 == sub1.length){
			while(index2 != sub2.length){
				result[index3] = sub2[index2];
				index3++;
				index2++;
			}				
		}
		if(index2 == sub2.length){
			while(index1 != sub1.length){
				result[index3] = sub1[index1];
				index3++;
				index1++;
			}				
		}
		for(int i = 0; i < result.length; i++){
			input[start + i] = result[i];
			//System.out.print("input:index" + (start + i) + "result:" + input[start + i]);
		}
	}
}