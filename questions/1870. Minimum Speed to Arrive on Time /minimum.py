'''
You are given a floating-point number hour, representing the amount of time you have to reach the office. To commute to the office, you must take n trains in sequential order. You are also given an integer array dist of length n, where dist[i] describes the distance (in kilometers) of the ith train ride.

Each train can only depart at an integer hour, so you may need to wait in between each train ride.

For example, if the 1st train ride takes 1.5 hours, you must wait for an additional 0.5 hours before you can depart on the 2nd train ride at the 2 hour mark.
Return the minimum positive integer speed (in kilometers per hour) that all the trains must travel at for you to reach the office on time, or -1 if it is impossible to be on time.

Tests are generated such that the answer will not exceed 107 and hour will have at most two digits after the decimal point.
'''
class Solution:
    def minSpeedOnTime(self, dist: List[int], hour: float) -> int:
        if len(dist) - 1 > math.floor(hour):
            return -1
        lo, hi = 1, 10000000
        while lo < hi:
            mid = (lo + hi)//2
            hour_spent = 0
            for i in range(len(dist) - 1):
                hour_spent += math.ceil(dist[i]/mid)
            hour_spent += dist[-1]/mid
            if hour_spent > hour:
                lo = mid + 1
            else:
                hi = mid
        return lo