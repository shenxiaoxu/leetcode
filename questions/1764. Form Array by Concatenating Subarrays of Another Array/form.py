'''
You are given a 2D integer array groups of length n. You are also given an integer array nums.

You are asked if you can choose n disjoint subarrays from the array nums such that the ith subarray is equal to groups[i] (0-indexed), and if i > 0, the (i-1)th subarray appears before the ith subarray in nums (i.e. the subarrays must be in the same order as groups).

Return true if you can do this task, and false otherwise.

Note that the subarrays are disjoint if and only if there is no index k such that nums[k] belongs to more than one subarray. A subarray is a contiguous sequence of elements within an array.
'''
class Solution:
    def canChoose(self, groups: List[List[int]], nums: List[int]) -> bool:
        idx = 0
        for i in range(len(groups)):
            arr, find = groups[i], False
            for remain in range(idx, len(nums)):
                start, flag = 0, True
                for match in range(remain, min(len(nums), remain + len(arr))):
                    if nums[match] == arr[start]:
                        start += 1
                    else:
                        flag = False
                        break
                if flag and start == len(arr):
                    idx = remain + len(arr)
                    find = True
                    break
            if not find:
                return False
        return True