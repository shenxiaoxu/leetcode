'''
You are playing a solitaire game with three piles of stones of sizes a​​​​​​, b,​​​​​​ and c​​​​​​ respectively. Each turn you choose two different non-empty piles, take one stone from each, and add 1 point to your score. The game stops when there are fewer than two non-empty piles (meaning there are no more available moves).

Given three integers a​​​​​, b,​​​​​ and c​​​​​, return the maximum score you can get.
'''
class Solution:
    def maximumScore(self, a: int, b: int, c: int) -> int:
        max_heap, res = [], 0
        for i in (a,b,c):
            heapq.heappush(max_heap, -i)
        while len(max_heap) >= 2:
            first = heapq.heappop(max_heap)
            second = heapq.heappop(max_heap)
            #print(first)
            #print(second)
            #print("one loop")
            if first + 1 != 0:
                heapq.heappush(max_heap,first + 1)
            
            if second + 1 != 0:
                heapq.heappush(max_heap,second + 1)
            res += 1
        return res