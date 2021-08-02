'''
There is a party where n friends numbered from 0 to n - 1 are attending. There is an infinite number of chairs in this party that are numbered from 0 to infinity. When a friend arrives at the party, they sit on the unoccupied chair with the smallest number.

For example, if chairs 0, 1, and 5 are occupied when a friend comes, they will sit on chair number 2.
When a friend leaves the party, their chair becomes unoccupied at the moment they leave. If another friend arrives at that same moment, they can sit in that chair.

You are given a 0-indexed 2D integer array times where times[i] = [arrivali, leavingi], indicating the arrival and leaving times of the ith friend respectively, and an integer targetFriend. All arrival times are distinct.

Return the chair number that the friend numbered targetFriend will sit on.
'''
class Solution:
    def smallestChair(self, times: List[List[int]], targetFriend: int) -> int:
        q = []
        f = times[targetFriend][0]
        times.sort()
        seat = []
        n = 0
        
        for t in times:
            cur = 0
            while q and q[0][0] <= t[0]:
                o = heapq.heappop(q)
                seat.append(o[1])
                seat.sort()
            if seat:
                cur = seat[0]
                seat = seat[1:]
            else:
                cur = n
                n += 1
            heapq.heappush(q, [t[1], cur])
            if f == t[0]:
                return cur
        return 0