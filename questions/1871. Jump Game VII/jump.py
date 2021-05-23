'''
You are given a 0-indexed binary string s and two integers minJump and maxJump. In the beginning, you are standing at index 0, which is equal to '0'. You can move from index i to index j if the following conditions are fulfilled:

i + minJump <= j <= min(i + maxJump, s.length - 1), and
s[j] == '0'.
Return true if you can reach index s.length - 1 in s, or false otherwise.
'''
class Solution:
    def canReach(self, s: str, minJump: int, maxJump: int) -> bool:
        if s[-1] != '0':
            return False
        queue = collections.deque()
        queue.append(0)
        mx = 0
        while queue:
            idx = queue.popleft()
            if idx == len(s) - 1:
                return True
            for step in range(max(idx + minJump, mx + 1), min(idx + maxJump + 1, len(s))):
                if s[step] == '0':
                    queue.append(step)
            mx = idx + maxJump
        return False