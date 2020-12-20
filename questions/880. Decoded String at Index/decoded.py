'''
880. Decoded String at Index
Medium

An encoded string S is given.  To find and write the decoded string to a tape, the encoded string is read one character at a time and the following steps are taken:

If the character read is a letter, that letter is written onto the tape.
If the character read is a digit (say d), the entire current tape is repeatedly written d-1 more times in total.
Now for some encoded string S, and an index K, find and return the K-th letter (1 indexed) in the decoded string.
'''
class Solution:
	def decodeAtIndex(self, encoded, k):
		cur, times = "", 0
		for i in encoded:
			if i.isdigit():
				times = int(i)
				while times != 1:
					cur += cur
					times -= 1
				if k <= len(cur):
					return cur[k - 1]
			else:
				cur += str(i)
	def decodeAtIndexOne(self, encoded, k):
		N = 0
		for i, c in enumerate(encoded):
			if c.isdigit():
				N = N*int(c)
			else:
				N += 1
			if k <= N:
				break
		for j in range(i, -1, -1):
			c = encoded[j]
			if c.isdigit():
				N /= int(c)
				k %= N
			else:
				if k == 0 or k == N: return c
				N -= 1

if __name__ == "__main__":
	S = "a2345678999999999999999"
	o = Solution()
	print(o.decodeAtIndexOne(S, 1))