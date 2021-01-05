/*
253. Meeting Rooms II

Given an array of meeting time intervals consisting of start and end times [[s1,e1],[s2,e2],...] (si < ei), find the minimum number of conference rooms required.

Example 1:

Input: [[0, 30],[5, 10],[15, 20]]
Output: 2
Example 2:

Input: [[7,10],[2,4]]
Output: 1
NOTE: input types have been changed on April 15, 2019. Please reset to default code definition to get new method signature.
attention: no understand the underlying.

*/
import java.util.*;
class MeetingRoomsII253 {
	public static void main(String[] args){
		int[][] intervals = {{7,10},{2,4}};
		MeetingRoomsII253 object = new MeetingRoomsII253();
		System.out.println(object.minMeetingRooms(intervals));
	}
    public int minMeetingRooms(int[][] intervals) {
        if(intervals == null || intervals.length == 0) return 0;
        int result = 0;
        int[] start = new int[intervals.length];
        int[] end = new int[intervals.length];
        int index = 0;
        int endPoint = 0;
        for(int[] interval: intervals){
        	start[index] = interval[0];
        	end[index] = interval[1];
        	index++;
        }
        Arrays.sort(start);
        Arrays.sort(end);
        for(int i = 0; i < start.length;i++){
        	if(start[i] < end[endPoint]) result++;
        	else endPoint++;
        }
        return result;
    }
}