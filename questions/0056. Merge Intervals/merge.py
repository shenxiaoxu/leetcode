class Solution:
    def merge(self, intervals: List[List[int]]) -> List[List[int]]:
        res = []
        for ele in sorted(intervals, key = lambda x:x[0]):
            if res and ele[0] <= res[-1][1]:
                res[-1][1] = max(ele[1], res[-1][1])
            else:
                res.append(ele)
        return res
        
