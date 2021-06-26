'''
Your country has an infinite number of lakes. Initially, all the lakes are empty, but when it rains over the nth lake, the nth lake becomes full of water. If it rains over a lake which is full of water, there will be a flood. Your goal is to avoid the flood in any lake.

Given an integer array rains where:

rains[i] > 0 means there will be rains over the rains[i] lake.
rains[i] == 0 means there are no rains this day and you can choose one lake this day and dry it.
Return an array ans where:

ans.length == rains.length
ans[i] == -1 if rains[i] > 0.
ans[i] is the lake you choose to dry in the ith day if rains[i] == 0.
If there are multiple valid answers return any of them. If it is impossible to avoid flood return an empty array.

Notice that if you chose to dry a full lake, it becomes empty, but if you chose to dry an empty lake, nothing changes. (see example 4)
'''
class Solution:
    def avoidFlood(self, rains: List[int]) -> List[int]:
        dry_days = []
        res = []
        rain_map = collections.defaultdict(int)#lake, time of latest fill
        for i, c in enumerate(rains):
            if c == 0:
                dry_days.append(i)
                res.append(1)#override later
            else:
                if c in rain_map:
                    pos = bisect.bisect_right(dry_days, rain_map[c])#binary search for dry_days
                    if pos == len(dry_days):
                        return []
                    res[dry_days[pos]] = c# on that day we dry #c lake
                    dry_days.pop(pos)
                rain_map[c] = i        
                res.append(-1)
        return res 