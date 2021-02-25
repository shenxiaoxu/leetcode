'''
Given a set of points in the xy-plane, determine the minimum area of a rectangle formed from these points, with sides parallel to the x and y axes.

If there isn't any rectangle, return 0.
'''
class Solution(object):
    def minAreaRect(self, points):
        """
        :type points: List[List[int]]
        :rtype: int
        """
        seen  = set()
        res = float('inf')
        for x1, y1 in points:
            for x2, y2 in seen:
                if (x1, y2) in seen and (x2, y1) in seen:
                    if abs(x1 - x2)*abs(y1 - y2) < res:
                        res = abs(x1 - x2)*abs(y1 - y2)
            seen.add((x1, y1))
        return res if res != float('inf') else 0
