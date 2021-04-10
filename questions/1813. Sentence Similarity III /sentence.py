'''
A sentence is a list of words that are separated by a single space with no leading or trailing spaces. For example, "Hello World", "HELLO", "hello world hello world" are all sentences. Words consist of only uppercase and lowercase English letters.

Two sentences sentence1 and sentence2 are similar if it is possible to insert an arbitrary sentence (possibly empty) inside one of these sentences such that the two sentences become equal. For example, sentence1 = "Hello my name is Jane" and sentence2 = "Hello Jane" can be made equal by inserting "my name is" between "Hello" and "Jane" in sentence2.

Given two sentences sentence1 and sentence2, return true if sentence1 and sentence2 are similar. Otherwise, return false.


'''
class Solution:
    def areSentencesSimilar(self, s1: str, s2: str) -> bool:
        l1 = s1.split()
        l2 = s2.split()
        if len(l1) > len(l2):
            return self.areSentencesSimilar(s2, s1)

        i = 0
        while i < len(l1) and l1[i] == l2[i]:
            i += 1
        while i < len(l1) and l1[i] == l2[len(l2) - len(l1) + i]:
            i += 1
        return i == len(l1)