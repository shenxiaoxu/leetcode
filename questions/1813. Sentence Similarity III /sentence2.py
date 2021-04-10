class Solution:
    def areSentencesSimilar(self, sentence1: str, sentence2: str) -> bool:
        dq1, dq2 = map(deque, (sentence1.split(),sentence2.split()))
        while dq1 and dq2 and dq1[0] == dq2[0]:
            dq1.popleft()
            dq2.popleft()
        while dq1 and dq2 and dq1[-1] == dq2[-1]:
            dq1.pop()
            dq2.pop()
        return not dq1 or not dq2