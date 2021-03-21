'''
Implement the RandomizedSet class:

RandomizedSet() Initializes the RandomizedSet object.
bool insert(int val) Inserts an item val into the set if not present. Returns true if the item was not present, false otherwise.
bool remove(int val) Removes an item val from the set if present. Returns true if the item was present, false otherwise.
int getRandom() Returns a random element from the current set of elements (it's guaranteed that at least one element exists when this method is called). Each element must have the same probability of being returned.
'''
class RandomizedSet:

    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.pos = []
        self.dict = {}

    def insert(self, val: int) -> bool:
        """
        Inserts a value to the set. Returns true if the set did not already contain the specified element.
        """
        if val in self.dict:
            return False
        self.pos.append(val)
        self.dict[val] = len(self.pos) - 1
        return True
        

    def remove(self, val: int) -> bool:
        """
        Removes a value from the set. Returns true if the set contained the specified element.
        """
        if val not in self.dict:
            return False
        idx = self.dict[val]
        lastval = self.pos[len(self.pos) - 1]
        self.pos[idx] = lastval
        self.pos.pop()
        self.dict[lastval] = idx
        del self.dict[val]
        return True
        

    def getRandom(self) -> int:
        """
        Get a random element from the set.
        """
        return self.pos[random.randint(0, len(self.pos) - 1)]
        


# Your RandomizedSet object will be instantiated and called as such:
# obj = RandomizedSet()
# param_1 = obj.insert(val)
# param_2 = obj.remove(val)
# param_3 = obj.getRandom()