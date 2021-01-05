import java.util.Arrays;
public class ThreeSumClose
{

    public static void main(String[] args)
    {
        int[] array1 = {1,5,8,10,11,40,60};
        int target = 40;
        System.out.println(threeSumClost(array1, target));
    }
    public static int threeSumClost(int[] input, int target)
    {
    	int closet = Integer.MAX_VALUE;
    	Arrays.sort(input);
    	for(int i = 0; i < input.length; i++){
    		int start = i + 1;
    		int end = input.length - 1;
    		while(start < end){
    			int value = input[i] + input[start] + input[end];
    			if(Math.abs(target - value) < closet){
    				closet = Math.abs(target - value);
    			}    			
    			if(value == target){
    				return 0;
    			}
    			if(value < closet){
    				start++;
    			}else if(value > closet){
    				end--;
    			}
    		}
    	}
    	return closet;
    }
}