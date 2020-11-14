class Solution:
    def minimumJumps(self, forbidden: List[int], a: int, b: int, x: int) -> int:
        max_v = max([x] + forbidden) + a + b
        arr = [0] + [float('inf')]*max_v
        for pos in forbidden: 
            arr[pos] = -1
        queue = deque()
        queue.append(0);
        while queue:
            cur = queue.popleft();
            if cur + a <= max_v and arr[cur + a] > arr[cur] + 1:
                arr[cur + a] = arr[cur] + 1
                queue.append(cur + a)
            if cur - b > 0 and arr[cur - b] > arr[cur] + 1:
                arr[cur - b] = arr[cur] + 1
                if cur - b + a <= max_v and arr[cur - b + a] > arr[cur] + 2:
                    arr[cur - b + a] = arr[cur] + 2
                    queue.append(cur - b + a)
        return arr[x] if arr[x] != float('inf') else -1
        
