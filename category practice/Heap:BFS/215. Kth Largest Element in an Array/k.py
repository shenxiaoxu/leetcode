'''
215. Kth Largest Element in an Array

Find the kth largest element in an unsorted array. 
Note that it is the kth largest element in the sorted order, not the kth distinct element.

Example 1:

Input: [3,2,1,5,6,4] and k = 2
Output: 5
'''
'''
Solution 1:
sort nlogn
Solution 2:
use heap
nlogk
Solution 3:
divide and conquer
nlogn
'''
import heapq
class Solution(object):
	def kth(self, nums, k):
		if k > len(nums) or k <= 0:
			return -1
		nums.sort()
		return nums[len(nums) - k]
	def kth1(self, nums, k):
		if k > len(nums) or k <= 0:
			return -1
		heap = []
		for i in range(k):
			heapq.heappush(heap, nums[i])
		for i in range(k, len(nums)):
			if nums[i] > heap[0]:
				heapq.heappop(heap)
				heapq.heappush(heap, nums[i])
		return heap[0]
	def kth2(self, nums, k):
		if k > len(nums) or k <= 0:
			return -1
		s, e = 0, len(nums) - 1
		def insertionSort(nums, start, end):
			s, pivot, e = start, nums[start], end
			while s < e:
				while s < e and nums[e] >= pivot:
					e -= 1
				nums[s] = nums[e]
				while s < e and nums[s] <= pivot:
					s += 1
				nums[e] = nums[s]
			nums[s] = pivot
			return s

		while s < e:
			idx = insertionSort(nums, s, e)
			if idx == len(nums) - k:
				return nums[idx]
			elif idx > len(nums) - k:
				e = idx - 1
			else:
				s = idx + 1
		return nums[s]

if __name__ == "__main__":
	nums = [3,2,1,5,6,4]
	o = Solution()
	print(o.kth(nums, 2))
	print(o.kth1(nums, 2))
	print(o.kth2(nums, 2))



