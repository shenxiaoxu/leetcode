'''
You are given a 2D integer array logs where each logs[i] = [birthi, deathi] indicates the birth and death years of the ith person.

The population of some year x is the number of people alive during that year. The ith person is counted in year x's population if x is in the inclusive range [birthi, deathi - 1]. Note that the person is not counted in the year that they die.

Return the earliest year with the maximum population.
'''
class Solution:
    def maximumPopulation(self, logs: List[List[int]]) -> int:
        res = -1
        count = 0
        for year in range(1950, 2051):
            tmp = 0
            for log in logs:
                if log[0] <= year and log[1] > year:
                    tmp += 1
            if tmp > count:
                count = tmp
                res = year
        return res