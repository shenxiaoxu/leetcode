'''
Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it can trap after raining.
'''
class Solution:
    def trap(self, height: List[int]) -> int:
        stack, res = [], 0
        for i in range(len(height)):
            while stack and height[i] >= height[stack[-1]]:
                idx = stack.pop()
                if not stack:
                    break
                #print(height[stack[-1]] - height[idx])
                #print(i - stack[-1] - 1)
                res += (min(height[stack[-1]], height[i]) - height[idx]) * (i - stack[-1] - 1)
            stack.append(i)
        return res