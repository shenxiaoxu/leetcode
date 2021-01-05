/*11.Container with Most Water
given n non-negaive integers a1,a2,....,an, where each represents a point at coordinate(i,ai).n vertical lines are drawn such that
the two endpoints of line i is at(i,ai) and (i, 0).find two lines, which together with x form a container,
find two lines, which together with x forms a container, container contains most water.
input:[1,8,6,2,5,4,8,3,7]
output:49
solution:
maxcapacity(i,j)reprents from i to j, most water.
capacity(i,j) (j-i)*min(a[i],a[j])
maxcapacity(i,j) 0<i<j<input.length()
if(a[i] > a[j]){
	maxcapacity = max(capacity(i,j),maxcapacity(i, j - 1))
}else if(a[i] < a[j]){
	maxcapacity = max(capacity(i,j),maxcapacity(i + 1, j))
}else{
	maxcapacity = max(capacity(i,j),maxcapacity(i + 1, j - 1))
}
*/

class MaxArea{
	public static void main(String[] args){
		int[] input = {1,8,6,2,5,4,8,3,7};
		System.out.println(maxArea(input));
	}
	public static int maxArea(int[] input){
		return maxAreaRecuring(input, 0, input.length - 1);		
	}
	public static int maxAreaRecuring(int[] input, int i, int j){
		int sub = 0;
		int result = 0;
		if(i > j){
			return 0;
		}
		if(input[i] > input[j]){
			sub = maxAreaRecuring(input, i, j - 1);
		}else if(input[i] < input[j]){
			sub = maxAreaRecuring(input, i + 1, j);
		}else{
			sub = maxAreaRecuring(input, i + 1, j - 1);
		}
		result =  Math.max((j-i)*Math.min(input[i], input[j]), sub);
		return result;
	}
}
