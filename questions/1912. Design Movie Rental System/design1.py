from sortedcontainers import SortedList
class MovieRentingSystem:

    def __init__(self, n: int, entries: List[List[int]]):
        self.shop = defaultdict(SortedList) # movie->(price,shop)
        self.shop_movie = {} #(shop, movie)->price
        self.rented = SortedList()#(price, shops, movies)
        for s, m, p in entries:
            self.shop[m].add((p, s))
            self.shop_movie[(s, m)] = p

    def search(self, movie: int) -> List[int]:
        return [y for _,y in self.shop[movie][:5]]

    def rent(self, shop: int, movie: int) -> None:
        price = self.shop_movie[(shop, movie)]
        self.rented.add((price, shop, movie))
        self.shop[movie].remove((price, shop))

    def drop(self, shop: int, movie: int) -> None:
        price = self.shop_movie[(shop, movie)]
        self.rented.remove((price, shop, movie))
        self.shop[movie].add((price, shop))

    def report(self) -> List[List[int]]:
        return [[s,m] for _,s,m in self.rented[:5]]
        


# Your MovieRentingSystem object will be instantiated and called as such:
# obj = MovieRentingSystem(n, entries)
# param_1 = obj.search(movie)
# obj.rent(shop,movie)
# obj.drop(shop,movie)
# param_4 = obj.report()