'''
You are given two integers memory1 and memory2 representing the available memory in bits on two memory sticks. There is currently a faulty program running that consumes an increasing amount of memory every second.

At the ith second (starting from 1), i bits of memory are allocated to the stick with more available memory (or from the first memory stick if both have the same available memory). If neither stick has at least i bits of available memory, the program crashes.

Return an array containing [crashTime, memory1crash, memory2crash], where crashTime is the time (in seconds) when the program crashed and memory1crash and memory2crash are the available bits of memory in the first and second sticks respectively.
'''
class Solution:
    def memLeak(self, memory1: int, memory2: int) -> List[int]:
        if not memory1 and not memory2:
            return [1,0,0]
        n = 1
        while True:
            if memory1 >= memory2:
                memory1 -= n
            else:
                memory2 -= n
            n += 1
            if max(memory1, memory2) < n:
                break
        return [n, memory1, memory2]