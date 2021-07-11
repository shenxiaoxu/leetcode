'''
In universe Earth C-137, Rick discovered a special form of magnetic force between two balls if they are put in his new invented basket. Rick has n empty baskets, the ith basket is at position[i], Morty has m balls and needs to distribute the balls into the baskets such that the minimum magnetic force between any two balls is maximum.

Rick stated that magnetic force between two different balls at positions x and y is |x - y|.

Given the integer array position and the integer m. Return the required force.
'''
class Solution:
    def maxDistance(self, p: List[int], m: int) -> int:
        p.sort()
        l, r = 0, p[-1] - p[0]
        def count(d):
            ans, s = 1, p[0]
            for i in range(1, len(p)):
                if p[i] - s >= d:
                    ans += 1
                    s = p[i]
            return ans
        
        while l < r:
            mid = r - (r - l)//2
            #print(mid)
            if count(mid) >= m:
                l = mid
            else:
                r = mid - 1
        return l