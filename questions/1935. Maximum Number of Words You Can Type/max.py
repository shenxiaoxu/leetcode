'''
There is a malfunctioning keyboard where some letter keys do not work. All other keys on the keyboard work properly.

Given a string text of words separated by a single space (no leading or trailing spaces) and a string brokenLetters of all distinct letter keys that are broken, return the number of words in text you can fully type using this keyboard.
'''
class Solution:
    def canBeTypedWords(self, text: str, brokenLetters: str) -> int:
        words = text.split(" ")
        broken = set()
        count = 0
        for c in brokenLetters:
            broken.add(c)
        for word in words:
            find = False
            for c in word:
                if c in broken:
                    find = True
                    break
            if not find:
                count += 1
        return count