class Solution:
    def smallestRepunitDivByK(self, k: int) -> int:
        if k%10 not in {1,3,7,9}:
            return -1
        s, prev = set(), 0
        for i in range(1,k + 1):
            prev = (prev*10+1)%k
            if not prev:
                return i
            if prev in s:
                return -1
            s.add(prev)
        return -1
