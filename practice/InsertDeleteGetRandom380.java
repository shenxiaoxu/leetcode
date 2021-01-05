/*380. Insert Delete GetRandom O(1)
Medium

1767

127

Add to List

Share
Design a data structure that supports all following operations in average O(1) time.

insert(val): Inserts an item val to the set if not already present.
remove(val): Removes an item val from the set if present.
getRandom: Returns a random element from current set of elements. Each element must have the same probability of being returned.
Example:

// Init an empty set.
RandomizedSet randomSet = new RandomizedSet();

// Inserts 1 to the set. Returns true as 1 was inserted successfully.
randomSet.insert(1);

// Returns false as 2 does not exist in the set.
randomSet.remove(2);

// Inserts 2 to the set, returns true. Set now contains [1,2].
randomSet.insert(2);

// getRandom should return either 1 or 2 randomly.
randomSet.getRandom();

// Removes 1 from the set, returns true. Set now contains [2].
randomSet.remove(1);

// 2 was already in the set, so return false.
randomSet.insert(2);

// Since 2 is the only number in the set, getRandom always return 2.
randomSet.getRandom();
The idea of GetRandom is to choose a random index and then to retrieve an element with 
that index. There is no indexes in hashmap, and hence to get true random value, 
one has first to convert hashmap keys in a list, that would take linear time. 
The solution here is to build a list of keys aside and to use this list to compute 
GetRandom in constant time.
*/
class RandomizedSet {
	Map<Integer, Integer> dict;
	ArrayList<Integer> list;
	Random rand = new Random();
    /** Initialize your data structure here. */
    public RandomizedSet() {
        dict = new HashMap<Integer, Integer>();
        list = new ArrayList<Integer>();
    }
    
    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if(dict.containsKey(val)) return false;   
        dict.put(val, list.size());
        list.add(list.size(), val);
        return true;
    }
    
    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        if(!dict.containsKey(val)) return false;
        //get index of last element
        int idx = dict.get(val);
        int lastElement = list.get(list.size() - 1);
        list.set(idx, lastElement);
        dict.put(lastElement, idx);
        //remove last element
        list.remove(list.size() - 1);
        dict.remove(val);
    }
    
    /** Get a random element from the set. */
    public int getRandom() {
        return list.get(rand.nextInt(list.size()));
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */