'''
use two stack to simulate selection sort
'''
class Solution(object):
	def selectionsort(self, nums):
		s1, s2, res = nums, [], []
		
		while len(s1):
			g_min = float('inf')
			while len(s1):
				g_min = min(g_min, s1[-1])
				s2.append(s1.pop())
			while len(s2):
				if s2[-1] == g_min:
					s2.pop()
				else:
					s1.append(s2.pop())
			res.append(g_min)
		return res
if __name__ == "__main__":
	nums = [5,7,6,1,3,2]
	o = Solution()
	print(o.selectionsort(nums))
