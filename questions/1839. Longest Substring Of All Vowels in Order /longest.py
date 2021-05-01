'''
A string is considered beautiful if it satisfies the following conditions:

Each of the 5 English vowels ('a', 'e', 'i', 'o', 'u') must appear at least once in it.
The letters must be sorted in alphabetical order (i.e. all 'a's before 'e's, all 'e's before 'i's, etc.).
For example, strings "aeiou" and "aaaaaaeiiiioou" are considered beautiful, but "uaeio", "aeoiu", and "aaaeeeooo" are not beautiful.

Given a string word consisting of English vowels, return the length of the longest beautiful substring of word. If no such substring exists, return 0.

A substring is a contiguous sequence of characters in a string.
'''
class Solution:
    def longestBeautifulSubstring(self, word: str) -> int:
        list_a,res = [], 0
        dict_map = {'a':1,'e':2,'i':3,'o':4,'u':5}
        for i, c in enumerate(word):
            if c == 'a':
                list_a.append(i)
        
        for start in list_a:
            idx = start
            
            while idx + 1 < len(word) and 0<= (dict_map[word[idx + 1]] - dict_map[word[idx]]) <= 1: 
                idx += 1
            
            if word[idx] == 'u':
                res = max(res, idx - start + 1)
        return res