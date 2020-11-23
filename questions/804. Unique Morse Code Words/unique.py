class Solution:
    def uniqueMorseRepresentations(self, words: List[str]) -> int:
        d = [".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."]
        return len({''.join(d[ord(i) - ord('a')] for i in w) for w in words})
        
