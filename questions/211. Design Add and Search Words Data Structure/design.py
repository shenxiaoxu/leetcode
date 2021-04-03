'''
Design a data structure that supports adding new words and finding if a string matches any previously added string.

Implement the WordDictionary class:

WordDictionary() Initializes the object.
void addWord(word) Adds word to the data structure, it can be matched later.
bool search(word) Returns true if there is any string in the data structure that matches word or false otherwise. word may contain dots '.' where dots can be matched with any letter.
'''
class TrieNode:
    def __init__(self, char = ''):
        self.children = collections.defaultdict(TrieNode)
        self.wordEnd = False
class WordDictionary:
    def __init__(self):
        self.root = TrieNode()
    def dfs(self, word, idx, cur):
        if idx == len(word):
            if cur.wordEnd:
                self.res = True
            return
        
        char = word[idx]        
        if char != '.':
            if char not in cur.children:
                return            
            self.dfs(word, idx + 1, cur.children[char])
        else:    
            for childK, childV in cur.children.items():
                self.dfs(word, idx + 1, childV)
        
    def addWord(self, word):
        cur = self.root
        for char in word:
            cur = cur.children[char]
        cur.wordEnd = True
    
    def search(self, word):
        
        cur = self.root
        self.res = False
        self.dfs(word, 0, cur)
        return self.res