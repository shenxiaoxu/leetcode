class Solution:
    def removeInterval(self, intervals: List[List[int]], toBeRemoved: List[int]) -> List[List[int]]:
        l = []
        s,e = toBeRemoved[0], toBeRemoved[1]
        for ele in intervals:
            if ele[0] >= e or ele[1] <= s:
                l.append(ele)
            else:
                if s > ele[0]:
                    l.append([ele[0], s])
                if e < ele[1]:
                    l.append([e, ele[1]])
        return l
        
