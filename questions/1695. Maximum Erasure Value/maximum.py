'''
You are given an array of positive integers nums and want to erase a subarray containing unique elements. 
The score you get by erasing the subarray is equal to the sum of its elements.

Return the maximum score you can get by erasing exactly one subarray.

An array b is called to be a subarray of a if it forms a contiguous subsequence of a, 
that is, if it is equal to a[l],a[l+1],...,a[r] for some (l,r).
'''
import collections
class Solution:
	def maximum(self, nums):
		s = set()
		l, r, t, res = 0, 0, 0, 0
		while r < len(nums):
			n = nums[r]
			while n in s:
				s.remove(nums[l])
				t -= nums[l]
				l += 1
			s.add(nums[r])
			t += nums[r]
			r += 1
			res = max(res, t)
		return res
if __name__ == "__main__":
	nums = [5,2,1,2,5,2,1,2,5]
	nums = [4,2,4,5,6]
	o = Solution()
	print(o.maximum(nums))
