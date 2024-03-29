'''
In a garden represented as an infinite 2D grid, there is an apple tree planted at every integer coordinate. The apple tree planted at an integer coordinate (i, j) has |i| + |j| apples growing on it.

You will buy an axis-aligned square plot of land that is centered at (0, 0).

Given an integer neededApples, return the minimum perimeter of a plot such that at least neededApples apples are inside or on the perimeter of that plot.

The value of |x| is defined as:

x if x >= 0
-x if x < 0
'''
class Solution:
    def minimumPerimeter(self, x: int) -> int:
        l = 1
        r = 100000
        while l < r:
            m = l + (r - l)//2
            if m*(m + 1)*(m + m + 1)*2 >= x:
                r = m
            else:
                l = m + 1
        return l*8