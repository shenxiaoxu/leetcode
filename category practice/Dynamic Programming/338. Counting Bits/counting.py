# -*- coding: utf-8 -*-
'''
Given a non negative integer number num. For every numbers i in the range 0 ≤ i ≤ num calculate the number of 1's in their binary 
representation and return them as an array.

Example 1:

Input: 2
Output: [0,1,1]
'''
class Solution:
	def counting(self, num):
		offset = 1
		res = [0]*(num+1)
		for idx in range(1, num + 1):
			if offset * 2 == idx:
				offset = offset * 2
			res[idx] = res[idx - offset] + 1
		return res
if __name__ == "__main__":
	o = Solution()
	n = 2
	print(o.counting(2))