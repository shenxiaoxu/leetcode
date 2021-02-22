'''
Design a queue-like data structure that moves the most recently used element to the end of the queue.

Implement the MRUQueue class:

MRUQueue(int n) constructs the MRUQueue with n elements: [1,2,3,...,n].
fetch(int k) moves the kth element (1-indexed) to the end of the queue and returns it.
'''
class MRUQueue:

    def __init__(self, N: int):
        global n, buckets, sz
        n = N
        sz = isqrt(n)
        buckets = defaultdict(deque)
        for i in range(n):
            buckets[i//sz].append(i + 1)

    def fetch(self, k: int) -> int:
        global buckets, sz, n
        
        k -= 1
        
        hi = n //sz
        lo,loidx = divmod(k, sz)
        
        v = buckets[lo][loidx]
        del buckets[lo][loidx]
        
        buckets[hi].append(v)
        
        for i in range(lo, hi):
            val = buckets[i + 1].popleft()
            buckets[i].append(val)
        return v


# Your MRUQueue object will be instantiated and called as such:
# obj = MRUQueue(n)
# param_1 = obj.fetch(k)