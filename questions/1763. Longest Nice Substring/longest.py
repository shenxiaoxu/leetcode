'''
A string s is nice if, for every letter of the alphabet that s contains, it appears both in uppercase and lowercase. For example, "abABB" is nice because 'A' and 'a' appear, and 'B' and 'b' appear. However, "abA" is not because 'b' appears, but 'B' does not.

Given a string s, return the longest substring of s that is nice. If there are multiple, return the substring of the earliest occurrence. If there are none, return an empty string.
'''

class Solution:
    def longestNiceSubstring(self, s: str) -> str:
        res, l = "", 0
        for i in range(len(s)):
            for j in range(i, len(s)):
                tmp = s[i:j + 1]
                d = Counter(tmp)
                nice = True
                for k,v in d.items():
                    if k.islower():
                        c = str(k).upper()[0]
                        if c not in d:
                            nice = False
                            break
                    if k.isupper():
                        c = str(k).lower()[0]
                        if c not in d:
                            nice = False
                            break
                if nice and len(tmp) > l:
                    l = len(tmp)
                    res = tmp
        return res