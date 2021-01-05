/*class Solution {
    public int findMinDifference(List<String> timePoints) {
        List<Integer>[] buckets = new List<Integer>[24];//get 24 bucket;
        List<Integer> hourExist = new ArrayList<Integer>();
        int minimum = 0;
        for(String point: timePoints){
            String[] time = point.split("\\:");
            int hour = Integer.valueOf(time[0]);
            if(!hourExist.contains(hour)){ 
                buckets[hour] = new ArrayList<Integer>();
                hourExist.add(hour);
            }
            int minute = Integer.valueOf(time[1]);
            buckets[hour].add(minute);
        }
        Collections.sort(hourExist);//sort hour exist 
        for(int i = 0; i < hourExist.size(); i++){
            List<Integer> bucket = buckets[hourExist.get(i)];
            Collections.sort(bucket);//make minutes sorted
            if(bucket.size() != 1){ 
                for(int j = 0; j < bucket.size() - 1; j++){
                    minimum = Math.min(minimum, bucket.get(j + 1) - bucket.get(j));//compare bucket sort.
                }
            }//compare element in the bucket.
            int tail = bucket.get(bucket.size() - 1);//get each bucket last minute
            int head = i== hourExist.size() - 1?buckets[hourExist.get(0)].get(0): buckets[hourExist.get(i + 1)].get(0);//get next bucket first minute.
            int gapHour = i == hourExist.size() - 1? 24-hourExist.get(i) + hourExist.get(0) - 1:hourExist.get(i + 1) - hourExist.get(i) - 1;
            System.out.println(tail + " " + head + " " + gapHour);
            minimum = Math.min(minimum, gapHour* 60 + 60-tail+head);//compare each bucket head and tail.
        }
        return minimum;
    }
}*/

import java.util.*;
class TimeDifference539{
    public static void main(String[] args){
        TimeDifference539 object = new TimeDifference539();
        LinkedList<String> timepoints = new LinkedList<String>();
        timepoints.add("00:00");
        timepoints.add("19:59");
        timepoints.add("01:35");
        timepoints.add("05:40");
        System.out.println(object.findMinDifference(timepoints));
    }
    public int findMinDifference(List<String> timePoints) {
        List<Integer>[] buckets = new LinkedList[24];//get 24 bucket;
        List<Integer> hourExist = new ArrayList<Integer>();
        int minimum = Integer.MAX_VALUE;
        for(String point: timePoints){
            String[] time = point.split("\\:");
            int hour = Integer.valueOf(time[0]);
            //System.out.println(hour);
            if(!hourExist.contains(hour)){ 
                buckets[hour] = new LinkedList<Integer>();
                hourExist.add(hour);
            }
            int minute = Integer.valueOf(time[1]);
            buckets[hour].add(minute);
        }
        Collections.sort(hourExist);//sort hour exist 
        //System.out.println(hourExist.size());
        for(int i = 0; i < hourExist.size(); i++){
            List<Integer> bucket = buckets[hourExist.get(i)];
            Collections.sort(bucket);//make minutes sorted
            if(bucket.size() != 1){ 
                for(int j = 0; j < bucket.size() - 1; j++){
                    minimum = Math.min(minimum, bucket.get(j + 1) - bucket.get(j));//compare bucket sort.
                }
            }//compare element in the bucket.
            int tail = bucket.get(bucket.size() - 1);//get each bucket last minute
            int head = i== hourExist.size() - 1?buckets[hourExist.get(0)].get(0): buckets[hourExist.get(i + 1)].get(0);//get next bucket first minute.
            int gapHour = i == hourExist.size() - 1? 24-hourExist.get(i) + hourExist.get(0) - 1:hourExist.get(i + 1) - hourExist.get(i) - 1;
            System.out.println(tail + " " + head + " " + gapHour);
            minimum = Math.min(minimum, gapHour* 60 + 60-tail+head);//compare each bucket head and tail.
        }
        return minimum;
    }
}