'''
You are given an integer array, nums, and an integer k. nums comprises of only 0's and 1's. In one move, you can choose two adjacent indices and swap their values.

Return the minimum number of moves required so that nums has k consecutive 1's.
'''
import collections
from typing import List
class Solution:
	def min(self, nums:List[int], k:int)->int:
		pos = [i for i, x in enumerate(nums) if x == 1]
		#print(pos)
		pos = [p - i for i, p in enumerate(pos)]
		#print(pos)
		mid = k //2
		curleft = sum(abs(i - pos[mid]) for i in pos[0:mid])
		curright = sum(abs(i - pos[mid])for i in pos[mid + 1: k])
		sizeleft = mid 
		sizeright = k - 1 - sizeleft
		minres = curleft + curright
		for i in range(1, len(pos)-k+1):
			curleft -=  (pos[mid + i - 1] - pos[i - 1])
			curleft += sizeleft*(pos[mid + i]-pos[mid + i - 1])
			curright -= sizeright*(pos[mid + i]-pos[mid + i - 1]) 
			curright += (pos[k + i - 1] - pos[i+mid])
			minres = min(minres, curright + curleft)
			#print(curleft, curright, minres)
		#print()
		return minres
if __name__ == "__main__":
	nums = [1,0,0,1,0,0,1,0,1]
	o = Solution()
	print(o.min(nums, 2))
	print(o.min(nums, 3))
	print(o.min(nums, 4))


