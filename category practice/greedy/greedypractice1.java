/*
task scheduler, aabbcaaccb, cooldown time is 3, minimal to finish
use greedy, record last time you see the character, if it's longer than cooldown time, we add corresponding time before order, if not, we continue 
map   result a _ _ _ a b _ _ _ b c a _ _ _ a c _ _ _ c b 22.
acbba cooldown is 2, expected is a c b _ _ b a 7.
a 0
c 1
b 2
*/
class Solution{
	public int minimalOrder(char[] tasks, int cooldown){
		HashMap<Character, Integer> map = new HashMap();
		int result = 1;
		for(int i = 0; i < tasks.length; i++){
			char c = tasks[i];
			if(map.containsKey(c)){
				int pre = map.get(c);
				if(i - pre > cooldown){
					result++;				
				}else{
					result += cooldown - (i - pre) + 2;
				}
				map.put(c, i);
			}else{
				map.put(c, i);
				result++;
			}
		}
		return result;
	}
}
/*
find unique numbers
1 1 1 1 1 1 1 1 1 1 2 2 2
0 1 2 3 4 5 6 7 8 9 10 11 12
first round mid = 6
mid = 7+12/2=9
1 2 3
first round mid = 1
*/
class Solution{
	public int uniqueNumber(int[] nums){
		int l = nums.length;
		int lo = 0;
		int hi = l - 1;
		int result = 0;
		while(lo <= hi){
			int mid = lo + (hi - lo)/2;
			if(nums[mid] == nums[lo] && nums[mid] == nums[hi]){
				result++;
				return result;
			}else if(nums[mid] == nums[lo]){
				if(mid + 1 < l && nums[mid] != nums[mid + 1]){
					result++;
					lo = mid + 1;
				}else{
					lo = mid + 1;
				}
			}else if(nums[mid] == nums[hi]){
				if(mid - 1 >= 0 && nums[mid] != nums[mid - 1]){
					result++;
					hi = mid - 1;
				}else{
					hi = mid - 1;
				}
			}else{
				if(hi - 1 >= 0 && nums[hi] != nums[hi - 1]){
					result++;
					hi = hi - 1;
				}else{
					hi = hi - 1;
				}
			}
		}
		return result;
	}
}
//[1 1 1 1 1 1 1 1 1 1 2 2 2 2]
class Solution{
	int GResult = 0;
	public int uniqueNumber(int[] nums){
		boolean skipFirst = false;
		int lo = 0;
		int hi = nums.length - 1;
		recursive(nums, lo, hi, skipFirst);
		return GResult;
	}
	public void recursive(int[] nums, int lo, int hi, boolean skipFirst){
		if(nums[lo] == nums[hi]){
			if(!skipFirst){
				GResult++;
				return;
			}
		}else{
			int mid = lo + (hi - lo)/2;
			recursive(nums, lo, mid, skipFirst);
			recursive(nums, mid + 1, hi, nums[mid] == nums[mid + 1])
		}
	}
}
/*
406. queue reconstruction by height
*/



































































