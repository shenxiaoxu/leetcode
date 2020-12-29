'''
There is a special kind of apple tree that grows apples every day for n days. 
On the ith day, the tree grows apples[i] apples that will rot after days[i] days, 
that is on day i + days[i] the apples will be rotten and cannot be eaten. On some days, 
the apple tree does not grow any apples, which are denoted by apples[i] == 0 and days[i] == 0.

You decided to eat at most one apple a day (to keep the doctors away). Note that you can keep eating after the first n days.

Given two integer arrays days and apples of length n, return the maximum number of apples you can eat.
'''
from typing import List
import heapq
class Solution:
	def max(self, apples:List[int], days:List[int]):
		q, res = [], 0
		for i in range(len(apples)):
			while q and i >= q[0][0]:
				heapq.heappop(q)
			if q and days[i] + i >= q[0][0]:
				k, v = heapq.heappop(q)
				if v - 1 > 0:
					heapq.heappush(q,(k, v - 1))
				heapq.heappush(q, (days[i] + i, apples[i]))
				res += 1
			elif q and days[i] == 0:
				k, v = heapq.heappop(q)
				if v - 1 > 0:
					heapq.heappush(q,(k, v - 1))
				res += 1				
			elif apples[i] >= 1:
				res += 1
				if apples[i] - 1 > 0:
					heapq.heappush(q, (days[i] + i, apples[i] - 1))
		#print(q)
		total = 0
		while len(q) != 1:
			total += q[0][1]
			heapq.heappop(q)
		res += min(total + q[0][1], q[0][0] - len(apples))
		return res

	def eatenApples(self, apples:List[int], days:List[int]):
		res, i = 0, 0
		q = []
		while i < len(apples) or q:
			if i < len(apples) and apples[i] > 0:
				heapq.heappush(q, [days[i] + i, apples[i]])
			while q and (i >= q[0][0] or q[0][1] == 0):
				heapq.heappop(q)
			if q:
				q[0][1] -= 1
				res += 1
			i += 1
		return res
if __name__ == "__main__":
	apples = [1,2,3,5,2]
	days = [3,2,1,4,2]
	o = Solution()
	print(o.max(apples, days))
	print(o.eatenApples(apples, days))
	apples = [3,0,0,0,0,2]
	days = [3,0,0,0,0,2]
	print(o.max(apples, days))
	print(o.eatenApples(apples, days))
