'''
You are given coordinates, a string that represents the coordinates of a square of the chessboard. Below is a chessboard for your reference.
'''
class Solution:
    def squareIsWhite(self, c: str) -> bool:
        return ord(c[0]) %2 != (int)(c[1]) %2