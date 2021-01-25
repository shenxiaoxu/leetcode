'''
There is an integer array perm that is a permutation of the first n positive integers, where n is always odd.

It was encoded into another integer array encoded of length n - 1, such that encoded[i] = perm[i] XOR perm[i + 1]. For example, if perm = [1,3,2], then encoded = [2,1].

Given the encoded array, return the original array perm. It is guaranteed that the answer exists and is unique.
'''
class Solution:
    def decode(self, encoded: List[int]) -> List[int]:
        n = len(encoded) + 1
        x = 0
        for i in range(1, n + 1):
            x ^= i
        for i in range(1, len(encoded), 2):
            x ^= encoded[i]
        res = [0]*n
        res[0] = x
        for i in range(1, len(res)):
            res[i] = encoded[i - 1]^res[i - 1]
        return res
        