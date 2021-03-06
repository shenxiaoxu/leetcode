'''
There is a new alien language that uses the English alphabet. However, the order among letters are unknown to you.

You are given a list of strings words from the dictionary, where words are sorted lexicographically by the rules of this new language.

Derive the order of letters in this language, and return it. If the given input is invalid, return "". If there are multiple valid solutions, return any of them.
'''
class Solution(object):
    def alienOrder(self, words):
        """
        :type words: List[str]
        :rtype: str
        """
        order = collections.defaultdict(list)
        letter = [0 for _ in range(26)]
        res = ""
        for word in words:
            for i, v in enumerate(word):
                order[v] = list()
        #{'a':{},'b':{}, 'c':{}}    
        #print(string_list)
        for i in range(1, len(words)):
            word2 = words[i]
            word1 = words[i - 1]
            count = 0
            for j in range(min(len(word1), len(word2))):
                if word1[j] == word2[j]: 
                    count += 1
                    continue
                else:
                    if word2[j] not in order[word1[j]]:
                        order[word1[j]].append(word2[j])
                        letter[ord(word2[j]) - ord('a')] += 1
                    break
            if count == len(word2) and len(word1) != len(word2):
                return ""
        #{t:[f],w:[e],r:[t],e:[r]}
        #{z:[x],x:[z]}
        #{c:[b],a:[z]}
        #print(order)
        #print(degree)
        #print(string_list)
        queue = collections.deque()
        for i in range(26):
            if letter[i] == 0 and chr(ord('a') + i) in order:
                queue.append(chr(ord('a') + i))

        while queue:
            c = queue.popleft()
            res += c
            for key in order[c]:
                letter[ord(key) - ord('a')] -= 1
                if letter[ord(key) - ord('a')] == 0:
                    queue.append(key)
                    
        if len(res) != len(order):
            return ""
        #letter = [0 for i in range(26)]
        #print(letter)
        
        return res
        
                