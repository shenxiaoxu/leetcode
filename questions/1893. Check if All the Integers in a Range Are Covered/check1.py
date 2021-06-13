class Solution:
    def isCovered(self, ranges: List[List[int]], left: int, right: int) -> bool:
        ran = [0]*52
        for i in range(len(ranges)):
            start = ranges[i][0]
            end = ranges[i][1]
            ran[start] += 1
            ran[end + 1] -= 1
        overlap = 0
        for i in range(0, right + 1):
            overlap += ran[i]
            if overlap == 0 and i >= left:
                return False
        return True