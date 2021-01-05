/*57. Insert Interval

Given a set of non-overlapping intervals, insert a new interval into the intervals (merge if necessary).

You may assume that the intervals were initially sorted according to their start times.

Example 1:

Input: intervals = [[1,3],[6,9]], newInterval = [2,5]
Output: [[1,5],[6,9]]
Example 2:

Input: intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]], newInterval = [4,8]
Output: [[1,2],[3,10],[12,16]]
Explanation: Because the new interval [4,8] overlaps with [3,5],[6,7],[8,10].
NOTE: input types have been changed on April 15, 2019. Please reset to default code definition to get new method signature.
*/
import java.util.*;
class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        //init data
        LinkedList<int[]> output = new LinkedList<int[]>();
        int idx = 0;
        int n = intervals.length;
        int newStart = newInterval[0];
        int newEnd = newInterval[1];

        //add all interval that smaller than new start to output
        while(idx < n && newStart > intervals[idx][0]){
        	output.add(intervals[idx++]);
        }
        int[] interval = new int[2];//get before update in order to debug.
        //add new interval
        if(output.isEmpty() || output.getLast()[1] < newStart){
        	output.add(newInterval);
        }else{
        	interval = output.removeLast();
        	interval[1] = Math.max(interval[1], newEnd);
        	output.add(interval);
        }

        //merge remaining interval
        while(idx < n){
        	interval = intervals[idx++];
        	int start = interval[0];
        	int end = interval[1];
        	//no overlap
        	if(start > output.getLast()[1]){
        		output.add(interval);
        	}else{
        		interval = output.removeLast();
        		interval[1] = Math.max(interval[1], end);
        		output.add(interval);
        	}
        }
        return output.toArray(new int[output.size()][2]);
    }
}