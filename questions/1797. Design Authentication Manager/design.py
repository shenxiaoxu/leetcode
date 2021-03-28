'''
There is an authentication system that works with authentication tokens. For each session, the user will receive a new authentication token that will expire timeToLive seconds after the currentTime. If the token is renewed, the expiry time will be extended to expire timeToLive seconds after the (potentially different) currentTime.
'''
class AuthenticationManager:

    def __init__(self, timeToLive: int):
        self.expire_map = collections.defaultdict(int)
        self.timeAdd = timeToLive

    def generate(self, tokenId: str, currentTime: int) -> None:
        self.expire_map[tokenId] = currentTime + self.timeAdd

    def renew(self, tokenId: str, currentTime: int) -> None:
        if tokenId in self.expire_map:
            if self.expire_map[tokenId] > currentTime:
                self.expire_map[tokenId] = currentTime + self.timeAdd
            else:
                del self.expire_map[tokenId]

    def countUnexpiredTokens(self, currentTime: int) -> int:
        res = 0
        del_set = []
        for k, v in self.expire_map.items():
            if v > currentTime:
                res += 1
            else:
                del_set.append(k)
        for k in del_set:
            del self.expire_map[k]
        return res
            


# Your AuthenticationManager object will be instantiated and called as such:
# obj = AuthenticationManager(timeToLive)
# obj.generate(tokenId,currentTime)
# obj.renew(tokenId,currentTime)
# param_3 = obj.countUnexpiredTokens(currentTime)