'''
Given n cuboids where the dimensions of the ith cuboid is cuboids[i] = [widthi, lengthi, heighti] (0-indexed). 
Choose a subset of cuboids and place them on each other.

You can place cuboid i on cuboid j if widthi <= widthj and lengthi <= lengthj and heighti <= heightj. 
You can rearrange any cuboid's dimensions by rotating it to put it on another cuboid.

Return the maximum height of the stacked cuboids.
'''
class Solution:
	def maximum(self, cuboids):
		A = [[0,0,0]] + sorted(map(sorted, cuboids))
		dp = [0]*len(A)
		for i in range(1, len(A)):
			for j in range(i):
				if all(A[i][k] >= A[j][k] for k in range(3)):
					dp[i] = max(dp[i], dp[j] + A[i][2])
		return max(dp)
if __name__ == "__main__":
	cuboids = [[50,45,20],[95,37,53],[45,23,12]]
	o = Solution()
	print(o.maximum(cuboids))
