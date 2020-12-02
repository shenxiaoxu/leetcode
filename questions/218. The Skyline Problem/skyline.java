import java.util.*;
class Solution{
	public List<List<Integer>> getSkyLine(List<List<Integer>> buildings){
		List<int[]> events = new ArrayList();
		List<List<Integer>> res = new ArrayList();
		for(List<Integer> list: buildings){
			events.add(new int[]{list.get(0), -list.get(2)});
			events.add(new int[]{list.get(1), list.get(2)});
		}
		Collections.sort(events,(a,b)->a[0]-b[0]);
		int cur= 0, pre = 0;
		PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)->b.compareTo(a));
		for(int[] e: events){
			if(e[1] < 0){
				pq.add(-e[1]);
			}else{
				pq.remove(new Integer(e[1]));
			}
			cur = pq.peek();
			if(cur != pre){
				pre = cur;
				res.add(Arrays.asList(e[0],cur));
			}
		}
		return res;
	}
}
