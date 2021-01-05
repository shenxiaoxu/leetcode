/*986. Interval List Intersections
Medium

780

29

Add to List

Share
Given two lists of closed intervals, each list of intervals is pairwise disjoint and in sorted order.

Return the intersection of these two interval lists.

(Formally, a closed interval [a, b] (with a <= b) denotes the set of real numbers x with a <= x <= b.  The intersection of two closed intervals is a set of real numbers that is either empty, or can be represented as a closed interval.  For example, the intersection of [1, 3] and [2, 4] is [2, 3].)

 

Example 1:



Input: A = [[0,2],[5,10],[13,23],[24,25]], B = [[1,5],[8,12],[15,24],[25,26]]
Output: [[1,2],[5,5],[8,10],[15,23],[24,24],[25,25]]
Reminder: The inputs and the desired output are lists of Interval objects, and not arrays or lists.
 

Note:

0 <= A.length < 1000
0 <= B.length < 1000
0 <= A[i].start, A[i].end, B[i].start, B[i].end < 10^9
NOTE: input types have been changed on April 15, 2019. Please reset to default code definition to get new method signature.*/
class Solution {
    public int[][] intervalIntersection(int[][] A, int[][] B) {
        int pA = 0;
        int pB = 0;
        List<List<Integer>> result = new ArrayList();
        while(pA < A.length && pB < B.length){
        	int[] curA = A[pA];
        	int[] curB = B[pB];
        	int small = 0, large = 0;
        	if(curA[0] > curB[1]) pB++; continue;
        	if(curA[1] < curB[0]) pA++; continue;
        	if(curA[1] > curB[1] && curA[0] < curB[1]){
        		small = curA[0];
        		large = curB[1];
        		pB++;
        		A[pA][0] = large;
        	}else if(curA[0] < curB[0] && curA[1] > curB[1]){
        		small = curB[0];
        		large = curB[1];
        		pB++;
        		A[pA][0] = large;
        	}else if(curB[0] > curA[0] && curB[1] > curA[1]){
        		small = curB[0];
        		large = curA[1];
        		pA++;
        		B[pB][0] = large;
        	}
        	List<Integer> temp = new ArrayList();
        	temp.add(small);
        	temp.add(large);
        	resutl.add(temp);
        }

    }
}