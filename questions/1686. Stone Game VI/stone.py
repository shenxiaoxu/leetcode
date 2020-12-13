'''
Alice and Bob take turns playing a game, with Alice starting first.

There are n stones in a pile. On each player's turn, they can remove a stone from the pile and receive points based on the stone's value. 
Alice and Bob may value the stones differently.

You are given two integer arrays of length n, aliceValues and bobValues. 
Each aliceValues[i] and bobValues[i] represents how Alice and Bob, respectively, value the ith stone.

The winner is the person with the most points after all the stones are chosen. If both players have the same amount of points, 
the game results in a draw. Both players will play optimally.

Determine the result of the game, and:

If Alice wins, return 1.
If Bob wins, return -1.
If the game results in a draw, return 0.
 

Example 1:

Input: aliceValues = [1,3], bobValues = [2,1]
Output: 1
Explanation:
If Alice takes stone 1 (0-indexed) first, Alice will receive 3 points.
Bob can only choose stone 0, and will only receive 2 points.
Alice wins.
'''
import heapq

class Solution(object):
	def stoneGameVI(self, aliceValues, bobValues):
		heap = []
		for i in range(len(aliceValues)):
			heapq.heappush(heap, (-(aliceValues[i] + bobValues[i]), aliceValues[i], bobValues[i]))

		v,n, sumAlice, sumBob = [0]*len(aliceValues), len(aliceValues), 0, 0
		for idx in range(n):
			total, alice, bob = heapq.heappop(heap)
			if idx%2 == 0:
				sumAlice += alice
			else:	
				sumBob += bob	
		#print((sumAlice, sumBob))
		if sumAlice == sumBob:
			return 0
		return 1 if sumAlice > sumBob else -1

if __name__ == "__main__":
	o = Solution()
	print(o.stoneGameVI([2,4,3], [1,6,7]))
	print(o.stoneGameVI([1,2], [3,1]))

