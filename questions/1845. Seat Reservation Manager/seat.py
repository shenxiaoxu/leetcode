'''
Design a system that manages the reservation state of n seats that are numbered from 1 to n.

Implement the SeatManager class:

SeatManager(int n) Initializes a SeatManager object that will manage n seats numbered from 1 to n. All seats are initially available.
int reserve() Fetches the smallest-numbered unreserved seat, reserves it, and returns its number.
void unreserve(int seatNumber) Unreserves the seat with the given seatNumber.
'''
class SeatManager:

    def __init__(self, n: int):
        self.heapq = []
        for i in range(1, n + 1):
            heapq.heappush(self.heapq, i)
        self.v = [0]*n
            

    def reserve(self) -> int:
        num = heapq.heappop(self.heapq)
        self.v[num - 1] = 1
        return num

    def unreserve(self, seatNumber: int) -> None:
        self.v[seatNumber - 1] = 0
        heapq.heappush(self.heapq, seatNumber)
        


# Your SeatManager object will be instantiated and called as such:
# obj = SeatManager(n)
# param_1 = obj.reserve()
# obj.unreserve(seatNumber)