'''
You are given n​​​​​​ tasks labeled from 0 to n - 1 represented by a 2D integer array tasks, where tasks[i] = [enqueueTimei, processingTimei] means that the i​​​​​​th​​​​ task will be available to process at enqueueTimei and will take processingTimei to finish processing.

You have a single-threaded CPU that can process at most one task at a time and will act in the following way:

If the CPU is idle and there are no available tasks to process, the CPU remains idle.
If the CPU is idle and there are available tasks, the CPU will choose the one with the shortest processing time. If multiple tasks have the same shortest processing time, it will choose the task with the smallest index.
Once a task is started, the CPU will process the entire task without stopping.
The CPU can finish a task then start a new one instantly.
Return the order in which the CPU will process the tasks.
'''
class Solution:
    def getOrder(self, tasks: List[List[int]]) -> List[int]:
        res = []
        task_list = sorted([t[0], t[1], i] for i, t in enumerate(tasks))
        time = task_list[0][0]
        pq = []
        i = 0
        while len(res) < len(tasks):
            while i < len(tasks) and time >= task_list[i][0]:
                heapq.heappush(pq,[task_list[i][1], task_list[i][2]])
                i += 1
            if pq:
                process, idx = heapq.heappop(pq)
                time += process
                res.append(idx)
            elif i < len(tasks):
                time = tasks[i][0]
        return res
            