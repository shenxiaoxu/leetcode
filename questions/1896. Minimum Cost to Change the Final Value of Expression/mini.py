'''
You are given a valid boolean expression as a string expression consisting of the characters '1','0','&' (bitwise AND operator),'|' (bitwise OR operator),'(', and ')'.

For example, "()1|1" and "(1)&()" are not valid while "1", "(((1))|(0))", and "1|(0&(1))" are valid expressions.
Return the minimum cost to change the final value of the expression.

For example, if expression = "1|1|(0&0)&1", its value is 1|1|(0&0)&1 = 1|1|0&1 = 1|0&1 = 1&1 = 1. We want to apply operations so that the new expression evaluates to 0.
The cost of changing the final value of an expression is the number of operations performed on the expression. The types of operations are described as follows:

Turn a '1' into a '0'.
Turn a '0' into a '1'.
Turn a '&' into a '|'.
Turn a '|' into a '&'.
Note: '&' does not take precedence over '|' in the order of calculation. Evaluate parentheses first, then in left-to-right order.
'''
class Solution:
    def minOperationsToFlip(self, E: str) -> int:
        def cor(s):
            d,stack = {},[]
            for i,c in enumerate(s):
                if c == '(':
                    stack.append(i)
                elif c == ')':
                    last = stack.pop()
                    d[i] = last
            return d
        
        def dfs(beg, end):
            if beg == end: return (int(E[beg]),1)
            beg2 = d.get(end, end)
            if beg2 == beg: return dfs(beg + 1, end - 1)
            p1, c1 = dfs(beg, beg2 - 2)
            p2, c2 = dfs(beg2, end)
            op = E[beg2 - 1]
            t = {"|": lambda x, y: x|y, "&": lambda x, y: x&y}
            c3 = 1 if p1 + p2 == 1 else min(c1, c2) + (p1^ (op == "&"))
            return (t[op](p1, p2), c3)
        d = cor(E)
        return dfs(0, len(E) - 1)[1]