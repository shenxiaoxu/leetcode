/*
56.merge intervals
given a collection of intervals, merge all overlapping intervals
in:[[1,3],[2,6],[8,10],[15,18]]
out:[[1,6],[8,10],[15,18]]
in:[[1,4],[4,5]]
out:[[1,5]]
sort intervals as following rules
ascending order according to first element, 
if first element is same ,
ascending order second element,
compare two element second and first, if reverse, merge
*/
import java.util.*;
class Merge{
	public static List<List<Integer>> merge(List<List<Integer>> input){
		int firstIndex = 0;
		int secondIndex = 1;
		List<List<Integer>> result = new ArrayList<>();
		Collections.sort(input, new Comparator<List<Integer>>(){
			public int compare(List<Integer> o1, List<Integer> o2){
				if(o1.get(firstIndex) > o2.get(firstIndex)){
					return 1;
				}else if(o1.get(firstIndex) < o2.get(firstIndex)){
					return -1;
				}else{
					return (o1.get(secondIndex)>o2.get(secondIndex))? 1: -1;
				}
			}
		});
		//System.out.println(input);
		int index = 0;
		for(int i = 0; i < input.size() - 1; i++){
			index = i + 1;
			List<Integer> current = input.get(i);
			List<Integer> next = input.get(i + 1);
			int minimum = current.get(firstIndex);;
			int maximum = current.get(secondIndex);
			while((i < input.size()) && maximum >= next.get(firstIndex)){
				maximum = next.get(secondIndex);
				i++;
				if(i + 1< input.size())
				{
					next = input.get(i + 1);
				}else{
					i = input.size()-1;
					index = i + 1;
					break;
				}
			}

			List<Integer> temp = new ArrayList<>();
			temp.add(minimum);
			temp.add(maximum);
			result.add(temp);

		}
		if(index == input.size() - 1){
			result.add(input.get(index));
		}

		return result;
	}
	public static void main(String[] args){
		List<List<Integer>> list = new ArrayList<>();
		List<Integer> temp1 = new ArrayList<>();
		List<Integer> temp2 = new ArrayList<>();
		List<Integer> temp3 = new ArrayList<>();
		List<Integer> temp4 = new ArrayList<>();
		temp1.add(1);
		temp1.add(2);
		temp2.add(2);
		temp2.add(6);
		temp3.add(6);
		temp3.add(10);
		temp4.add(10);
		temp4.add(18);
		list.add(temp1);
		list.add(temp2);
		list.add(temp3);
		list.add(temp4);
		System.out.println(merge(list));
	}	
}