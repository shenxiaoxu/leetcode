/*347. Top K Frequent Elements
Medium

2447

167

Add to List

Share
Given a non-empty array of integers, return the k most frequent elements.
question:
1.is there any constraint of size of array, because maybe array length is super big, but k is very small or the other way around.
2. is k always valid, for example k is bigger than array or small than array.
3. can this array be online, it's a stream array, key input integer or size fixed.
4.frequent means time of integer most present in array, not how many times we acess array for that element?
5. for the return, is it has order?
design:
priorityqueue, in java is a heap, put always long(n), get is O(1) constant time. nlog(k) is time complexity
*/
class TopKFrequentElements347{
	public List<Integer> getFrequentElement(int[] array, int k){
		HashMap<Integer> map = new HashMap<Integer>();
		PriorityQueue<Pair<Integer,Integer>> queue = new PriorityQueue<Integer>(new Comparator<Pair<Integer,Integer>>(){

		});
	}
}