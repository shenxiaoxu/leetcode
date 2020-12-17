'''
84. Largest Rectangle in Histogram

Given n non-negative integers representing the histogram's bar height where the width of each bar is 1, 
find the area of largest rectangle in the histogram.
'''
class Solution:
	def largest(self, nums):
		stack, res = [-1], 0
		for i in range(len(nums)):
			while len(stack) != 1 and nums[i] < nums[stack[-1]]:
				cur = stack.pop()
				res = max(res, nums[cur]*(i - stack[-1] - 1))
			stack.append(i)
		last = stack[-1]
		while len(stack) != 1:
			cur = stack.pop()
			res = max(res, nums[cur]*(last - cur + 1))
		return res
if __name__ == "__main__":
	nums1 = [2,1,5,6,2,3]
	nums2 = [2,1,2]
	o = Solution()
	print(o.largest(nums1))
	print(o.largest(nums2))
