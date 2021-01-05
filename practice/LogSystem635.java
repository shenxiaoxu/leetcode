/*
635. design log storage system
you are given several logs that each log contains a unique id and timestamp, timestamp is a string  has format
year:month:day:hour:minute:second, for example
2017:01:01:23:59:59, all domains are zero-padded decimal number
design log storage system to implement functions:
void put(int id, string timestamp) given log's unique id and timestamp, store log in storage system
int[] retrieve(string start, string end, string granularity) return id of logs whose timestamp within range from start to end. start = "2017:01:01:23:59:59", end = "2017:01:02:23:59:59", granularity = "day"

put(1, "2017:01:01:23:59:59");
put(2, "2017:01:01:22:59:59");
put(3, "2016:01:01:00:00:00");
retrieve("2016:01:01:01:01:01","2017:01:01:23:00:00","Year"); // return [1,2,3], because you need to return all logs within 2016 and 2017.
retrieve("2016:01:01:01:01:01","2017:01:01:23:00:00","Hour"); // return [1,2], because you need to return all logs start from 2016:01:01:01 to 2017:01:01:23, where log 3 is left outside the range.
*/
import java.util.*;
class LogSystem{
	public static void main(String[] args){
		LogSystem log = new LogSystem();
		log.put(1, "2017:01:01:23:59:59");
		log.put(2, "2017:01:01:22:59:59");
		log.put(3, "2016:01:01:00:00:00");
		System.out.println(log.retrieve("2016:01:01:01:01:01","2017:01:01:23:00:00","Year"));
		System.out.println(log.retrieve("2016:01:01:01:01:01","2017:01:01:23:00:00","Hour"));
	}
	public LogSystem(){
		this.hashmap = new HashMap<Integer, String>();
	}
	public int put(int id, String time){
		hashmap.put(id, time);
		return 1;
	}
	public Vector<Integer> retrieve(String startime, String endtime, String granularity){
		Vector<Integer> result = new Vector<Integer>();
		String startyear = startime.substring(0,4);
		String startmonth = startime.substring(5,7);
		String startday = startime.substring(8,10);
		String starthour = startime.substring(11,13);
		String startminute = startime.substring(14,16);
		String startsecond = startime.substring(17,19);
		String endyear = endtime.substring(0,4);
		String endmonth = endtime.substring(5,7);
		String endday = endtime.substring(8,10);
		String endhour = endtime.substring(11,13);
		String endminute = endtime.substring(14,16);
		String endsecond = endtime.substring(17,19);
		if(granularity == "Year"){
			hashmap.forEach((key, value)->{
				int eachstringyear = Integer.parseInt(value.substring(0,4));
				if(eachstringyear >= Integer.parseInt(startyear) && eachstringyear <= Integer.parseInt(endyear)){
					result.add(key);
				}
			});
		}
		return result;
	}
	HashMap<Integer, String> hashmap;
}

