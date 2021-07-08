'''
Given an array of string words. Return all strings in words which is substring of another word in any order. 

String words[i] is substring of words[j], if can be obtained removing some characters to left and/or right side of words[j].
'''
class Solution:
    def stringMatching(self, words: List[str]) -> List[str]:
        ans = []
        for i, word in enumerate(words):
            for j in range(len(words)):
                if i == j: continue
                if words[j].find(word) != -1:
                    ans.append(word)
                    break
        return ans