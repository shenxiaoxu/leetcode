/*56. Merge Intervals

Given a collection of intervals, merge all overlapping intervals.

Example 1:

Input: [[1,3],[2,6],[8,10],[15,18]]
Output: [[1,6],[8,10],[15,18]]
Explanation: Since intervals [1,3] and [2,6] overlaps, merge them into [1,6].
Example 2:

Input: [[1,4],[4,5]]
Output: [[1,5]]
Explanation: Intervals [1,4] and [4,5] are considered overlapping.
NOTE: input types have been changed on April 15, 2019. Please reset to default code definition to get new method signature.
attention:
know how to write comparator
linkedlist to array, array to linkedlist
*/
import java.util.*;
class Solution {
	private class InternalComparator implements Comparator<int[]>{
		public int compare(int[] a, int[] b){
			return a[0] < b[0] ? -1 : a[0] == b[0]? 0 : 1; 
		}
	}
    public int[][] merge(int[][] intervals) {
        
        Collections.sort(Arrays.asList(intervals), new InternalComparator());

        LinkedList<int[]> mergedList = new LinkedList<>();
        for(int[] interval: intervals){
        	if(mergedList.isEmpty() || interval[0] > mergedList.getLast()[1]){
        		mergedList.add(interval);
        	}else{
        		mergedList.getLast()[1] = Math.max(interval[1], mergedList.getLast()[1]);
        	}
        }
        return mergedList.toArray(new int[mergedList.size()][]);
    }
}