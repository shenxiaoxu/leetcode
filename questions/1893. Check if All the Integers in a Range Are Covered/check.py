'''
You are given a 2D integer array ranges and two integers left and right. Each ranges[i] = [starti, endi] represents an inclusive interval between starti and endi.

Return true if each integer in the inclusive range [left, right] is covered by at least one interval in ranges. Return false otherwise.

An integer x is covered by an interval ranges[i] = [starti, endi] if starti <= x <= endi.
'''
class Solution:
    def isCovered(self, ranges: List[List[int]], left: int, right: int) -> bool:
        l = [0]*51
        for ran in ranges:
            start = ran[0]
            end = ran[1]
            for i in range(start, end + 1):
                l[i] = 1
        for i in range(left, right + 1):
            if l[i] == 0:
                return False
        return True