'''
Given an integer n, return a list of all simplified fractions between 0 and 1 (exclusive) such that the denominator is less-than-or-equal-to n. The fractions can be in any order.
'''
class Solution:
    def simplifiedFractions(self, n: int) -> List[str]:
        res = set()
        for i in range(2, n + 1):
            for j in range(1, i):
                com = math.gcd(i,j)
                #print((i,j,com))
                de = i //com
                up = j // com
                tmp = str(up) + "/" + str(de)
                if tmp not in res:
                    res.add(tmp)
        return list(res)