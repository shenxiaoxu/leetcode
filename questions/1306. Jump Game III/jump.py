'''
1306. Jump Game III
Given an array of non-negative integers arr, you are initially positioned at start index of the array. 
When you are at index i, you can jump to i + arr[i] or i - arr[i], check if you can reach to any index with value 0.

Notice that you can not jump outside of the array at any time.

 

Example 1:

Input: arr = [4,2,3,0,3,1,2], start = 5
Output: true
Explanation: 
All possible ways to reach at index 3 with value 0 are: 
index 5 -> index 4 -> index 1 -> index 3 
index 5 -> index 6 -> index 4 -> index 1 -> index 3 
'''
import collections
class Solution(object):
	def jump(self, arr, start):
		s = set()
		for i in range(len(arr)):
			if arr[i] == 0:
				s.add(i)
		q = collections.deque()
		q.append(start)
		v = [0]*len(arr)
		v[start] = 1
		while q:
			pos = q.popleft()
			if pos in s:
				return True
			back, front = pos + arr[pos], pos - arr[pos]
			if 0 <= back < len(arr) and v[back] == 0:
				v[back] = 1
				q.append(back)
			if 0 <= front < len(arr) and v[front] == 0:
				v[front] = 1
				q.append(front)
		return False
if __name__ == "__main__":
	arr = [3,0,2,1,2]
	o = Solution()
	print(o.jump(arr, 2))
