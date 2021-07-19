'''
A square triple (a,b,c) is a triple where a, b, and c are integers and a2 + b2 = c2.

Given an integer n, return the number of square triples such that 1 <= a, b, c <= n.
'''
class Solution:
    def countTriples(self, n: int) -> int:
        c_s = set()
        res = 0
        for i in range(1,n + 1):
            c_s.add(pow(i, 2))
        for i in range(1, n + 1):
            for j in range(i + 1, n + 1):
                if pow(i, 2) + pow(j, 2) in c_s:
                    #print(i,j)
                    res += 2
        return res