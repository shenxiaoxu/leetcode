'''
There is a 3 lane road of length n that consists of n + 1 points labeled from 0 to n. A frog starts at point 0 in the second lane and wants to jump to point n. However, there could be obstacles along the way.

You are given an array obstacles of length n + 1 where each obstacles[i] (ranging from 0 to 3) describes an obstacle on the lane obstacles[i] at point i. If obstacles[i] == 0, there are no obstacles at point i. There will be at most one obstacle in the 3 lanes at each point.

For example, if obstacles[2] == 1, then there is an obstacle on lane 1 at point 2.
The frog can only travel from point i to point i + 1 on the same lane if there is not an obstacle on the lane at point i + 1. To avoid obstacles, the frog can also perform a side jump to jump to another lane (even if they are not adjacent) at the same point if there is no obstacle on the new lane.

For example, the frog can jump from lane 3 at point 3 to lane 1 at point 3.
Return the minimum number of side jumps the frog needs to reach any lane at point n starting from lane 2 at point 0.

Note: There will be no obstacles on points 0 and n.
'''
class Solution:
    def minSideJumps(self, obstacles: List[int]) -> int:
        queue = collections.deque()
        queue.append([2,0]) #second line, 0 cross step
        res, col = float('inf'), 0
        n = len(obstacles) - 1
        while col != n:
            num_iter = len(queue)
            for _ in range(num_iter):
                row, step = queue.popleft()
                for i in range(-2,3):
                    nr = row + i
                    if nr < 1 or nr > 3 or obstacles[col] == nr: continue
                    if nr == row and obstacles[col + 1] != nr:
                        queue.append([nr, step])                   
                    if obstacles[col + 1] != nr and nr != row:
                        queue.append([nr, step + 1])                   
            col += 1
        while queue:
            res = min(res, queue.pop()[1])
        return res
                    