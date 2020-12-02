class Solution(object):
	def skyline(self, buildings):
		events = [(L, -H, R) for L, R, H in buildings] + list({(R, 0, 0) for _, R, _ in buildings})
		events.sort()
		live = [(0,float("inf"))]
		res = [[0,0]]
		for Pos, NegH, R in events:
			while live[0][1] <= Pos: heappop(live)
			if NegH:
				heappush(live, (NegH, R))
			if res[-1][1] != -live[0][0]:
				res += [[Pos, -live[0][0]]]
		return res[1:]
