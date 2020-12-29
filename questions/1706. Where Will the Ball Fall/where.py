'''
You have a 2-D grid of size m x n representing a box, and you have n balls. The box is open on the top and bottom sides.

Each cell in the box has a diagonal board spanning two corners of the cell that can redirect a ball to the right or to the left.

A board that redirects the ball to the right spans the top-left corner to the bottom-right corner and is represented in the grid as 1.
A board that redirects the ball to the left spans the top-right corner to the bottom-left corner and is represented in the grid as -1.
We drop one ball at the top of each column of the box. Each ball can get stuck in the box or fall out of the bottom. 
A ball gets stuck if it hits a "V" shaped pattern between two boards or if a board redirects the ball into either wall of the box.

Return an array answer of size n where answer[i] is the column that the ball falls out of at the bottom after dropping the ball 
from the ith column at the top, or -1 if the ball gets stuck in the box.
'''
import collections
from typing import List
class Solution:
	def balls(self, grid:List[List[int]])->List[int]:
		if not len(grid):
			return None
		m, n = len(grid), len(grid[0])
		res = [-1]*n
		q = collections.deque()
		for i in range(n):
			q.append([0,i,i])  #row/column where ball is at now and number of ball
		for i in range(m):
			for j in range(n):
				while q and i == q[0][0] and j == q[0][1]:
					if grid[i][j] == 1 and j + 1 < n and grid[i][j + 1] == 1:
						q.append([i + 1, j + 1, q[0][2]])
					elif grid[i][j] == -1 and j - 1 >= 0 and grid[i][j - 1] == -1:
						q.append([i + 1, j - 1, q[0][2]])
					q.popleft()
		while q:
			ball = q.popleft()
			res[ball[2]] = ball[1]
		return res
if __name__ == "__main__":
	grid = [[1,1,1,-1,-1],[1,1,1,-1,-1],[-1,-1,-1,1,1],[1,1,1,1,-1],[-1,-1,-1,-1,-1]]
	o = Solution()
	print(o.balls(grid))	
	grid = [[1,1,1,-1,-1],[1,1,1,1,-1],[-1,-1,-1,1,1],[1,1,1,-1,-1],[-1,-1,-1,-1,-1]]
	print(o.balls(grid))
	grid = [[-1]]
	print(o.balls(grid))

