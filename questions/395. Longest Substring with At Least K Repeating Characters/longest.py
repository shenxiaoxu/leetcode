'''
395. Longest Substring with At Least K Repeating Characters
Given a string s and an integer k, return the length of the longest substring of s such that 
the frequency of each character in this substring is greater than or equal to k.

Example 1:

Input: s = "aaabb", k = 3
Output: 3
Explanation: The longest substring is "aaa", as 'a' is repeated 3 times.
Example 2:

Input: s = "ababbc", k = 2
Output: 5
Explanation: The longest substring is "ababb", as 'a' is repeated 2 times and 'b' is repeated 3 times.
'''
class Solution(object):
	def longestSubstring(self, txt, k):
		count = set()
		for c in txt:
			count.add(c)
		n, res= len(count), 0
		for i in range(1, n + 1):
			left, right, no, uni = 0, 0, 0, 0
			cur = [0]*26;
			while right < len(txt):
				if uni <= i:
					idx = ord(txt[right])-97
					#print(idx)
					if cur[idx] == 0:
						uni += 1
					cur[idx] += 1
					if cur[idx] == k:
						no += 1
					right+=1
				else:
					idx = ord(txt[left]) - 97
					if cur[idx] == k:
						no -= 1
					cur[idx] -= 1
					if cur[idx] == 0:
						uni -= 1
					left += 1
				if uni == i and uni == no:
					res = max(res, right - left)
		return res
if __name__ == "__main__":
	l = longest()
	print(l.lon("baaabcb",3))

