'''
Given a string s of '(' , ')' and lowercase English characters. 

Your task is to remove the minimum number of parentheses ( '(' or ')', in any positions ) so that the resulting parentheses string is valid and return any valid string.

Formally, a parentheses string is valid if and only if:

It is the empty string, contains only lowercase characters, or
It can be written as AB (A concatenated with B), where A and B are valid strings, or
It can be written as (A), where A is a valid string.
'''
class Solution(object):
    def minRemoveToMakeValid(self, s):
        """
        :type s: str
        :rtype: str
        """
        invalid_set = set()
        stack,res = [],""
        for i in range(len(s)):
            if s[i] == '(':
                stack.append(i)
            elif s[i] == ')':
                if stack and s[stack[-1]]== '(':
                    stack.pop()
                else:
                    invalid_set.add(i)
        while stack:
            invalid_set.add(stack[-1])
            stack.pop()
        for i in range(len(s)):
            if i not in invalid_set:
                res+=s[i]
        return res
        