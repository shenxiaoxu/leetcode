/*952. Largest Component Size by Common Factor
Given a non-empty array of unique positive integers A, consider the following graph:

There are A.length nodes, labelled A[0] to A[A.length - 1];
There is an edge between A[i] and A[j] if and only if A[i] and A[j] share a common factor greater than 1.
Return the size of the largest connected component in the graph.

 

Example 1:

Input: [4,6,15,35]
Output: 4

Example 2:

Input: [20,50,9,63]
Output: 2

Example 3:

Input: [2,3,6,7,4,12,21,39]
Output: 8

Note:

1 <= A.length <= 20000
1 <= A[i] <= 100000
*/
import java.util.*;
class LargestComponentCommonFactor952{
	public static void main(String[] args){
		int[] array1 = {4,6,15,35};
		int[] array2 = {20,50,9,63};
		int[] array3 = {2,3,6,7,4,12,21,39};
		int[] array5 = {66,100,37,40,41,76,49,62};
		int[] array4 = {84,171,548,709,455,967,328,779,79,16,168,675,276,473,697,26,731,668,634,607};
		LargestComponentCommonFactor952 object = new LargestComponentCommonFactor952();
		//System.out.println(object.LargestComponentCommonFactorSolution2(array1));
		//System.out.println(object.LargestComponentCommonFactorSolution2(array2));
		//System.out.println(object.LargestComponentCommonFactorSolution2(array3));
		System.out.println(object.LargestComponentCommonFactorSolution2(array5));
	}
	public int LargestComponentCommonFactorSolution1(int[] array){
		Arrays.sort(array);
		int result = Integer.MIN_VALUE;
		Map<Integer, Vector<Integer>> map = new HashMap<Integer, Vector<Integer>>();
		for(int i = 0; i < array.length;i++){
			if(!map.containsKey(array[i])){
				Vector<Integer> commonFactor = new Vector<Integer>();
				for(int j = 0; j < array.length; j++){
					if(i == j) continue;
					if(isCommonFactor(array[i], array[j])){
						commonFactor.add(array[j]);
					}
				}
				map.put(array[i], commonFactor);
				//System.out.println("key:" + array[i] + "value" + commonFactor);
			}
		}

		Set<Map.Entry<Integer, Vector<Integer>>> setmap = map.entrySet();
		Iterator<Map.Entry<Integer,Vector<Integer>>> iterator = setmap.iterator();

		while(iterator.hasNext()){
			Vector<Integer> tempResult = new Vector<Integer>();
			Map.Entry<Integer, Vector<Integer>> entry = iterator.next();
			tempResult.add(entry.getKey());
			Vector<Integer> iteValue = entry.getValue();
			if(iteValue.size() < result) continue;
			LinkedList<Integer> queue = new LinkedList<Integer>();
			for(Integer i: iteValue){
				if(!tempResult.contains(i)){
					tempResult.add(i);

				}
				queue.addFirst(i);
				while(queue.size() != 0){
					int temp = queue.pollLast();
					if(map.containsKey(temp)){
						for(Integer j : map.get(temp)){
							if(!tempResult.contains(j)){
								tempResult.add(j);
								queue.addFirst(j);
							}
						}
					}
				}
			}
			System.out.println(tempResult);
			result = Math.max(tempResult.size(), result);
		}
		return result;
	}
	public boolean isCommonFactor(int number1, int number2){
		
		for(int i = 2;i<=Math.min(number2, number1);i++){
			if(number1%i==0 && number2%i ==0){
				return true;
			}
		}
		return false;
	}
	public int LargestComponentCommonFactorSolution2(int[] array){
		ArrayList<Integer>[] list = new ArrayList[array.length];
		for(int i = 0; i < array.length; i++){
			list[i] = new ArrayList<Integer>();
			int x = array[i];
			int d = 2;
			while(d*d <= x){
				if(x%d == 0){
					while(x%d == 0){
						x = x/d;
					list[i].add(d);					
				}
				d++;
			}
			if(x > 1 || list[i].isEmpty()){
				list[i].add(x);
			}
			//System.out.println(list[i]);
		}
		Set<Integer> factored = new HashSet<Integer>();
		for(int i = 0; i < list.length;i++){
			for(int j : list[i]){
				factored.add(j);
			}
		}
		Map<Integer, Integer> factorIndex = new HashMap<Integer, Integer>();
		int index = 0;
		for(int i:factored){
			factorIndex.put(i,index);
			//System.out.println("factor:" + i + "index" + index);
			index++;
		}
		UnionFind uf = new UnionFind(factored.size());
		for(int i = 0; i < list.length;i++){
			for(int j:list[i]){
				int x = factorIndex.get(list[i].get(0));
				int y = factorIndex.get(j);
				System.out.println("x:" + x + "y" + y);
				uf.union(x,y);
			}
		}
		int[] count = new int[factored.size()];

		for(int i = 0; i < list.length; i++){
			int x = uf.find(factorIndex.get(list[i].get(0)));
			//System.out.println("x:" + x );
			count[x]++;
		}
		int ans = 0;
		for(int i = 0; i < count.length;i++){
			if(count[i] > ans){
				ans = count[i];
			}
		}
		return ans;
	}
	
}
class UnionFind{
	int[] parents;
	public UnionFind(int x){
		parents = new int[x];
		for(int i = 0; i < x;i++){
			parents[i] = i;
		}
	}
	public void union(int a, int b){
		parents[find(a)] = find(b);
	}
	public int find(int a){
		if(parents[a] != a) parents[a] = find(parents[a]);
		return parents[a];
	}
}













