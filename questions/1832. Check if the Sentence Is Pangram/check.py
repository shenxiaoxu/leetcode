'''
A pangram is a sentence where every letter of the English alphabet appears at least once.

Given a string sentence containing only lowercase English letters, return true if sentence is a pangram, or false otherwise.
'''
class Solution:
    def checkIfPangram(self, sentence: str) -> bool:
        s = set()
        for c in sentence:
            s.add(c)
        return len(s) == 26