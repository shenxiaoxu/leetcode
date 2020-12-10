'''
378. Kth Smallest Element in a Sorted Matrix
Given a n x n matrix where each of the rows and columns are sorted in ascending order, find the kth smallest element in the matrix.

Note that it is the kth smallest element in the sorted order, not the kth distinct element.

Example:

matrix = [
   [ 1,  5,  9],
   [10, 11, 13],
   [12, 13, 15]
],
k = 8,

return 13.
Note:
You may assume k is always valid, 1 ≤ k ≤ n2.
'''
import heapq
class Solution:
	def smallest(self, matrix: list[list[int]], k: int)-> int:
		q, count = [], 0
		for i in range(min(k, len(matrix))):
			heapq.heappush(q, (matrix[i][0], i, 0))
		while len(q):
			num, row, col = heapq.heappop(q)
			#print((num, row, col))
			count += 1
			if count == k:
				return num
			if col < len(matrix[row]) - 1:
				heapq.heappush(q, (matrix[row][col + 1], row, col + 1))
		return -1
if __name__=="__main__":
	matrix = [[1,5,9],[10,11,13],[12,13,15]]
	o = Solution()
	print(o.smallest(matrix, 4))