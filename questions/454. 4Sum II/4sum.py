# -*- coding: utf-8 -*-
'''
454. 4Sum II
Medium

Given four lists A, B, C, D of integer values, compute how many tuples (i, j, k, l) there are such that A[i] + B[j] + C[k] + D[l] is zero.

To make problem a bit easier, all A, B, C, D have same length of N where 0 ≤ N ≤ 500. All integers are in the range of -228 to 228 - 1 and 
the result is guaranteed to be at most 231 - 1.

Example:

Input:
A = [ 1, 2]
B = [-2,-1]
C = [-1, 2]
D = [ 0, 2]

Output:
2

Explanation:
The two tuples are:
1. (0, 0, 0, 1) -> A[0] + B[0] + C[0] + D[1] = 1 + (-2) + (-1) + 2 = 0
2. (1, 1, 0, 0) -> A[1] + B[1] + C[0] + D[0] = 2 + (-1) + (-1) + 0 = 0
'''
import collections
class Solution:
	def foursum(self, A, B, C, D):
		m1 = collections.defaultdict(int)
		m2 = collections.defaultdict(int)
		res = 0
		for i in range(len(A)):
			for j in range(len(B)):
				m1[A[i] + B[j]] += 1
		for i in range(len(C)):
			for j in range(len(D)):
				m2[C[i] + D[j]] += 1
		for k in m1:
			if -k in m2:
				print((k, -k, m1[k], m2[-k]))
				res += m1[k]*m2[-k]
		return res
if __name__ == "__main__":
	A, B, C, D = [1,2,3],[0,-2,-1],[3,-1,2],[2,0,2]
	o = Solution()
	print(o.foursum(A, B, C, D))

