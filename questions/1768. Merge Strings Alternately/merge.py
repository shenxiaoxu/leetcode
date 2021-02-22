'''
You are given two strings word1 and word2. Merge the strings by adding letters in alternating order, starting with word1. If a string is longer than the other, append the additional letters onto the end of the merged string.

Return the merged string.
'''
class Solution:
    def mergeAlternately(self, word1: str, word2: str) -> str:
        res, s1 = "", 0
        for s1 in range(min(len(word1), len(word2))):
            res += word1[s1]
            res += word2[s1]
        s1 += 1
        if s1 == len(word1):
            res += word2[s1:]
        if s1 == len(word2):
            res += word1[s1:]
        return res