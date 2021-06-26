'''
Given an array of integers arr.

We want to select three indices i, j and k where (0 <= i < j <= k < arr.length).

Let's define a and b as follows:

a = arr[i] ^ arr[i + 1] ^ ... ^ arr[j - 1]
b = arr[j] ^ arr[j + 1] ^ ... ^ arr[k]
Note that ^ denotes the bitwise-xor operation.

Return the number of triplets (i, j and k) Where a == b.
'''
class Solution:
    def countTriplets(self, arr: List[int]) -> int:
        N = len(arr)
        prefix = [0]*(N+1)
        res = 0
        for i in range(1,N + 1):
            prefix[i] = prefix[i - 1]^arr[i - 1]
        #print(prefix)
        for i in range(1, N):
            for j in range(i + 1, N + 1):
                if prefix[j]^prefix[i - 1] == 0:
                    res += j - i
        return res