'''
1492. The kth Factor of n

Given two positive integers n and k.

A factor of an integer n is defined as an integer i where n % i == 0.

Consider a list of all factors of n sorted in ascending order, return the kth factor in this list or return -1 if n has less than k factors.


Example 1:

Input: n = 12, k = 3
Output: 3
Explanation: Factors list is [1, 2, 3, 4, 6, 12], the 3rd factor is 3.
'''
class Solution(object):
	def factor(self, n:int, k:int)->int:
		if k > n: return -1
		def check(s:int, e:int, t:int, n: int)->(int,int):
			res = 0
			for i in range(s, e + 1):
				if n % i == 0:
					t -= 1
				if t == 0:
					res = i
					break
			return (t, res)
		s, e = 1, n
		while s <= e:
			mid = s + e >> 1
			num, res = check(s, mid, k, n)
			#print((num, res))
			if num == 0:
				return res
			elif num > 0:
				s = mid + 1
				k = num
			else:
				e =  mid - 1
				k = num
		return -1
if __name__ == "__main__":
	o = Solution()
	print(o.factor(12,2))
