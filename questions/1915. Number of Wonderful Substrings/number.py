'''
A wonderful string is a string where at most one letter appears an odd number of times.

For example, "ccjjc" and "abab" are wonderful, but "ab" is not.
Given a string word that consists of the first ten lowercase English letters ('a' through 'j'), return the number of wonderful non-empty substrings in word. If the same substring appears multiple times in word, then count each occurrence separately.

A substring is a contiguous sequence of characters in a string.
'''
class Solution:
    def wonderfulSubstrings(self, word: str) -> int:
        res = 0
        used = {}
        for i in range(len(word)):
            dic = {}
            time = 0 
            for j in range(i, len(word)):
                if word[i:j + 1] in used:
                    t = used[word[i:j + 1]]
                    if t <= 1:
                        #print(word[i:j + 1], t)
                        res += 1
                    continue
                c = word[j]
                if c not in dic:
                    dic[c] = 1
                    time += 1
                else:
                    dic[c] += 1
                    if dic[c] % 2 == 0:
                        time -= 1
                    else:
                        time += 1
                used[word[i:j + 1]] = time
                #print(word[i:j + 1], time)
                if time <= 1:
                    res += 1
        return res