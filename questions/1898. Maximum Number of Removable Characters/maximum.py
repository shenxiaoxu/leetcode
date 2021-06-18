'''
You are given two strings s and p where p is a subsequence of s. You are also given a distinct 0-indexed integer array removable containing a subset of indices of s (s is also 0-indexed).

You want to choose an integer k (0 <= k <= removable.length) such that, after removing k characters from s using the first k indices in removable, p is still a subsequence of s. More formally, you will mark the character at s[removable[i]] for each 0 <= i < k, then remove all marked characters and check if p is still a subsequence.

Return the maximum k you can choose such that p is still a subsequence of s after the removals.

A subsequence of a string is a new string generated from the original string with some characters (can be none) deleted without changing the relative order of the remaining characters.
'''
class Solution:
    def maximumRemovals(self, s: str, p: str, removable: List[int]) -> int:
        def exist(s, p, remove_list):
            remove_s = []
            for i,c in enumerate(s):
                if i not in remove_list:
                    remove_s.append(c)
            p1,p2 = 0,0
            str_remove = str(remove_s)
            while p1 < len(str_remove) and p2 < len(p):
                if str_remove[p1] != p[p2]:
                    p1 += 1
                else:
                    p1 += 1
                    p2 += 1
            return p2 == len(p)
        
        lo, hi = 0, len(removable)
        while lo < hi:
            mid = lo + (hi - lo)//2 + 1
            if exist(s, p, removable[:mid]):
                lo = mid
            else:
                hi = mid - 1
        return lo