'''
You are an ant tasked with adding n new rooms numbered 0 to n-1 to your colony. You are given the expansion plan as a 0-indexed integer array of length n, prevRoom, where prevRoom[i] indicates that you must build room prevRoom[i] before building room i, and these two rooms must be connected directly. Room 0 is already built, so prevRoom[0] = -1. The expansion plan is given such that once all the rooms are built, every room will be reachable from room 0.

You can only build one room at a time, and you can travel freely between rooms you have already built only if they are connected. You can choose to build any room as long as its previous room is already built.

Return the number of different orders you can build all the rooms in. Since the answer may be large, return it modulo 109 + 7.
'''
class Solution:
    def waysToBuildRooms(self, prevRoom: List[int]) -> int:
        dic = collections.defaultdict(list)
        for cur, pre in enumerate(prevRoom):
            dic[pre].append(cur)
        mod = 1000000007
        
        def dfs(cur):
            if not dic[cur]:
                return 1,1
            ans, l = 1, 0
            for nxt in dic[cur]:
                tmp, r = dfs(nxt)
                ans = (ans*tmp*math.comb(l+r, r))%mod
                l += r
            return ans, l + 1
        return dfs(0)[0]