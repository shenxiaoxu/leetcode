'''
This is an interactive problem.

There is a robot in a hidden grid, and you are trying to get it from its starting cell to the target cell in this grid. The grid is of size m x n, and each cell in the grid is either empty or blocked. It is guaranteed that the starting cell and the target cell are different, and neither of them is blocked.

Each cell has a cost that you need to pay each time you move to the cell. The starting cell's cost is not applied before the robot moves.

You want to find the minimum total cost to move the robot to the target cell. However, you do not know the grid's dimensions, the starting cell, nor the target cell. You are only allowed to ask queries to the GridMaster object.
'''
# """
# This is GridMaster's API interface.
# You should not implement it, or speculate about its implementation
# """
#class GridMaster(object):
#    def canMove(self, direction: str) -> bool:
#        
#
#    def move(self, direction: str) -> int:
#        
#
#    def isTarget(self) -> None:
#        
#

class Solution(object):

    def findShortestPath(self, master: 'GridMaster') -> int:

                
        def dfs(x, y):
            nonlocal target, visited_set
            pos = (x, y)
            if target is None and master.isTarget():
                target = pos
            visited_set.add(pos)
            
            for dic in move_map:
                d1, d2 = move_map[dic]
                if master.canMove(dic):
                    neigh = (x + d1, y + d2)
                    graph[pos].add(neigh)
                    graph[neigh].add(pos)
                    if (pos, neigh) not in cost:
                        cost[(pos, neigh)] = master.move(dic)
                        if neigh not in visited_set:
                            dfs(*neigh)
                        cost[(neigh, pos)] = master.move(returned_map[dic])
        
        def dijistra(start, target, graph, cost):
            pq = [(0, start)]
            visited = collections.defaultdict(lambda: math.inf)
            
            while pq:
                total, pos = heapq.heappop(pq)
                if pos == target:
                    return total
                
                for nei in graph[pos]:
                    cost_after_move = total + cost[(pos, nei)]
                    if visited[nei] > cost_after_move:
                        visited[nei] = cost_after_move
                        heapq.heappush(pq, (cost_after_move, nei))
            return -1
                        
        move_map = {"U": (-1,0),
                   "D": (1,0),
                   "L": (0,-1),
                   "R": (0,1)}
        returned_map = {"U":"D",
                   "D":"U",
                   "L":"R",
                   "R":"L"}  

        visited_set = set()
        
        start = (0,0)
        graph = collections.defaultdict(set)
        cost = collections.defaultdict(lambda: math.inf)
        target = None
        
        dfs(*start)
        
        if not target:
            return -1
        
        #print(cost)

        
        return dijistra(start, target, graph, cost)
                        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
