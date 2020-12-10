'''
quicksort
'''
class Solution(object):
	def quick(self, nums, s, e):
		if s >= e:
			return
		pivot = self.quicksort(nums, s, e)
		self.quick(nums, s, pivot - 1)
		self.quick(nums, pivot + 1, e)
		
	def quicksort(self, nums, s, e):
		p = nums[s]
		while s < e:
			while s < e and nums[e] >= p:
				e -= 1
			nums[s] = nums[e]
			while s < e and nums[s] <= p:
				s += 1
			nums[e] = nums[s]
		nums[s] = p
		return s
if __name__ == "__main__":
	nums = [5,7,6,1,3,2,1,2,4]
	o = Solution()
	o.quick(nums, 0, len(nums) - 1)
	print(nums) 
