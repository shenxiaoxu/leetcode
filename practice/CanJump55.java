/*
leetcode 55 given an array of non-negative integers, each element in array represents your max jump, determine if you are able to reach last index
in:[2,3,1,1,4]
out true
in:[3,2,1,0,4]
out:false
*/
class CanJump{
	public static void main(String[] args){
		int[] input1 = {2,3,1,1,4};
		int[] input2 = {3,2,1,0,4};
		System.out.println(canJump(input1,0));
		System.out.println(canJump(input2,0));
	}
	public static boolean canJump(int[] input, int index){
		if(index == input.length -1){
			return true;
		}
		if(index > input.length - 1){
			return false;
		}
		int step = input[index];
		for(int i = 1; i<= step;i++){
			if(canJump(input, index + step)){
				return true;
			}
		}
		return false;
	}
}