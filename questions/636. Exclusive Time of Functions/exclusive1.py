class Solution:
    def exclusiveTime(self, n: int, logs: List[str]) -> List[int]:
        time = [0]*n
        stack = []
        prev = 0
        for log in logs:
            log_list = log.split(":")            
            task_num, sign, timestamp = int(log_list[0]), log_list[1], int(log_list[2])         
            if sign == "start":
                if stack:
                    time[stack[-1]] += timestamp - prev                                   
                stack.append(task_num)
                prev = timestamp
            else:
                time[stack.pop()] += timestamp - prev + 1
                prev = timestamp + 1
            
        return time