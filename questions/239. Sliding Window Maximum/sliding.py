'''
239. Sliding Window Maximum

You are given an array of integers nums, there is a sliding window of size k which is moving from the very left of the array to the very right. 
You can only see the k numbers in the window. Each time the sliding window moves right by one position.

Return the max sliding window.
Input: nums = [1,3,-1,-3,5,3,6,7], k = 3
Output: [3,3,5,5,6,7]
Explanation: 
Window position                Max
---------------               -----
[1  3  -1] -3  5  3  6  7       3
 1 [3  -1  -3] 5  3  6  7       3
 1  3 [-1  -3  5] 3  6  7       5
 1  3  -1 [-3  5  3] 6  7       5
 1  3  -1  -3 [5  3  6] 7       6
 1  3  -1  -3  5 [3  6  7]      7
'''
from collections import deque
class sliding:
	def slide(self, nums, k):
		q = deque()
		res = []
		for i in range(0, k):
			while len(q) != 0 and nums[i] >= q[-1][0]:
				q.pop()
			q.append((nums[i], i))
		res.append(q[0][0])
		
		for i in range(k, len(nums)):
			n, idx = q[0]
			if i - idx >= k:
				q.popleft()
			while len(q) != 0 and nums[i] >= q[-1][0]:
				q.pop()
			q.append((nums[i], i))
			res.append(q[0][0])
		return res
if __name__=="__main__":
	o = sliding()
	print(o.slide([-34,54,56,7,5,43,23,2,2,3,2], 5))
