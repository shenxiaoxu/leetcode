/*
146.lru cache
design and implement a data structure for least recently used cache, get and put
get(key) get the value of the key if key exists in the cache,otherwise return -1;
put(key,value) set or insert the value if the key is not already present. when the cache reached its capacity, 
it should invalidate the least recently used item before inserting a new iteam.
do it in o1 time complexity.
LRUCache cache = new LRUCache(2);
cache.put(1,1);
cache.put(2,2);
cache.get(1);
cache.put(3,3);
cache.get(2);
cache.put(4,4);
cache.get(1);
cache.get(3);
cache.get(4);
*/
import java.util.*;
class LRUCache{
	int capacity;
	LinkedList<Integer> keys;
	HashMap<Integer,Integer> map;
	public LRUCache(int capacity){
		this.capacity = capacity;
		keys = new LinkedList<Integer>();
		map = new HashMap<Integer,Integer>();
	}
	public int get(int key){
		if(map.containsKey(key)){
			int result = map.get(key);
			if(keys.indexOf(key) != -1){
				int index = keys.indexOf(key);
				keys.remove(index);
				keys.addFirst(key);
			}
			return result;
		}else{
			return -1;
		}
	}
	public void put(int key, int value){
		int leastValue;
		if(map.size() + 1 > capacity){
			leastValue = keys.pollLast();
			map.remove(leastValue);
		}
		keys.addFirst(key);
		map.put(key, value);
	}
	public static void main(String[] args){
		LRUCache cache = new LRUCache(2);
		cache.put(1,1);
		cache.put(2,2);
		System.out.println(cache.get(1));
		cache.put(3,3);
		System.out.println(cache.get(2));
		cache.put(4,4);
		System.out.println(cache.get(1));
		System.out.println(cache.get(3));
		System.out.println(cache.get(4));		
	}
}