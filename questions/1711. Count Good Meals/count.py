'''
A good meal is a meal that contains exactly two different food items with a sum of deliciousness equal to a power of two.

You can pick any two different foods to make a good meal.

Given an array of integers deliciousness where deliciousness[i] is the deliciousness of the i​​​​​​th​​​​​​​​ item of food, return the number of different good meals 
you can make from this list modulo 109 + 7.

Note that items with different indices are considered different even if they have the same deliciousness value.
'''
import collections
from typing import List
class Solution:
	def count(self, meals:List[int])->int:
		d, res = collections.defaultdict(int), 0
		for num in meals:
			for i in range(32):
				res += d[ (1<<i) - num]
			d[num] += 1
		return res%1_000_000_007
if __name__ == "__main__":
	deliciousness = [1,1,1,3,3,3,7]
	o = Solution()
	print(o.count(deliciousness))
	deliciousness = [1,3,5,7,9]
	print(o.count(deliciousness))
