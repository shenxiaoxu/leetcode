
'''
You are given a string time in the form of hh:mm, where some of the digits in the string are hidden (represented by ?).

The valid times are those inclusively between 00:00 and 23:59.

Return the latest valid time you can get from time by replacing the hidden digits.
'''
class Solution:
    def maximumTime(self, time: str) -> str:
        res = []
        for i in range(len(time)):
            if i == 0 and time[i] == '?':
                if time[i + 1] != '?' and time[i + 1] >= '4':
                    res.append('1')
                else:
                    res.append('2')
            elif i == 1 and time[i] == '?':
                if res[i - 1] == '2':
                    res.append('3')
                else:
                    res.append('9')
            elif i == 3 and time[i] == '?':
                res.append('5')
            elif i == 4 and time[i] == '?':
                res.append('9')
            else:
                res.append(time[i])
        return ''.join(res)        
        
                