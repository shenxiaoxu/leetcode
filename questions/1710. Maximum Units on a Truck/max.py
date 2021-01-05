'''
You are assigned to put some amount of boxes onto one truck. You are given a 2D array boxTypes, where boxTypes[i] = [numberOfBoxesi, numberOfUnitsPerBoxi]:

numberOfBoxesi is the number of boxes of type i.
numberOfUnitsPerBoxi is the number of units in each box of the type i.
You are also given an integer truckSize, which is the maximum number of boxes that can be put on the truck. You can choose any boxes to put 
on the truck as long as the number of boxes does not exceed truckSize.

Return the maximum total number of units that can be put on the truck.
'''
from typing import List
class Solution:
	def max(self, boxes:List[List[int]], truckSize:int)->int:
		boxes = sorted(boxes, key = lambda x:x[1])
		#print(boxes)
		res = 0
		i = len(boxes) - 1
		while truckSize > 0 and i > -1:
			num = min(truckSize, boxes[i][0]) 
			truckSize -= num
			res += num * boxes[i][1]
			i -= 1
		return res
if __name__ == "__main__":
	boxTypes = [[1,3],[2,2],[3,1]]
	truckSize = 4
	o = Solution()
	print(o.max(boxTypes, truckSize))
	boxTypes = [[1,3],[5,5],[2,5],[4,2],[4,1],[3,1],[2,2],[1,3],[2,5],[3,2]]
	truckSize = 35
	print(o.max(boxTypes, truckSize))