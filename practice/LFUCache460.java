/*460. LFU Cache
Hard

1131

106

Add to List

Share
Design and implement a data structure for Least Frequently Used (LFU) cache. It should support the following operations: get and put.

get(key) - Get the value (will always be positive) of the key if the key exists in the cache, otherwise return -1.
put(key, value) - Set or insert the value if the key is not already present. When the cache reaches its capacity, it should invalidate the least frequently used item
 before inserting a new item. For the purpose of this problem, when there is a tie (i.e., two or more keys that have the same frequency), 
 the least recently used key would be evicted.

Note that the number of times an item is used is the number of calls to the get and put functions for that item since it was inserted. This number is set to zero when the item is removed.
Example:

LFUCache cache = new LFUCache( 2 /* capacity */ );
/*
cache.put(1, 1);
cache.put(2, 2);
cache.get(1);       // returns 1
cache.put(3, 3);    // evicts key 2
cache.get(2);       // returns -1 (not found)
cache.get(3);       // returns 3.
cache.put(4, 4);    // evicts key 1.
cache.get(1);       // returns -1 (not found)
cache.get(3);       // returns 3
cache.get(4);       // returns 4
 

Follow up:
Could you do both operations in O(1) time complexity?
*/

class ListNode{
	int val;
	int key;
	ListNode pre;
	ListNode nex;
	public ListNode(int key, int val){
		this.val = val;
		this.key = key;
	}
}
class LFUCache {
	ListNode head;
	ListNode tail;
	int capacity;
	HashMap<Integer, ListNode> map;
    public LFUCache(int capacity) {
        head = new ListNode(-1);
        tail = new ListNode(-1);
        capacity = capacity;
        map = new HashMap<Integer, ListNode>();
    }
    private ListNode delete(int key){
    	ListNode idx = map.get(key);
    	ListNode pre = idx.pre;
    	ListNode nxt = pre.next;
    	pre.next = nxt;
    	nxt.pre = pre;
    	map.remove(key);
    	return idx;
    }
    private void moveToHead(int key){
    	ListNode cur = delete(key);
    	ListNode nxt = head.next;
    	head.next = cur;
    	cur.next = nxt;
    }
    private ListNode deleteTail(){
    	ListNode cur = tail.pre;
    	ListNode pre = cur.pre;
    	pre.next = tail;
    	tail.pre = pre;
    	return cur;
    }
    public int get(int key) {
        if(!map.containsKey(key)) return -1;
        ListNode cur = delete(key);
        moveToHead(key);
        return cur.val;
    }
    
    public void put(int key, int value) {
        if(map.containsKey(key)){
        	delete(key);
        }
        ListNode cur = new ListNode(key, val);
        if(map.size() + 1 <= capacity){
        	map.put(key, cur);
        	ListNode nxt = head.next;
        	head.next = cur;
        	cur.next = nxt;
        }else{
        	int remove = deleteTail().key;
        	map.remove(key);
        	map.put(key, cur);
        	ListNode nxt = head.next;
        	head.next = cur;
        	cur.next = nxt;        		
        }        
    }
}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */