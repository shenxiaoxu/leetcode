'''
Given two strings s and part, perform the following operation on s until all occurrences of the substring part are removed:

Find the leftmost occurrence of the substring part and remove it from s.
Return s after removing all occurrences of part.

A substring is a contiguous sequence of characters in a string.
'''
class Solution:
    def removeOccurrences(self, s: str, part: str) -> str:
        stack = []
        for i in range(len(s)):
            stack.append(s[i])
            while stack and stack[-1] == part[-1] and len(stack) >= len(part):
                lis = []
                pos = len(part) - 1
                while pos >= 0 and stack[-1] == part[pos]:
                    lis.append(stack.pop())
                    pos -= 1
                if pos != -1:#mean pop charcaters doesn't match stack
                    stack.extend(lis[::-1])
                    break
        #print(stack)
        return "".join(stack)
                    