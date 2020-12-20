'''
You are given a phone number as a string number. number consists of digits, spaces ' ', and/or dashes '-'.

You would like to reformat the phone number in a certain manner. Firstly, remove all spaces and dashes. 
Then, group the digits from left to right into blocks of length 3 until there are 4 or fewer digits. The final digits are then grouped as follows:

2 digits: A single block of length 2.
3 digits: A single block of length 3.
4 digits: Two blocks of length 2 each.
The blocks are then joined by dashes. Notice that the reformatting process should never produce any blocks of length 1 and produce at most two blocks of length 2.

Return the phone number after formatting.
'''
class Solution:
	def reformatNumber(self, nums):
		res = nums.replace("-","").replace(" ","")
		#print(res)
		resList = []
		while len(res) > 4:
			resList.append(res[:3])
			res = res[3:]
		if len(res) == 2 or len(res) == 3:
			resList.append(res)
		else:
			resList.append(res[:2])
			resList.append(res[2:])
		return "-".join(resList)
if __name__ == "__main__":
	number = "123 4-567"
	num1 = "1-23-45 6"
	num2 = "--17-5 229 35-39475 "
	o = Solution()
	print(o.reformatNumber(number))
	print(o.reformatNumber(num1))
	print(o.reformatNumber(num2))
