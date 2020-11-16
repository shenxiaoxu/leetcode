class OrderedStream:

    def __init__(self, n: int):
        self.dic = [""]*(n+1);
        self.ptr = 1

    def insert(self, id: int, value: str) -> List[str]:
        res = []
        self.dic[id] = value
        if self.dic[self.ptr]:
            while self.ptr < len(self.dic) and self.dic[self.ptr] != "":
                res.append(self.dic[self.ptr])
                self.ptr += 1
        return res
        


# Your OrderedStream object will be instantiated and called as such:
# obj = OrderedStream(n)
# param_1 = obj.insert(id,value)
