class Solution:
    def minOperations(self, nums: List[int], x: int) -> int:
        s, res, target = 0, -float('inf'), -x       
        for i in nums:
            target += i
        if not target:
            return len(nums)
        dic = defaultdict(int)
        dic[0] = -1
        for i in range(len(nums)):
            s += nums[i]
            if s - target in dic:
                res = max(res, i - dic[s - target])
            dic[s] = i
        return len(nums) - res if res != -float('inf') else -1
        
