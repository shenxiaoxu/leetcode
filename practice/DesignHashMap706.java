/*706. Design HashMap
Easy

653

88

Add to List

Share
Design a HashMap without using any built-in hash table libraries.

To be specific, your design should include these functions:

put(key, value) : Insert a (key, value) pair into the HashMap. If the value already exists in the HashMap, update the value.
get(key): Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key.
remove(key) : Remove the mapping for the value key if this map contains the mapping for the key.
question:
1.key value is integer or string or support more specific data type
2.does it supported nested data type? for example generic map put(Integer, Pair<Integer, String>) is supported.
3.what's the range of key and value, if it's an integer.
4.how to handle colision, normal hashmap use linkedlist to solve collision if it's hash to the same key.
5.is there any time complexity restrit on any operation of the map, for example get(key) demands O(1) time.
answer
1. let's work on integer first
2. normal integer scope is fine
3. yes, it's inclued nested type e.x. put(Integer, Pair<Integer, Integer>)
4.linkedlist is fine
5. put, get O(1), remove O(n)
design:
LinkedList store it's key,
class ListNode{
	int val;
	ListNode next;
	LinkedList<Integer> content;
}
1.when put key, we hash key with the size of linkedlist. put the key to the end of hash linkedlist
2.when we get key, first we find which column it's belong, then read from start to end to find.
3.when remove key, first we find which column it's belong, then remove it from linkedlist.
test


1). hash function design: the purpose of hash function is to map a key value to an address in the storage space, 
similarly to the system that we assign a postcode to each mail address. As one can image, for a good hash function, 
it should map different keys !!evenly!! across the storage space, so that we don't end up with the case that the majority of the keys are concentrated in a few spaces. 
*/
class ListNode{
	LinkedList<Integer> keys;
	LinkedList<Vector<Integer>> content;
}
class DesignHashMap706{
	LinkedList<ListNode> list;
	int HashSize = 100;
	public Solution(){
		list = new LinkedList<ListNode>(HashSize);
	}
	private int getHashValue(int key){
		return key%HashSize;
	}
	public void put(int key, int value){
		int hashValue = getHashValue(key);
		if(list.get(hashValue).content == null){
			LinkedList<Vector<Integer>> listcontent = new LinkedList<Vector<Integer>>();
			listcontent.add(new Pair<Integer, Integer>(key, value));
			list.get(hashValue).content = listcontent;
		}else{
			LinkedList<Vector<Integer>> listcontent = list.get(hashValue);
			for(int i = 0; i < listcontent.size(); i++){
				if(listcontent.get(i).get(0) == key){
					listcontent.get(i).set(1, value);
				}
			}
			Vector<Integer> v = new Vector(Arrays.asList(key, value));
			listcontent.add(v);
		}
	}
	public int get(int key){
		int hashValue = getHashValue(key);
		if(list.get(hashValue).content == null) return -1;
		else{
			LinkedList<Vector<Integer>> listcontent = list.get(hashValue);
			for(int i = 0; i < listcontent.size(); i++){
				if(listcontent.get(i).get(0) == key){
					return listcontent.get(1);
				}
			}
			return -1;			
		}
	}
	public void remove(int key){
		if(get(key) != -1){
			int hashValue = getHashValue(key);
			if(list.get(hashValue).content == null) return -1;
			else{
				LinkedList<Vector<Integer>> listcontent = list.get(hashValue);
				for(int i = 0; i < listcontent.size(); i++){
					if(listcontent.get(i).get(0) == key){
						listcontent.remove(i);
					}
				}		
			}			
		}
	}
}


class Pair<U, V> {
  public U first;
  public V second;

  public Pair(U first, V second) {
    this.first = first;
    this.second = second;
  }
}


class Bucket {
  private List<Pair<Integer, Integer>> bucket;

  public Bucket() {
    this.bucket = new LinkedList<Pair<Integer, Integer>>();
  }

  public Integer get(Integer key) {
    for (Pair<Integer, Integer> pair : this.bucket) {
      if (pair.first.equals(key))
        return pair.second;
    }
    return -1;
  }

  public void update(Integer key, Integer value) {
    boolean found = false;
    for (Pair<Integer, Integer> pair : this.bucket) {
      if (pair.first.equals(key)) {
        pair.second = value;
        found = true;
      }
    }
    if (!found)
      this.bucket.add(new Pair<Integer, Integer>(key, value));
  }

  public void remove(Integer key) {
    for (Pair<Integer, Integer> pair : this.bucket) {
      if (pair.first.equals(key)) {
        this.bucket.remove(pair);
        break;
      }
    }
  }
}

class MyHashMap {
  private int key_space;
  private List<Bucket> hash_table;

  /** Initialize your data structure here. */
  public MyHashMap() {
    this.key_space = 2069;
    this.hash_table = new ArrayList<Bucket>();
    for (int i = 0; i < this.key_space; ++i) {
      this.hash_table.add(new Bucket());
    }
  }

  /** value will always be non-negative. */
  public void put(int key, int value) {
    int hash_key = key % this.key_space;
    this.hash_table.get(hash_key).update(key, value);
  }

  /**
   * Returns the value to which the specified key is mapped, or -1 if this map contains no mapping
   * for the key
   */
  public int get(int key) {
    int hash_key = key % this.key_space;
    return this.hash_table.get(hash_key).get(key);
  }

  /** Removes the mapping of the specified value key if this map contains a mapping for the key */
  public void remove(int key) {
    int hash_key = key % this.key_space;
    this.hash_table.get(hash_key).remove(key);
  }
}

/**
 * Your MyHashMap object will be instantiated and called as such: MyHashMap obj = new MyHashMap();
 * obj.put(key,value); int param_2 = obj.get(key); obj.remove(key);
 */





















