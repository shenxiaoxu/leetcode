/*252. Meeting Rooms

Given an array of meeting time intervals consisting of start and end times [[s1,e1],[s2,e2],...] (si < ei), determine if a person could attend all meetings.

Example 1:

Input: [[0,30],[5,10],[15,20]]
Output: false
Example 2:

Input: [[7,10],[2,4]]
Output: true
NOTE: input types have been changed on April 15, 2019. Please reset to default code definition to get new method signature.
*/
import java.util.*;
class MeetingRooms252 {
	public static void main(String[] args){
		int[][] intervals = {{7,10},{2,4}};
		MeetingRooms252 object = new MeetingRooms252();
		System.out.println(object.canAttendMeetings(intervals));
	}
    public boolean canAttendMeetings(int[][] intervals) {
        if(intervals == null || intervals.length == 0) return true;
        int[] start = new int[intervals.length];
        int[] end = new int[intervals.length];
        int index = 0;
        for(int[] interval: intervals){
        	start[index] = interval[0];
        	end[index] = interval[1];
        	index++;
        }
        Arrays.sort(start);
        Arrays.sort(end);
        for(int i = 1; i < start.length;i++){
        	if(start[i] < end[i - 1]) return false;
        }
        return true;
    }
}