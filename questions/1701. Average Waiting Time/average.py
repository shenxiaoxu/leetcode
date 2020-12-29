'''
There is a restaurant with a single chef. You are given an array customers, where customers[i] = [arrivali, timei]:

arrivali is the arrival time of the ith customer. The arrival times are sorted in non-decreasing order.
timei is the time needed to prepare the order of the ith customer.
When a customer arrives, he gives the chef his order, and the chef starts preparing it once he is idle. 
The customer waits till the chef finishes preparing his order. The chef does not prepare food for more than one customer at a time. 
The chef prepares food for customers in the order they were given in the input.

Return the average waiting time of all customers. Solutions within 10-5 from the actual answer are considered accepted.
'''
from typing import List
class Solution:
	def average(self, customers: List[List[int]])->float:
		if len(customers) == 0:
			return 0
		cheftime = customers[0][0]
		i, waiting = 0,0
		while i < len(customers):
			if cheftime <= customers[i][0]:
				waiting += customers[i][1]
				cheftime = customers[i][0] + customers[i][1]
			else:
				waiting += cheftime - customers[i][0] + customers[i][1]
				cheftime += customers[i][1]
			i += 1
		return waiting/len(customers)
if __name__ == "__main__":
	customers = [[5,2],[5,4],[10,3],[20,1]]
	o = Solution()
	print(o.average(customers))