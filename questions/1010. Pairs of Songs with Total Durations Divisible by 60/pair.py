'''
1010. Pairs of Songs With Total Durations Divisible by 60

You are given a list of songs where the ith song has a duration of time[i] seconds.

Return the number of pairs of songs for which their total duration in seconds is divisible by 60. Formally, 
we want the number of indices i, j such that i < j with (time[i] + time[j]) % 60 == 0.

 

Example 1:

Input: time = [30,20,150,100,40]
Output: 3
Explanation: Three pairs have a total duration divisible by 60:
(time[0] = 30, time[2] = 150): total duration 180
(time[1] = 20, time[3] = 100): total duration 120
(time[1] = 20, time[4] = 40): total duration 60
'''
import collections
class Solution(object):
	def pair(self, time):
		m, res = collections.defaultdict(int), 0
		for i in range(len(time)):
			r = time[i]%60
			if (60 - r)%60 in m:
				res += m[(60 - r)%60]
			m[r] += 1
		return res
if __name__ == "__main__":
	time1 = [30,20,150,100,40]
	time2 = [60,60,60]
	o = Solution()
	print(o.pair(time1))
	print(o.pair(time2))