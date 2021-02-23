'''
You are given two strings word1 and word2. You want to construct a string merge in the following way: while either word1 or word2 are non-empty, choose one of the following options:

If word1 is non-empty, append the first character in word1 to merge and delete it from word1.
For example, if word1 = "abc" and merge = "dv", then after choosing this operation, word1 = "bc" and merge = "dva".
If word2 is non-empty, append the first character in word2 to merge and delete it from word2.
For example, if word2 = "abc" and merge = "", then after choosing this operation, word2 = "bc" and merge = "a".
Return the lexicographically largest merge you can construct.

A string a is lexicographically larger than a string b (of the same length) if in the first position where a and b differ, a has a character strictly larger than the corresponding character in b. For example, "abcd" is lexicographically larger than "abcc" because the first position they differ is at the fourth character, and d is greater than c.
'''
class Solution:
    def largestMerge(self, word1: str, word2: str) -> str:
        res, s1,s2 = "",0,0
        
        while len(word1) and len(word2):
            if word1[0]!= word2[0]:
                if word1[0] > word2[0]:
                    res += word1[0]
                    word1 = word1[1:]
                else:
                    res += word2[0]
                    word2 = word2[1:]
            else:
                if word1 > word2:
                    res += word1[0]
                    word1 = word1[1:]
                else:
                    res += word2[0]
                    word2 = word2[1:]
        res += word1 if len(word1) else word2
        return res
                