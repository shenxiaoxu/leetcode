class Solution:
    def atMostNGivenDigitSet(self, digits: List[str], n: int) -> int:
        s = str(n)
        l, dl, res = len(s), len(digits), 0
        for i in range(1, l):
            res += pow(dl, i)
        for i in range(l):
            sameNum = False
            for st in digits:
                if st[0] < s[i]:
                    res += pow(dl, l - i - 1)
                elif st[0] == s[i]:
                    sameNum = True
            if not sameNum:
                return res
        return res + 1
