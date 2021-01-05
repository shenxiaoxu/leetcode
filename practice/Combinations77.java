/*77. Combinations

Given two integers n and k, return all possible combinations of k numbers out of 1 ... n.

Example:

Input: n = 4, k = 2
Output:
[
  [2,4],
  [3,4],
  [2,3],
  [1,2],
  [1,3],
  [1,4],
]
attention: backtracking.
*/
class Solution {
    int k;
    int n;
    LinkedList<LinkedList<Integer>> result = new List<>();
    public List<List<Integer>> combine(int n, int k) {
        this.n = n;
        this.k = k;        
        combineHelper(new LinkedList<Integer>(),1);
        return result;
    }
    public void combineHelper(LinkedList<Integer> current, int index){
        if(current.size() == k){
            result.add(new LinkedList<Integer>(current));
        }
        for(int i = index; i < n + 1; i++){
            current.add(index);
            combineHelper(current, index + 1);
            current.remove(current.size() - 1);
        }      
    }
}