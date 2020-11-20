class Solution:
    def decodeString(self, s: str) -> str:
        stack = []
        curNum, curStr = 0, ''
        for c in s:
            if c == '[':
                stack.append(curNum)
                stack.append(curStr)
                curNum = 0
                curStr = ''
            elif c == ']':
                prev = stack.pop()
                num = stack.pop()
                curStr = prev + num*curStr
            elif c.isdigit():
                curNum = curNum*10 + int(c)
            else:
                curStr += c
        return curStr
        
