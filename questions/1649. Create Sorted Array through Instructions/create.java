/*Given an integer array instructions, you are asked to create a sorted array from the elements in instructions. You start with an empty container nums.
 For each element from left to right in instructions, insert it into nums. The cost of each insertion is the minimum of the following:

The number of elements currently in nums that are strictly less than instructions[i].
The number of elements currently in nums that are strictly greater than instructions[i].
For example, if inserting element 3 into nums = [1,2,3,5], the cost of insertion is min(2, 1) (elements 1 and 2 are less than 3, 
element 5 is greater than 3) and nums will become [1,2,3,3,5].

Return the total cost to insert all elements from instructions into nums. Since the answer may be large, return it modulo 109 + 7

*/
class Solution {
    public int createSortedArray(int[] A) {
        int res = 0;
        int[] c = new int[100001];
        int mod = (int)1e9 + 7;
        for(int i = 0; i < A.length; i++){
            res = (res + Math.min(get(c, A[i] - 1), i - get(c, A[i])))%mod;
            update(c, A[i]);
        }
        return res;
    }
    private int get(int[] c, int num){
        int res = 0, x = num;
        while(x > 0){
            res += c[x];
            x -= x&(-x);
        }
        return res;
    }
    private void update(int[] c, int num){
        int x = num;
        while(x < 100001){
            c[x] += 1;
            x += x&(-x);
        }
    }
}