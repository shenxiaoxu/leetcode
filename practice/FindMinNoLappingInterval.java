import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
public class FindMinNoLappingInterval
{

    public static void main(String[] args)
    {
        ArrayList<Interval> intervals = new ArrayList<Interval>();
        Interval interval1 = new Interval(1,2);
        Interval interval2 = new Interval(1,3);
        Interval interval3 = new Interval(1,4);
        Interval interval4 = new Interval(2,3);
        Interval interval5 = new Interval(3,4);
        intervals.add(interval1);
        intervals.add(interval2);
        intervals.add(interval3);
        intervals.add(interval4);
        intervals.add(interval5);
        Collections.sort(intervals, new sortInterval());
        //for(int i = 0; i < intervals.size();i++){
        //    Interval inter = intervals.get(i);
        System.out.println(findMinNoLappingInterval(intervals));
        //}
    }
    public static int findMinNoLappingInterval(ArrayList<Interval> intervals){
       Collections.sort(intervals, new sortInterval());
       int number = 0;
       for(int i = 0; i < intervals.size(); i++){
            int j = i;
            int minEnd = intervals.get(i).end;
            while(j + 1 < intervals.size() && minEnd > intervals.get(j + 1).start){
                number++;
                j++;
                i = j + 1;
            }
       }
       return number; 
    }
    static class sortInterval implements Comparator{
        public int compare(Object interval1, Object interval2){
            Interval i1 = (Interval) interval1;
            Interval i2 = (Interval) interval2;
            if(i1.start > i2.start){
                return 1;
            }else if(i1.start == i2.start){
                if(i1.end > i2.end){
                    return 1;
                }else{
                    return -1;
                }
            }else{
                return -1;
            }
        }
    }
}