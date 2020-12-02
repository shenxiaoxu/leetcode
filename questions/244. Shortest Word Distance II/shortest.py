class WordDistance(object):
	def __init__(self, words):
		self.words = words
		self.storage = collections.defaultdict(list)
		for i in range(len(words)):
			self.storage[words[i]].append(i)
	def shortest(self, word1, word2):
		l1, l2 = self.storage[word1], self.storage[word2]
		#print(l2)
		p1,p2, res = 0, 0, float('inf')
		while p1 < len(l1) and p2 < len(l2):
			res = min(res, abs(l1[p1]-l2[p2]))
			if l1[p1] < l2[p2]:
				p1 += 1
			else:
				p2 += 1
		return res
