'''
At a lemonade stand, each lemonade costs $5. 

Customers are standing in a queue to buy from you, and order one at a time (in the order specified by bills).

Each customer will only buy one lemonade and pay with either a $5, $10, or $20 bill.  
You must provide the correct change to each customer, so that the net transaction is that the customer pays $5.

Note that you don't have any change in hand at first.

Return true if and only if you can provide every customer with correct change.
'''
class Solution:
	def lemonade(self, nums):
		five, ten, twenty = 0, 0, 0
		for i in nums:
			if i == 20:
				if ten > 0:
					ten -= 1
					five -= 1
				else:
					five -= 3
				twenty += 1
			elif i == 10:
				five -= 1
				ten += 1
			else:
				five += 1
			if five < 0 or ten < 0:
				return False
		return True
if __name__ == "__main__":
	nums = [5,5,10,10,20]
	o = Solution()
	print(o.lemonade(nums))