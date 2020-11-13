class Solution:
    def permuteUnique(self, nums: List[int]) -> List[List[int]]:
        nums.sort()
        self.res = []  
        def dfs(lis, vis, nums):
            if len(lis) == len(vis):              
                self.res.append(lis[:]);
            for i in range(len(vis)):
                if i > 0 and vis[i - 1] == 0 and nums[i] == nums[i - 1]: 
                    continue
                if vis[i] == 0:
                    vis[i] = 1
                    lis.append(nums[i])
                    dfs(lis, vis, nums)
                    vis[i] = 0
                    lis.pop()
        dfs([],[0]*len(nums), nums)
        return self.res
        
