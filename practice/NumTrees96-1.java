/*96. Unique Binary Search Trees

Given n, how many structurally unique BST's (binary search trees) that store values 1 ... n?

Example:

Input: 3
Output: 5
Explanation:
Given n = 3, there are a total of 5 unique BST's:

   1         3     3      2      1
    \       /     /      / \      \
     3     2     1      1   3      2
    /     /       \                 \
   2     1         2                 3

G(i) is total binary search tree from lenght 1-n
F(i,n) is total bianry search tree if i is the root;
G(0) = 1;
G(1) = 1;
F(j - 1, n) * F(i - j, n)  j from 1 to i , sum them up with j is the root.
*/

class NumTrees96{
    public int numTrees(int n) {
        int[] nums = new int[n + 1];
        nums[0] = 1;
        nums[1] = 1;
        for(int i = 2; i <=n; i++){
        	for(int j = 1; j <=i; j++){
        		nums[i] += nums[j - 1] * nums[i - j];
        	}
        }
    	return nums[n];
    }
}
