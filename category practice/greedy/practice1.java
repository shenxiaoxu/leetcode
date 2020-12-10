/*
binary tree column wise print
	   1
   2      3
3     4 5     6

0 1 4 5
-1 2
1 3
-2 3
2 6

*/
class Solution{
	class Point{
		int x;
		int y;
		TreeNode value;
		public Point(int x, int y, TreeNode value){
			this.x = x;
			this.y = y;
			this.value = value;
		}
	}
	public List<Integer> columnPrint(TreeNode root){
		List<Integer> result = new ArrayList();
		HashMap<Integer, List<Integer>> map = new HashMap();
		if(root == null) return result;
		Queue<Point> queue = new LinkedList();
		Point p = new Point(0,0,root);
		queue.offer(p);
		int min = 0;
		int max = 0;
		while(!queue.isEmpty()){
			int size = queue.size();
			for(int i = 0; i < size; i++){
				Point node = queue.poll();
				int col = node.y;
				TreeNode val = node.value;
				List<Integer> list = new LinkedList();
				if(!map.containsKey(col)){
					map.put(col, list);
				}else{
					list = map.get(col);
				}
				list.add(val.value);
				map.put(col, list);
				min = Math.min(col, min);
				max = Math.max(col, max);
				if(node.value.left != null){
					queue.add(new Point(node.x + 1, col - 1, node.value.left));
				}
				if(node.value.right != null){
					queue.add(new Point(node.x + 1, col + 1, node.value.right));
				}
			}
		}
		for(int i = min; i <= max; i++){
			List<Integer> list = map.get(i);
			result.addAll(list);
		}
		return result;
	}
}
/*
find unique element
1 1 1 2 2 3 3
[1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 2 2 2 2 2 3 3 3 3 ]
*/
class Solution{
	public int uniqueArray(int[] nums){
		int l = nums.length;
		int lo = 0;
		int hi = l - 1;
		int result = 0;
		while(lo < hi){
			int mid = lo + (hi - lo)/2;
			if(nums[mid] == nums[lo]){
				result++;
				int val = nums[lo];
				while(result == val){
					
				}
			}else{
				lo = mid + 1;
			}
			if(nums[mid] == nums[hi]){
				result++;
			}else{
				hi = mid - 1;
			}
		}
		return result;
	}
}

















































