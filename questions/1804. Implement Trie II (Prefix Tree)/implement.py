'''
A trie (pronounced as "try") or prefix tree is a tree data structure used to efficiently store and retrieve keys in a dataset of strings. There are various applications of this data structure, such as autocomplete and spellchecker.

Implement the Trie class:

Trie() Initializes the trie object.
void insert(String word) Inserts the string word into the trie.
int countWordsEqualTo(String word) Returns the number of instances of the string word in the trie.
int countWordsStartingWith(String prefix) Returns the number of strings in the trie that have the string prefix as a prefix.
void erase(String word) Erases the string word from the trie.
'''
class Node:
    def __init__(self):
        self.children = {}
        self.pcnt = 0
        self.cnt = 0
class Trie:

    def __init__(self):
        self.root = Node()

    def insert(self, word: str) -> None:
        cur = self.root
        cur.pcnt += 1
        for ch in word:
            if ch not in cur.children:
                cur.children[ch] = Node()
            cur = cur.children[ch]
            cur.pcnt += 1
        cur.cnt += 1

    def countWordsEqualTo(self, word: str) -> int:
        cur = self.root
        for ch in word:
            if ch not in cur.children:
                return 0
            cur = cur.children[ch]
        return cur.cnt

    def countWordsStartingWith(self, prefix: str) -> int:
        cur = self.root
        for ch in prefix:
            if ch not in cur.children:
                return 0
            cur = cur.children[ch]
        return cur.pcnt

    def erase(self, word: str) -> None:
        cnt = self.countWordsEqualTo(word)
        if cnt:
            cur = self.root
            cur.pcnt -= 1
            for ch in word:
                cur = cur.children[ch]
                cur.pcnt -=1
            cur.cnt -= 1

# Your Trie object will be instantiated and called as such:
# obj = Trie()
# obj.insert(word)
# param_2 = obj.countWordsEqualTo(word)
# param_3 = obj.countWordsStartingWith(prefix)
# obj.erase(word)