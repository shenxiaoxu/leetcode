import java.util.LinkedList;
public class BinarySearchArray
{

    public static void main(String[] args)
    {
        int[] array1 = {1,5,8,10,11,40,60};
        System.out.println(binarySearchArray(array1,40,0,array1.length - 1));
    }
    public static int binarySearchArray(int[] input, int target, int low, int upper)
    {
    	int result;
    	int pivot = (low + upper)/2;
    	if(input[pivot] == target || input[upper] == target || input[low] == target){
    		return 1;
    	}
    	if(pivot == low || pivot == upper){
    		return 0;
    	}
    	if(target < input[pivot]){
    		result = binarySearchArray(input,target,low,pivot);
    		return result;
    	}else{
    		result = binarySearchArray(input,target,pivot,upper);
    		return result;
    	}  
    }
}