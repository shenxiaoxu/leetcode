'''
Given a matrix of M x N elements (M rows, N columns), return all elements of the matrix in diagonal order as shown in the below image.
'''
class Solution:
	def diagonal(self, matrix):#25 minutes
		if len(matrix) == 0:
			return []
		m, n = len(matrix), len(matrix[0])
		idx, res = 0, []
		while idx < m + n - 1:
			tmp = []
			if idx < m:
				sr, sc = idx, 0
				while sr >= 0 and sc < n:
					tmp.append(matrix[sr][sc])
					sr -= 1
					sc += 1
			else:
				sr, sc = m - 1, idx - m + 1
				while sr >= 0 and sc < n:
					tmp.append(matrix[sr][sc])
					sr -= 1
					sc += 1

			if idx % 2 == 0:
				res = res + tmp
			else:
				res = res + tmp[::-1]
			idx += 1
		return res
	def diagonalTwo(self, matrix):
		d,res = {}, []
		for i in range(len(matrix)):
			for j in range(len(matrix[0])):
				if i + j not in d:
					d[i + j] = [matrix[i][j]]
				else:
					d[i + j].append(matrix[i][j])
		for k, v in d.items():
			if k%2 == 0:
				res = res + v[::-1]
			else:
				res = res + v
		return res

if __name__ == "__main__":
	matrix = [[1,2,3],[4,5,6]]
	o = Solution()
	print(o.diagonal(matrix))
	print(o.diagonalTwo(matrix))
	matrix1 = [[1,2],[3,4],[5,6]]
	print(o.diagonal(matrix1))	
	print(o.diagonalTwo(matrix1))
	matrix2 = [[1]]
	print(o.diagonal(matrix2))	
	print(o.diagonalTwo(matrix2))