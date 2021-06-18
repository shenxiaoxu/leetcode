'''
You are given an array of strings words (0-indexed).

In one operation, pick two distinct indices i and j, where words[i] is a non-empty string, and move any character from words[i] to any position in words[j].

Return true if you can make every string in words equal using any number of operations, and false otherwise.
'''
class Solution:
    def makeEqual(self, words: List[str]) -> bool:
        if len(words) <= 1:
            return True
        m = collections.defaultdict(int)
        for word in words:
            for c in word:
                m[c] += 1
        #print(m)
        for key, val in m.items():
            if val % len(words) != 0:
                return False
        return True