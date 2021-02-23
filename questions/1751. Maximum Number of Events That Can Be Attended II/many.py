'''
You are given an array of events where events[i] = [startDayi, endDayi, valuei]. The ith event starts at startDayi and ends at endDayi, and if you attend this event, you will receive a value of valuei. You are also given an integer k which represents the maximum number of events you can attend.

You can only attend one event at a time. If you choose to attend an event, you must attend the entire event. Note that the end day is inclusive: that is, you cannot attend two events where one of them starts and the other ends on the same day.

Return the maximum sum of values that you can receive by attending events.
'''
class Solution(object):
    def maxValue(self, A, K):
        A.sort(key=lambda sev: sev[1])
        dp, dp2 = [[0, 0]], [[0, 0]]
        for k in xrange(K):
            for s, e, v in A:
                i = bisect.bisect(dp, [s]) - 1
                if dp[i][1] + v > dp2[-1][1]:
                    dp2.append([e, dp[i][1] + v])
            dp, dp2 = dp2, [[0, 0]]
        return dp[-1][-1]