'''
You are given a 2D integer array orders, where each orders[i] = [pricei, amounti, orderTypei] denotes that amounti orders have been placed of type orderTypei at the price pricei. The orderTypei is:

0 if it is a batch of buy orders, or
1 if it is a batch of sell orders.
Note that orders[i] represents a batch of amounti independent orders with the same price and order type. All orders represented by orders[i] will be placed before all orders represented by orders[i+1] for all valid i.

There is a backlog that consists of orders that have not been executed. The backlog is initially empty. When an order is placed, the following happens:

If the order is a buy order, you look at the sell order with the smallest price in the backlog. If that sell order's price is smaller than or equal to the current buy order's price, they will match and be executed, and that sell order will be removed from the backlog. Else, the buy order is added to the backlog.
Vice versa, if the order is a sell order, you look at the buy order with the largest price in the backlog. If that buy order's price is larger than or equal to the current sell order's price, they will match and be executed, and that buy order will be removed from the backlog. Else, the sell order is added to the backlog.
Return the total amount of orders in the backlog after placing all the orders from the input. Since this number can be large, return it modulo 109 + 7.
'''
class Solution:
    def getNumberOfBacklogOrders(self, orders: List[List[int]]) -> int:
        maxheap, minheap = [],[]
        for p, v, t in orders:
            if t == 0:
                heapq.heappush(maxheap,[-p, v])
            else:
                heapq.heappush(minheap,[p, v])
            while maxheap and minheap and -maxheap[0][0] >= minheap[0][0]:
                k = min(maxheap[0][1], minheap[0][1])
                maxheap[0][1] -= k
                minheap[0][1] -= k
                if maxheap[0][1] == 0: heapq.heappop(maxheap)
                if minheap[0][1] == 0: heapq.heappop(minheap)
        return sum(v for p, v in maxheap + minheap) % (10**9 + 7)