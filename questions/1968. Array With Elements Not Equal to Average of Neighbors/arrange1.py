class Solution:
    def rearrangeArray(self, nums: List[int]) -> List[int]:
        nums.sort()
        median = 0
        n = len(nums)
        if n % 2 == 0:
            median = (nums[n//2 - 1] + nums[n//2])/2
        else:
            median = nums[n//2]
        p1,p2=0,1
        res = [0]*n
        #[1,4,2,5,3]
        for num in nums:
            if num <= median:
                res[p1] = num
                p1 += 2
            else:
                res[p2] = num
                p2 += 2
        return res