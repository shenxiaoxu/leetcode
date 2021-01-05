/*
84. Largest Rectangle in Histogram

Given n non-negative integers representing the histogram's bar height where the width of each bar is 1, find the area of largest rectangle in the histogram.

Above is a histogram where width of each bar is 1, given height = [2,1,5,6,2,3].

The largest rectangle is shown in the shaded area, which has area = 10 unit.
Example:

Input: [2,1,5,6,2,3]
Output: 10
solution:

keep record of elements that smaller than current height until when find element that smaller than the nearest element,
then for the height, we konw leftside and rightside, which is sub-dynamic.
remember at the end of list, we kick out all the element in the stack.
*/
import java.util.*;
class Solution {
    public int largestRectangleArea(int[] heights) {
        Stack<Integer> stack = new Stack<Integer>();
        stack.add(-1);
        int result = 0;
        for(int i = 0; i < heights.length; i++){
        	while(stack.peek() != -1 && heights[i] < heights[stack.peek()]){
        		result = Math.max(result, heights[stack.pop()] * (i - stack.peek() - 1));
        	}
        	stack.add(i);
        }
        while(stack.peek() != -1){
        	result = Math.max(result, heights[stack.pop()] * (heights.length - stack.peek() - 1));
        }
        return result;
    }
}