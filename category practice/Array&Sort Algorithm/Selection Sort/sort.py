'''
Selection Sort
'''
class Solution(object):
	def selectionSort(self, nums):
		for i in range(len(nums)):
			min_num, min_idx = float('inf'), i
			for j in range(i + 1, len(nums)):
				if nums[j] < min_num:
					min_num = nums[j]
					min_idx = j
			tmp = nums[i]
			nums[i] = nums[min_idx]
			nums[min_idx] = tmp
if __name__ == "__main__":
	nums = [1,5,7,3,2,1]
	o = Solution()
	o.selectionSort(nums)
	print(nums)

				
