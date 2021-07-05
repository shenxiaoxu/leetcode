'''
You are given an integer num. You will apply the following steps exactly two times:

Pick a digit x (0 <= x <= 9).
Pick another digit y (0 <= y <= 9). The digit y can be equal to x.
Replace all the occurrences of x in the decimal representation of num by y.
The new integer cannot have any leading zeros, also the new integer cannot be 0.
Let a and b be the results of applying the operations to num the first and second times, respectively.

Return the max difference between a and b.
'''
class Solution:
    def maxDiff(self, num: int) -> int:
        str_num = str(num)
        max_num, min_num = float('-inf'), float('inf')
        for i in '0123456789':
            for j in '0123456789':
                next_num = str_num.replace(i, j)
                if next_num[0] == '0' or int(next_num) == 0:
                    continue
                max_num = max(max_num, int(next_num))
                min_num = min(min_num, int(next_num))
        return max_num - min_num