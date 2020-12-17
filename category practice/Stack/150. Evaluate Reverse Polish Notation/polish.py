'''
150. Evaluate Reverse Polish Notation

Evaluate the value of an arithmetic expression in Reverse Polish Notation.

Valid operators are +, -, *, /. Each operand may be an integer or another expression.

Note:

Division between two integers should truncate toward zero.
The given RPN expression is always valid. That means the expression would always evaluate to a result and there won't be any divide by zero operation.
Input: ["2", "1", "+", "3", "*"]
Output: 9
Explanation: ((2 + 1) * 3) = 9
'''
import math
class Solution(object):
	def evalRPN(self, nums):
		operand = []
		for i in nums:
			if i == '+':
				operand.append(operand.pop()+operand.pop())
			elif i == '-':
				num1 = operand.pop()
				num2 = operand.pop()
				operand.append(num2-num1)
			elif i == '*':
				operand.append(operand.pop()*operand.pop())
			elif i == '/':
				num1 = operand.pop()
				num2 = float(operand.pop())
				operand.append(math.trunc(num2/num1))
			else:
				operand.append(int(i))
			
		return operand[0]
if __name__ == "__main__":
	nums = ["2", "1", "+", "3", "*"]
	nums2 = ["10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"]
	o = Solution()
	print(o.evalRPN(nums2))
