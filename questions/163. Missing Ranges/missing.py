'''
163. Missing Ranges

You are given an inclusive range [lower, upper] and a sorted unique integer array nums, where all elements are in the inclusive range.

A number x is considered missing if x is in the range [lower, upper] and x is not in nums.

Return the smallest sorted list of ranges that cover every missing number exactly. That is, no element of nums is in any of the ranges, 
and each missing number is in one of the ranges.

Each range [a,b] in the list should be output as:

"a->b" if a != b
"a" if a == b
 

Example 1:

Input: nums = [0,1,3,50,75], lower = 0, upper = 99
Output: ["2","4->49","51->74","76->99"]
Explanation: The ranges are:
[2,2] --> "2"
[4,49] --> "4->49"
[51,74] --> "51->74"
[76,99] --> "76->99"
'''
class Solution(object):
	def findMissingRanges(self, nums, lower, upper):
		res, pos = [], 0
		if len(nums) == 0:
			if lower == upper:
				res.append(str(lower))
				return res
			else:
				res.append(str(lower) + "->" + str(upper))
				return res
		for i in range(len(nums)):
			if i == 0:
				if nums[i] - lower == 1:
					res.append(str(nums[i]-1))
				elif nums[i] - lower > 1:
					res.append(str(lower) + "->" + str(nums[i] - 1))
			else:
				if nums[i] - nums[i - 1] == 2:
					res.append(str(nums[i]-1))
				elif nums[i] - nums[i - 1] > 2:
					res.append(str(nums[i - 1] + 1) + "->" + str(nums[i] - 1))
			if i == len(nums) - 1:
				if upper - nums[i] == 1:
					res.append(str(nums[i]+1))
				elif upper - nums[i] > 1:
					res.append(str(nums[i] + 1) + "->" + str(upper))
		return res
if __name__ == "__main__":
	nums1 = [0,1,3,50,75]
	nums2 = []
	o = Solution()
	print(o.missing(nums1, 0, 75))
	print(o.missing(nums2, -1, -1))
	print(o.missing(nums2, -3, -1))					


