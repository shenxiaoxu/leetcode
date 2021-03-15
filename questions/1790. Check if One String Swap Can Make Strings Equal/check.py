'''
You are given two strings s1 and s2 of equal length. A string swap is an operation where you choose two indices in a string (not necessarily different) and swap the characters at these indices.

Return true if it is possible to make both strings equal by performing at most one string swap on exactly one of the strings. Otherwise, return false.
'''
class Solution:
    def areAlmostEqual(self, s1: str, s2: str) -> bool:
        diff = [[x,y] for x, y in zip(s1, s2) if x != y]
        return not diff or (len(diff) == 2 and diff[0][::-1] == diff[1])
    