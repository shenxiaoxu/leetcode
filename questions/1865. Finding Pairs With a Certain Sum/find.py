'''
You are given two integer arrays nums1 and nums2. You are tasked to implement a data structure that supports queries of two types:

Add a positive integer to an element of a given index in the array nums2.
Count the number of pairs (i, j) such that nums1[i] + nums2[j] equals a given value (0 <= i < nums1.length and 0 <= j < nums2.length).
Implement the FindSumPairs class:

FindSumPairs(int[] nums1, int[] nums2) Initializes the FindSumPairs object with two integer arrays nums1 and nums2.
void add(int index, int val) Adds val to nums2[index], i.e., apply nums2[index] += val.
int count(int tot) Returns the number of pairs (i, j) such that nums1[i] + nums2[j] == tot.
'''
class FindSumPairs:

    def __init__(self, nums1: List[int], nums2: List[int]):
        self.dic1 = collections.defaultdict(int)
        self.dic2 = collections.defaultdict(int)
        self.arr1 = nums1
        self.arr2 = nums2
        for i in nums1:
            self.dic1[i] += 1
        for i in nums2:
            self.dic2[i] += 1

    def add(self, index: int, val: int) -> None:
        ori = self.arr2[index]
        self.dic2[ori] -= 1
        self.dic2[ori + val] += 1
        self.arr2[index] += val
        
    def count(self, tot: int) -> int:
        print
        res = 0
        for k, v in self.dic1.items():
            if tot - k in self.dic2:
                res += v *self.dic2[tot - k]
        return res
        


# Your FindSumPairs object will be instantiated and called as such:
# obj = FindSumPairs(nums1, nums2)
# obj.add(index,val)
# param_2 = obj.count(tot)