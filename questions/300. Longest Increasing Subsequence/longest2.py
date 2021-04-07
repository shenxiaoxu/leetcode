class Solution:
    def lengthOfLIS(self, nums: List[int]) -> int:
        a = []
        for num in nums:
            pos = bisect.bisect_left(a, num)
            if pos == len(a):
                a.append(num)
            else:
                a[pos] = num
        return len(a)