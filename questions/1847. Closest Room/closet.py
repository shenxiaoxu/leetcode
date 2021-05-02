'''
There is a hotel with n rooms. The rooms are represented by a 2D integer array rooms where rooms[i] = [roomIdi, sizei] denotes that there is a room with room number roomIdi and size equal to sizei. Each roomIdi is guaranteed to be unique.

You are also given k queries in a 2D array queries where queries[j] = [preferredj, minSizej]. The answer to the jth query is the room number id of a room such that:

The room has a size of at least minSizej, and
abs(id - preferredj) is minimized, where abs(x) is the absolute value of x.
If there is a tie in the absolute difference, then use the room with the smallest such id. If there is no such room, the answer is -1.

Return an array answer of length k where answer[j] contains the answer to the jth query.
'''
class Solution:
    def closestRoom(self, rooms: List[List[int]], queries: List[List[int]]) -> List[int]:
        rooms_sort = sorted(rooms, key = lambda x: x[1])
        res = [0]*len(queries)
        #print(rooms_sort)
        def binary_search(rooms_sort, num):
            lo = 0
            hi = len(rooms_sort)
            while lo < hi:
                mid = lo + (hi - lo)//2
                if rooms_sort[mid][1] < num:
                    lo = mid + 1
                else:
                    hi = mid
            return lo
        for i, query in enumerate(queries):
            idx = binary_search(rooms_sort, query[1])
            #print(idx)
            room_id = -1
            min_diff = float('inf')
            
            for r in range(idx, len(rooms_sort)):
                if abs(rooms_sort[r][0] - query[0]) <= min_diff:
                    if min_diff == abs(rooms_sort[r][0] - query[0]) and room_id != -1:
                        room_id = min(room_id, rooms_sort[r][0])
                    else:
                        min_diff = abs(rooms_sort[r][0] - query[0]) 
                        room_id = rooms_sort[r][0]
            res[i] = room_id
        return res