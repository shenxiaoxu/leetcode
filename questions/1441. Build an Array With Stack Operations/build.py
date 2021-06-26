'''
Given an array target and an integer n. In each iteration, you will read a number from  list = {1,2,3..., n}.

Build the target array using the following operations:

Push: Read a new element from the beginning list, and push it in the array.
Pop: delete the last element of the array.
If the target array is already built, stop reading more elements.
Return the operations to build the target array. You are guaranteed that the answer is unique.
'''
class Solution:
    def buildArray(self, target: List[int], n: int) -> List[str]:
        start = 1
        res = []
        idx = 0
        while idx < len(target):
            num = target[idx]
            while start != num:
                res.append("Push")
                res.append("Pop")
                start += 1
            res.append("Push")
            idx += 1
            start += 1
        return res