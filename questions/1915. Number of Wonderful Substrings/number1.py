'''
A wonderful string is a string where at most one letter appears an odd number of times.

For example, "ccjjc" and "abab" are wonderful, but "ab" is not.
Given a string word that consists of the first ten lowercase English letters ('a' through 'j'), return the number of wonderful non-empty substrings in word. If the same substring appears multiple times in word, then count each occurrence separately.

A substring is a contiguous sequence of characters in a string.
'''
class Solution:
    def wonderfulSubstrings(self, word: str) -> int:
        running = 0
        res = 0
        count = collections.defaultdict(int)
        count[0] = 1
        for c in word:
            running ^= 1<<(ord(c)-ord('a'))
            for ch in range(10):
                res += count[running^(1<<ch)]
            res += count[running]
            count[running] += 1
        return res