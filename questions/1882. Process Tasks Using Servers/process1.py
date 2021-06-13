class Solution:
    def assignTasks(self, servers: List[int], tasks: List[int]) -> List[int]:
        q = []
        q1 = []
        for i, c in enumerate(servers):
            heapq.heappush(q, (c, i, 0))
        
        ans = []
        heapq.heapify(q)
        for idx, task in enumerate(tasks):
            #print(q)
            while q1 and idx >= q1[0][0] or not q:
                t, c, i = heapq.heappop(q1)
                heapq.heappush(q,(c,i,t))
            c,i,t = heapq.heappop(q)
            #print(t,c,i)
            ans.append(i)
            heapq.heappush(q1, (max(t,idx) + task, c, i))
        
        return ans