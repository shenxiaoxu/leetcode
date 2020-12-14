'''
315. Count of Smaller Numbers After Self

You are given an integer array nums and you have to return a new counts array. 
The counts array has the property where counts[i] is the number of smaller elements to the right of nums[i].


'''
class Solution(object):
	def countSmaller(self, nums):
		if len(nums) == 0: return []
		self.smaller = [0]*len(nums)
		def countmerge(nums):
			if len(nums) == 1:
				return nums
			mid = len(nums)/2
			left, right = countmerge(nums[:mid]), countmerge(nums[mid:])
			nums = self.addNum(left, right)
			return nums
		countmerge(list(enumerate(nums)))
		return self.smaller
	def addNum(self, left, right):
		i, j, res = 0, 0, [[] for _ in range(len(left) + len(right))]
		while i < len(left) or j < len(right):
			if j == len(right) or i < len(left) and left[i][1] <= right[j][1]:
				self.smaller[left[i][0]] += j
				res[i + j] = left[i]
				i += 1
			else:
				res[i + j] = right[j]
				j += 1
		return res
if __name__ == "__main__":
	nums = [1]
	o = Solution()
	print(o.countSmaller(nums))


