'''
A split of an integer array is good if:

The array is split into three non-empty contiguous subarrays - named left, mid, right respectively from left to right.
The sum of the elements in left is less than or equal to the sum of the elements in mid, and the sum of the elements in mid is less than or 
equal to the sum of the elements in right.
Given nums, an array of non-negative integers, return the number of good ways to split nums. As the number may be too large, return it modulo 109 + 7.
'''
from typing import List
import functools
import bisect
class Solution:
	def ways(self, nums:List[List[int]])->int:
		prefix = [0]
		res = 0
		for i in nums:
			prefix.append(prefix[-1]+i)
		for i in range(1,len(nums)):
			j = bisect.bisect_left(prefix, 2*prefix[i])
			k = bisect.bisect_right(prefix, (prefix[-1] + prefix[i])//2)
			res += max(0, min(len(nums), k) - max(i + 1, j))
		return res%1_000_000_007
		
if __name__ =="__main__":
	nums = [2,3,4]
	o = Solution()
	print(o.ways(nums))
