
	
	/*leetcode 963. given a set of points in xy, determine the minimum area of any rectangle  with sides not necessarily parallel to x and y
	 if there isn't any rectangle,return 0;
Given a set of points in the xy-plane, determine the minimum area of any rectangle formed from these points, with sides not necessarily parallel to the x and y axes.

If there isn't any rectangle, return 0. 

Example 1:

Input: [[1,2],[2,1],[1,0],[0,1]]
Output: 2.00000
Explanation: The minimum area rectangle occurs at [1,2],[2,1],[1,0],[0,1], with an area of 2.
Example 2:



Input: [[0,1],[2,1],[1,1],[1,0],[2,0]]
Output: 1.00000
Explanation: The minimum area rectangle occurs at [1,0],[1,1],[2,1],[2,0], with an area of 1.
Example 3:



Input: [[0,3],[1,2],[3,1],[1,3],[2,1]]
Output: 0
Explanation: There is no possible rectangle to form from these points.
Example 4:



Input: [[3,1],[1,1],[0,1],[2,1],[3,3],[3,2],[0,2],[2,3]]
Output: 2.00000
Explanation: The minimum area rectangle occurs at [2,1],[2,3],[3,3],[3,1], with an area of 2.
 

Note:

1 <= points.length <= 50
0 <= points[i][0] <= 40000
0 <= points[i][1] <= 40000
All points are distinct.
Answers within 10^-5 of the actual value will be accepted as correct.	 
	 *refactor
	 *
	 *
	 *
	 */
import java.util.*;
public class minAreaFreeReact963 {
	public static void main(String[] args){
		int[][] points = {{0,1},{2,1},{1,1},{1,0},{2,0}};
		System.out.println(minAreaFreeReach(points));
		//System.out.println("hello word");
	}
	public static double minAreaFreeReach(int[][] points){
		double result = Double.MIN_VALUE;
		Map<Double, Vector<Vector<Integer>>> slidemap = new HashMap<Double, Vector<Vector<Integer>>>();
		for(int i = 0; i < points.length;i++){
			for(int j = 0; j < points.length;j++){
				if(i == j) continue;
				double slidevalue;
				if(points[j][0] - points[i][0]==0) slidevalue = Double.MAX_VALUE;
				else slidevalue = (points[j][1] - points[i][1])/(points[j][0]-points[i][0]);
				Vector<Integer> temp = new Vector<Integer>();
				Vector<Integer> temp1 = new Vector<Integer>();
				temp.add(points[i][0]);
				temp.add(points[i][1]);
				temp1.add(points[j][0]);
				temp1.add(points[j][1]);
				if(!slidemap.containsKey(slidevalue)){
					Vector<Vector<Integer>> mapvalue = new Vector<Vector<Integer>>();
					mapvalue.add(temp);
					mapvalue.add(temp1);
					slidemap.put(slidevalue, mapvalue);
				}else{				
					slidemap.get(slidevalue).add(temp);
					slidemap.get(slidevalue).add(temp1);
				}
			}
		}
		Iterator<Map.Entry<Double, Vector<Vector<Integer>>>> entries = slidemap.entrySet().iterator();
		while(entries.hasNext()){
			Map.Entry<Double, Vector<Vector<Integer>>> entry = entries.next();
			Vector<Vector<Integer>> results = entry.getValue();
			double sideA = entry.getKey();
			if(results.size() % 2 != 0){
				System.out.println("size is not correct");
			}else{
				for(int i = 0; i < results.size(); i=i+2){
					for(int j = 0; j < results.size(); j=j+2){
						if(i == j) continue;
						double sideB;
						if(results.get(j).get(0)-results.get(i).get(0) == 0) sideB = Double.MAX_VALUE;
						else sideB = (results.get(j).get(1)-results.get(i).get(1))/(results.get(j).get(0)-results.get(i).get(0));
						double lengthA = Math.sqrt(Math.pow((results.get(j).get(0)-results.get(i).get(0)),2) 
								+ Math.pow((results.get(j).get(1)-results.get(i).get(1)),2));
						double lengthB = Math.sqrt(Math.pow((results.get(i+1).get(0)-results.get(i).get(0)),2) 
								+ Math.pow((results.get(i+1).get(1)-results.get(i).get(1)),2));
						System.out.println("lengthA:" + lengthA + "lengthB:" + lengthB);
						System.out.println("sideA:" + sideA + "sideB:" + sideB);
						if(sideB * sideA == -1 || (sideB == Double.MAX_VALUE && sideA == 0) || (sideA == Double.MAX_VALUE && sideB == 0)){
							result = Math.max(lengthA*lengthB, result);
						}
					}
				}
			}
		}
		return result;
	}
}
