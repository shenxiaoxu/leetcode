class Solution:
    def kthSmallest(self, matrix: List[List[int]], k: int) -> int:
        queue = []
        m, n, res = len(matrix), len(matrix[0]), 0
        for i in range(min(m, k)):
            heapq.heappush(queue,(matrix[i][0], i, 0))
        while k > 0:
            num, row, col = heapq.heappop(queue)
            res = num
            if col + 1 < n:
                heapq.heappush(queue, (matrix[row][col + 1], row, col + 1))
            k -= 1
        return num
        
