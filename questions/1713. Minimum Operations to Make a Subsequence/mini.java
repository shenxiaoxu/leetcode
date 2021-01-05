/*
You are given an array target that consists of distinct integers and another integer array arr that can have duplicates.

In one operation, you can insert any integer at any position in arr. For example, if arr = [1,4,1,2], 
you can add 3 in the middle and make it [1,4,3,1,2]. Note that you can insert the integer at the very beginning or end of the array.

Return the minimum number of operations needed to make target a subsequence of arr.

A subsequence of an array is a new array generated from the original array by deleting some elements (possibly none) without 
changing the remaining elements' relative order. For example, [2,7,4] is a subsequence of [4,2,3,7,2,1,4] (the underlined elements), while [2,4,2] is not.
*/
class Solution{
	public int minOperations(int[] target, int[] arr){
		HashMap<Integer, Integer> map = new HashMap();
		for(int i = 0; i < target.length; i++){
			map.put(target[i], i);
		}
		ArrayList<Integer> stack = new ArrayList();
		for(int num: arr){
			if(!map.containsKey(num)){
				continue;
			}
			if(stack.size() == 0 || map.get(num) > stack.get(stack.size() - 1)){
				stack.add(map.get(num));
				continue;
			}
			int left = 0, right = stack.size() - 1, mid;
			while(left < right){
				mid = left + (right - left)/2;
				if(stack.get(mid) < map.get(num)){
					left = mid + 1;
				}else{
					right = mid;
				}
			}
			stack.set(left, map.get(num));
		}
		return target.length - stack.size();
	}
}