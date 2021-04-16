'''
There is a donuts shop that bakes donuts in batches of batchSize. They have a rule where they must serve all of the donuts of a batch before serving any donuts of the next batch. You are given an integer batchSize and an integer array groups, where groups[i] denotes that there is a group of groups[i] customers that will visit the shop. Each customer will get exactly one donut.

When a group visits the shop, all customers of the group must be served before serving any of the following groups. A group will be happy if they all get fresh donuts. That is, the first customer of the group does not receive a donut that was left over from the previous group.

You can freely rearrange the ordering of the groups. Return the maximum possible number of happy groups after rearranging the groups.
'''
class Solution:
    def maxHappyGroups(self, B: int, groups: List[int]) -> int:
        ans = sum(g%B == 0 for g in groups)
        groups = [g for g in groups if g%B != 0]
        pos = [0]*B
        for i in range(len(groups)):
            pos[groups[i]%B]+=1
        
        for i in range(1, B):
            t = min(pos[i], pos[B - i]) if 2*i != B else pos[i]//2
            ans += t
            pos[i] -= t
            pos[B - i] -= t
        
        if sum(pos) == 0: return ans
        
        @lru_cache(None)
        def dfs(position, last):
            if sum(position) == 0:
                return 0
            ans = float("-inf")
            
            for i in range(B):
                if position[i] > 0:
                    t = [j for j in position]
                    t[i] -= 1
                    U = (last - i)%B
                    ans = max(ans, dfs(tuple(t), U) + (U == 0))
            return ans
        
        return max(dfs(tuple(pos), i) for i in range(1,B)) + ans