/*341. Flatten Nested List Iterator
Medium

1414

587

Add to List

Share
Given a nested list of integers, implement an iterator to flatten it.

Each element is either an integer, or a list -- whose elements may also be integers or other lists.

Example 1:

Input: [[1,1],2,[1,1]]
Output: [1,1,2,1,1]
Explanation: By calling next repeatedly until hasNext returns false, 
             the order of elements returned by next should be: [1,1,2,1,1].
Example 2:

Input: [1,[4,[6]]]
Output: [1,4,6]
Explanation: By calling next repeatedly until hasNext returns false, 
             the order of elements returned by next should be: [1,4,6].
*/

/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return null if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */
public class NestedIterator implements Iterator<Integer> {
	List<NestedInteger> list;
	List<NestedInteger> current;
	Stack<NestedInteger> stack;
    public NestedIterator(List<NestedInteger> nestedList) {
        this.list = nestedList;
        this.current = list;
    }

    @Override
    public Integer next() {
        int size = list.size();
        for(int i = 0; i < size; i++){
        	NestedInteger n = list.get(i);
        	while(!n.isInteger()){
        		current = n;
        		List<NestedInteger> list = n.getList();
        		n = list.get(0);
        	}
        	int result = n.getInteger();
        	current.remove(0);
        	return result;
        }
    }

    @Override
    public boolean hasNext() {
        return list.isEmpty();
    }
}

/**
 * Your NestedIterator object will be instantiated and called as such:
 * NestedIterator i = new NestedIterator(nestedList);
 * while (i.hasNext()) v[f()] = i.next();
 */

