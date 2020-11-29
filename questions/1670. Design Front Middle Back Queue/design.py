'''
1670. Design Front Middle Back Queue
Design a queue that supports push and pop operations in the front, middle, and back.

Implement the FrontMiddleBack class:

FrontMiddleBack() Initializes the queue.
void pushFront(int val) Adds val to the front of the queue.
void pushMiddle(int val) Adds val to the middle of the queue.
void pushBack(int val) Adds val to the back of the queue.
int popFront() Removes the front element of the queue and returns it. If the queue is empty, return -1.
int popMiddle() Removes the middle element of the queue and returns it. If the queue is empty, return -1.
int popBack() Removes the back element of the queue and returns it. If the queue is empty, return -1.
Notice that when there are two middle position choices, the operation is performed on the frontmost middle position choice. For example:

Pushing 6 into the middle of [1, 2, 3, 4, 5] results in [1, 2, 6, 3, 4, 5].
Popping the middle from [1, 2, 3, 4, 5, 6] returns 3 and results in [1, 2, 4, 5, 6].

Input:
["FrontMiddleBackQueue", "pushFront", "pushBack", "pushMiddle", "pushMiddle", "popFront", "popMiddle", "popMiddle", "popBack", "popFront"]
[[], [1], [2], [3], [4], [], [], [], [], []]
Output:
[null, null, null, null, null, 1, 3, 4, 2, -1]

Explanation:
FrontMiddleBackQueue q = new FrontMiddleBackQueue();
q.pushFront(1);   // [1]
q.pushBack(2);    // [1, 2]
q.pushMiddle(3);  // [1, 3, 2]
q.pushMiddle(4);  // [1, 4, 3, 2]
q.popFront();     // return 1 -> [4, 3, 2]
q.popMiddle();    // return 3 -> [4, 2]
q.popMiddle();    // return 4 -> [2]
q.popBack();      // return 2 -> []
q.popFront();     // return -1 -> [] (The queue is empty)
'''
from collections import deque
class design:
	def __init__(self):
		self.q1 = deque()
		self.q2 = deque()
	def pushFront(self, val):
		self.q1.appendleft(val)
	def pushMiddle(self, val):
		self.rebalance(True)
		self.q1.append(val)
	def pushBack(self, val):
		self.q2.append(val)
	def popFront(self):
		if len(self.q1) != 0:
			return self.q1.popleft()
		elif len(self.q2) != 0:
			return self.q2.popleft()
		return -1
	def popMiddle(self):
		self.rebalance(False)
		if len(self.q1) != 0:
			return self.q1.pop()
		else:
			return -1
	def popBack(self):
		if len(self.q2)!=0:
			return self.q2.pop()
		elif len(self.q1) != 0:
			return self.q1.pop()
		return -1
	def rebalance(self, push):
		l1,l2 = len(self.q1),len(self.q2)
		if (l1 + l2)%2==0:
			while l1 < l2:
				self.q1.append(self.q2.popleft())
				l1 += 1
				l2 -= 1
			while l1 > l2:
				self.q2.appendleft(self.q1.pop())
				l1 -= 1
				l2 += 1
		elif push:
			while l1 + 1 < l2:
				self.q1.append(self.q2.popleft())
				l1 += 1
				l2 -= 1
			while l1 + 1 > l2:
				self.q2.appendleft(self.q1.pop())
				l1 -= 1
				l2 += 1
		else:
			while l1 - 1 < l2:
				self.q1.append(self.q2.popleft())
				l1 += 1
				l2 -= 1
			while l1 - 1 > l2:
				self.q2.appendleft(self.q1.pop())
				l1 -= 1
				l2 += 1			
			
if __name__ == "__main__":
	q = design()
	q.pushFront(1)   
	q.pushBack(2)    
	q.pushMiddle(3)
	q.pushMiddle(4)
	
	print(q.popFront())
	print(q.popMiddle())
	print(q.popMiddle())
	print(q.popBack())
	print(q.popFront())



