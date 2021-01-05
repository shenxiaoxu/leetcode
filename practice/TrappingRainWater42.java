/*42. Trapping Rain Water
Hard

5633

105

Add to List

Share
Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it is able to trap after raining.


The above elevation map is represented by array [0,1,0,2,1,0,1,3,2,1,2,1]. In this case, 6 units of rain water (blue section) are being trapped. Thanks Marcos for contributing this image!

Example:

Input: [0,1,0,2,1,0,1,3,2,1,2,1]
Output: 6
Accepted
430,524
Submissions
919,993
*/
class Solution {
    public int trap(int[] height) {
        int current = 0;
        int ans = 0;
        Stack<Integer> stack = new Stack<Integer>();
        while(current < height.length){
        	while(!stack.empty() && height[current] > height[stack.top()]){
        		int top = stack.pop();
        		if(stack.empty()){
        			break;
        		}
        		int d = current - stack.top() - 1;
        		int h = Math.min(height[stack.top()], height[current]) - height[top];
        		ans += d*h;
        	}
        	stack.push(current++);
        }
        return ans;
    }
    public int trap(int[] height){
    	int left = 0;
    	int right = height.length - 1;
    	int leftMax = 0;
    	int rightMax = 0;
    	int ans = 0;
    	while(left < right){
    		if(height[left] < height[right]){
    			if(height[left] >= leftMax){leftMax = height[left];}else{ans += (leftMax - height[left]);};
    			left++;
    		}else{
    			if(height[right] >= rightMax){rightMax = height[right];}else{ans += (rightMax - height[right]);}
    			right--;
    		}
    	}
    	return ans;
    }
}







