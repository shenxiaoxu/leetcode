#https://leetcode.com/contest/biweekly-contest-40/problems/minimum-number-of-removals-to-make-mountain-array/
class Solution(object):
	def minimum(self, nums):
		left, right, res = [1]*len(nums), [1]*len(nums), 0
		for i in range(1, len(nums) - 1):
			for j in range(0, i):
				if nums[i] > nums[j]:
					left[i] = max(left[i], left[j] + 1)
		for i in range(len(nums) - 2, 0, -1):
			for j in range(i + 1, len(nums)):
				if nums[i] > nums[j]:
					right[i] = max(right[i], right[j] + 1)
		for i in range(1, len(nums) - 1):
			res = max(res, left[i] + right[i] - 1)
		return len(nums) - res
if __name__ == "__main__":
	nums = [2,1,1,5,6,2,3,1]
	o = Solution()
	print(o.minimum(nums))
