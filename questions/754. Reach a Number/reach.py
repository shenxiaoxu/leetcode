'''
You are standing at position 0 on an infinite number line. There is a goal at position target.

On each move, you can either go left or right. During the n-th move (starting from 1), you take n steps.

Return the minimum number of steps required to reach the destination.
Input: target = 3
Output: 2
Explanation:
On the first move we step from 0 to 1.
On the second step we step from 1 to 3.

'''
class Solution:
	def step(self, n:int)->int:
		step,total = 0,0
		n = abs(n)
		while total < n:
			step += 1
			total += step			
		while (total - n)%2 != 0:
			step += 1
			total += step
		return step
		
if __name__ == "__main__":
	target = 3
	o = Solution()
	print(o.step(target))
	target = 2
	print(o.step(target))
	target = 5
	print(o.step(target))