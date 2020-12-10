'''
merge sort
'''
class Solution(object):
	def mergesort(self, nums, start, end):
		if start == end:
			return [nums[start]]
		mid = start + (end - start)//2
		left = self.mergesort(nums, start, mid)
		right = self.mergesort(nums, mid + 1, end)
		merge = self.merge(left, right)
		return merge
	def merge(self, left, right):
		i, j = 0, 0
		res = []
		while i < len(left) or j < len(right):
			n1 = left[i] if i < len(left) else float('inf')
			n2 = right[j] if j < len(right) else float('inf')
			if n1 < n2:
				res.append(n1)
				i += 1
			else:
				res.append(n2)
				j += 1
		return res
if __name__ == "__main__":
	o = Solution()
	nums = [5,7,6,1,3,2,1,2]
	print(o.mergesort(nums, 0, len(nums) - 1))