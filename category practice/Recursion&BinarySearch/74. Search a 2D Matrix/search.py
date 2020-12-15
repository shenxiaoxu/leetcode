'''
Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:

Integers in each row are sorted from left to right.
The first integer of each row is greater than the last integer of the previous row.
'''
class Solution(object):
	def searchTarget(self, matrix, target):
		if not len(matrix): return False
		m, n = len(matrix), len(matrix[0])
		start, end = 0, m*n -1
		while start <= end:
			mid = start + (end - start)//2
			r = mid/n
			c = mid%n
			if matrix[r][c] == target:
				return True
			elif matrix[r][c] < target:
				start = mid + 1
			else:
				end = mid - 1
		return False
if __name__ == "__main__":
	matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,50]]
	target = 3
	o = Solution()
	print(o.searchTarget(matrix, target))
