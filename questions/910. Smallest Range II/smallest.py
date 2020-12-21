'''
910. Smallest Range II
Medium

Given an array A of integers, for each integer A[i] we need to choose either x = -K or x = K, and add x to A[i] (only once).

After this process, we have some array B.

Return the smallest possible difference between the maximum value of B and the minimum value of B.
'''
class Solution:
	def smallest(self, nums, k):
		nums.sort()
		mn, mx = nums[0], nums[len(nums) - 1]
		res = mx - mn
		for i in range(len(nums) - 1):
			mx = max(mx, nums[i] + 2*k)
			mn = min(nums[i + 1], nums[0] + 2*k)
			res = min(res, mx - mn)
		return res
	def smallestRange(self, nums, k):
		mx, mn = max(nums), min(nums)
		if mx - mn >= 4*k:
			return mx - mn - 2*k
		if mx - mn <= k:
			return mx - mn
		n = sorted([i for i in nums if mx - 2*k < i < mn + 2 * k] + [mx - 2 * k, mn + 2 * k])
		return min(a + 2*k - b for a,b in zip(n, n[1:]))
if __name__ == "__main__":
	nums = [1,2,3,4,5,7,9]
	o = Solution()
	print(o.smallest(nums, 5))
	print(o.smallestRange(nums, 5))



