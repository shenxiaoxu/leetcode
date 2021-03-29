'''
Given two strings s and t, return the minimum window in s which will contain all the characters in t. If there is no such window in s that covers all characters in t, return the empty string "".

Note that If there is such a window, it is guaranteed that there will always be only one unique minimum window in s.
'''
class Solution:
    def minWindow(self, s: str, t: str) -> str:
        t_map = Counter(t)
        required = len(t_map)
        window = collections.defaultdict(int)
        left, right, num = 0,0,0
        res, short_len = "", float('inf')
        while right < len(s):
            window[s[right]] += 1
            if s[right] in t_map and window[s[right]] == t_map[s[right]]:
                num += 1
            if num == required:
                while num == required and left <= right:
                    if right - left + 1 < short_len:
                        short_len = right - left + 1
                        res = s[left:right + 1]
                    window[s[left]] -= 1
                    if s[left] in t_map and window[s[left]] < t_map[s[left]]:
                        num -= 1
                    left += 1
            right += 1
        return res