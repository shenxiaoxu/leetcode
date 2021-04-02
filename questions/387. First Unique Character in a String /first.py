'''
Given a string s, return the first non-repeating character in it and return its index. If it does not exist, return -1.
'''
class Solution:
    def firstUniqChar(self, s: str) -> int:
        m = Counter(s)
        for i,v in enumerate(s):
            if m[v] == 1:
                return i
        return -1