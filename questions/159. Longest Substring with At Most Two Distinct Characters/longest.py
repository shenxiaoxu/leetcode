class Solution:
    def lengthOfLongestSubstringTwoDistinct(self, s: str) -> int:
        l, res, left, right = len(s), 0, 0, 0
        dic = defaultdict(int)
        while right < l:
            dic[s[right]] += 1
            if len(dic) > 2:
                while len(dic) > 2:
                    dic[s[left]] -= 1
                    if dic[s[left]] == 0:
                        del dic[s[left]]
                    left += 1
            res = max(res, right - left + 1)
            right += 1
        return res
                    
        
