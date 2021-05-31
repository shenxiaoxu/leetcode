'''
Given a rectangular cake with height h and width w, and two arrays of integers horizontalCuts and verticalCuts where horizontalCuts[i] is the distance from the top of the rectangular cake to the ith horizontal cut and similarly, verticalCuts[j] is the distance from the left of the rectangular cake to the jth vertical cut.

Return the maximum area of a piece of cake after you cut at each horizontal and vertical position provided in the arrays horizontalCuts and verticalCuts. Since the answer can be a huge number, return this modulo 10^9 + 7.
'''
class Solution:
    def maxArea(self, h: int, w: int, horizontalCuts: List[int], verticalCuts: List[int]) -> int:
        horizontalCuts.sort()
        verticalCuts.sort()
        horizontalCuts = [0] + horizontalCuts + [h]
        verticalCuts = [0] + verticalCuts + [w]

        maxH = 0
        maxV = 0
        for i in range(1, len(horizontalCuts)):
            maxH = max(maxH, horizontalCuts[i] - horizontalCuts[i - 1])
            
        for i in range(1, len(verticalCuts)):
            maxV = max(maxV, verticalCuts[i] - verticalCuts[i - 1])
            
        return maxH*maxV%1000000007
        
        