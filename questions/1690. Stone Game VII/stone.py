'''
1690. Stone Game VII

Alice and Bob take turns playing a game, with Alice starting first.

There are n stones arranged in a row. On each player's turn, 
they can remove either the leftmost stone or the rightmost stone from the row and receive points equal to the sum of the remaining stones' values in the row. 
The winner is the one with the higher score when there are no stones left to remove.

Bob found that he will always lose this game (poor Bob, he always loses), so he decided to minimize the score's difference. 
Alice's goal is to maximize the difference in the score.

Given an array of integers stones where stones[i] represents the value of the ith stone from the left, return the difference in Alice and Bob's score 
if they both play optimally.

Input: stones = [5,3,1,4,2]
Output: 6
Explanation: 
- Alice removes 2 and gets 5 + 3 + 1 + 4 = 13 points. Alice = 13, Bob = 0, stones = [5,3,1,4].
- Bob removes 5 and gets 3 + 1 + 4 = 8 points. Alice = 13, Bob = 8, stones = [3,1,4].
- Alice removes 3 and gets 1 + 4 = 5 points. Alice = 18, Bob = 8, stones = [1,4].
- Bob removes 1 and gets 4 points. Alice = 18, Bob = 12, stones = [4].
- Alice removes 4 and gets 0 points. Alice = 18, Bob = 12, stones = [].
The score difference is 18 - 12 = 6.
'''
import itertools
class Solution(object):
	def stone(self, nums: list[int])->int:
		dp = [[0]*len(nums) for _ in range(len(nums))]
		p_sum = [0] + list(itertools.accumulate(nums))
		def dfs(i:int, j:int)->int:
			if i == j:
				return 0
			if dp[i][j] == 0:
				sum = p_sum[j + 1] - p_sum[i]
				dp[i][j] = max(sum - nums[i] - dfs(i + 1, j), sum - nums[j] - dfs(i, j - 1))
			return dp[i][j]
		return dfs(0, len(nums) - 1)
if __name__ == "__main__":
	nums = [5,3,1,4,2]
	o = Solution()
	print(o.stone(nums))

