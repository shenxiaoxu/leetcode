'''
You are given an array points where points[i] = [xi, yi] is the coordinates of the ith point on a 2D plane. Multiple points can have the same coordinates.

You are also given an array queries where queries[j] = [xj, yj, rj] describes a circle centered at (xj, yj) with a radius of rj.

For each query queries[j], compute the number of points inside the jth circle. Points on the border of the circle are considered inside.

Return an array answer, where answer[j] is the answer to the jth query.
'''
class Solution:
    def countPoints(self, points: List[List[int]], queries: List[List[int]]) -> List[int]:
        n = len(queries)
        res = [0]*n
        for i, query in enumerate(queries):
            x,y,r = query[0], query[1], query[2]
            #print((x,y,r))
            for p in points:
                d = pow(p[0] - x,2) + pow(p[1] - y, 2)
                #print(d)
                if pow(r, 2) >= d:
                    res[i]+=1
        return res
                    
                    
                
            