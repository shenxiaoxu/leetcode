'''
1674. Minimum Moves to Make Array Complementary
You are given an integer array nums of even length n and an integer limit. 
In one move, you can replace any integer from nums with another integer between 1 and limit, inclusive.

The array nums is complementary if for all indices i (0-indexed), nums[i] + nums[n - 1 - i] equals the same number. 
For example, the array [1,2,3,4] is complementary because for all indices i, nums[i] + nums[n - 1 - i] = 5.

Return the minimum number of moves required to make nums complementary.
Input: nums = [1,2,4,3], limit = 4
Output: 1
Explanation: In 1 move, you can change nums to [1,2,2,3] (underlined elements are changed).
nums[0] + nums[3] = 1 + 3 = 4.
nums[1] + nums[2] = 2 + 2 = 4.
nums[2] + nums[1] = 2 + 2 = 4.
nums[3] + nums[0] = 3 + 1 = 4.
Therefore, nums[i] + nums[n-1-i] = 4 for every i, so nums is complementary.
Constraints:

n == nums.length
2 <= n <= 10^5
1 <= nums[i] <= limit <= 10^5
n is even.
'''
import collections
import math
class Solution(object):
	def min(self, nums, limit):
		delta = collections.Counter()
		for i in range(len(nums)/2):
			a,b = nums[i], nums[len(nums) - 1 - i]
			delta[2] += 2
			delta[min(a,b) + 1] -= 1
			delta[a + b] -= 1
			delta[a + b + 1] += 1
			delta[max(a,b) + limit + 1] += 1

		cur, res = 0, float('inf')
		for i in range(2, 2*limit + 1):
			cur += delta[i]
			res = min(res, cur)
		return res


if __name__ == "__main__":
	o = Solution()
	print(o.min([2,3,5,1], 6))
	print(o.min([2,3,5,1], 5))
	print(o.min([4,1,1,4], 4))




