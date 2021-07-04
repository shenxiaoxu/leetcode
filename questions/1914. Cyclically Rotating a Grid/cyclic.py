'''
You are given an m x n integer matrix grid​​​, where m and n are both even integers, and an integer k.

The matrix is composed of several layers, which is shown in the below image, where each color is its own layer:



A cyclic rotation of the matrix is done by cyclically rotating each layer in the matrix. To cyclically rotate a layer once, each element in the layer will take the place of the adjacent element in the counter-clockwise direction. An example rotation is shown below:


Return the matrix after applying k cyclic rotations to it.
'''
class Solution:
    def rotateGrid(self, grid: List[List[int]], k: int) -> List[List[int]]:
        m = len(grid)
        n = len(grid[0])
        layer = min(m,n)//2
        for i in range(layer):
            ele = []
            for top in range(i, n - i):
                ele.append(grid[i][top])
            #print(ele)
            for right in range(i + 1, m - i):
                ele.append(grid[right][n - i - 1])
            #print(ele)
            for down in range(n - i - 2, i - 1, -1):
                ele.append(grid[m - i - 1][down])
            #print(ele)
            for left in range(m - i - 2, i, -1):
                ele.append(grid[left][i])
            #print(ele)
            fre = k%len(ele)
            new_ele = ele[fre:] + ele[:fre]
            pos = 0
            for top in range(i, n - i):
                grid[i][top] = new_ele[pos]
                pos += 1
            #print(ele)
            for right in range(i + 1, m - i):
                grid[right][n - i - 1] = new_ele[pos]
                pos += 1
            #print(ele)
            for down in range(n - i - 2, i - 1, -1):
                grid[m - i - 1][down] = new_ele[pos]
                pos += 1
            #print(ele)
            for left in range(m - i - 2, i, -1):
                grid[left][i] = new_ele[pos]
                pos += 1
        return grid
            