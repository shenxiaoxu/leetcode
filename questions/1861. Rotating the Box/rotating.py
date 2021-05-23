'''
You are given an m x n matrix of characters box representing a side-view of a box. Each cell of the box is one of the following:

A stone '#'
A stationary obstacle '*'
Empty '.'
The box is rotated 90 degrees clockwise, causing some of the stones to fall due to gravity. Each stone falls down until it lands on an obstacle, another stone, or the bottom of the box. Gravity does not affect the obstacles' positions, and the inertia from the box's rotation does not affect the stones' horizontal positions.

It is guaranteed that each stone in box rests on an obstacle, another stone, or the bottom of the box.

Return an n x m matrix representing the box after the rotation described above.
'''
class Solution:
    def rotateTheBox(self, box: List[List[str]]) -> List[List[str]]:
        m,n = len(box), len(box[0])
        res = [[0]*m for _ in range(n)]
        for i in range(m):
            for j in range(n):
                res[j][m - i - 1] = box[i][j]
        #print(res)
        for i in range(m):
            for j in range(n - 1, -1, -1):
                ele = res[j][i]
                while j + 1 < n and res[j + 1][i] == '.' and res[j][i] == '#':
                    tmp = res[j][i]
                    res[j][i] = res[j + 1][i]
                    res[j + 1][i] = tmp
                    j += 1
        return res
                