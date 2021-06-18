class Solution:
    def maximumRemovals(self, s: str, p: str, removable: List[int]) -> int:
        def exist(s, p, remove_list):
            remove_set = set(remove_list)
            p1,p2 = 0,0
            
            while p1 < len(s) and p2 < len(p):
                if p1 in remove_set:
                    p1 += 1
                    continue
                if s[p1] != p[p2]:
                    p1 += 1
                else:
                    p1 += 1
                    p2 += 1
            return p2 == len(p)
        
        lo, hi = 0, len(removable)
        while lo < hi:
            mid = lo + (hi - lo)//2 + 1
            if exist(s, p, removable[:mid]):
                lo = mid
            else:
                hi = mid - 1
        return lo