'''
Given a positive integer n, find the smallest integer which has exactly the same digits existing in the integer n and is greater in value than n. 
If no such positive integer exists, return -1.

Note that the returned integer should fit in 32-bit integer, if there is a valid answer but it does not fit in 32-bit integer, return -1.
'''
class Solution:
	def nextGreaterElement(self, num:int)->int:
		
		numstr = str(num)
		i = len(numstr) - 1
		while i > 0 and numstr[i - 1] >= numstr[i]:
			i -= 1
		if i == 0:
			return -1
		i -= 1
		j = len(numstr) - 1
		while j > i and numstr[j] <= numstr[i]:
			j -= 1
		lst = list(numstr)
		lst[i],lst[j]=lst[j],lst[i]
		numstr = ''.join(lst)
		s = numstr[:i + 1] + ''.join(sorted(numstr[i + 1:]))
		res = int(s) 
		return res if res < 1 <<31 else -1
if __name__ == "__main__":
	o = Solution()
	print(o.next(26541))