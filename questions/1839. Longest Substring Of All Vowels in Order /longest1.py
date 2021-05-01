class Solution:
    def longestBeautifulSubstring(self, word: str) -> int:
        res = 0
        lo = -1
        seen = set()
        for hi, c in enumerate(word):
            if hi > 0 and c < word[hi - 1]:
                lo = hi - 1
                seen = set() 
            seen.add(c)
            if len(seen) == 5:
                res = max(res, hi - lo)
        return res