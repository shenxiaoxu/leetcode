'''
You have a browser of one tab where you start on the homepage and you can visit another url, get back in the history number of steps or move forward in the history number of steps.

Implement the BrowserHistory class:

BrowserHistory(string homepage) Initializes the object with the homepage of the browser.
void visit(string url) Visits url from the current page. It clears up all the forward history.
string back(int steps) Move steps back in history. If you can only return x steps in the history and steps > x, you will return only x steps. Return the current url after moving back in history at most steps.
string forward(int steps) Move steps forward in history. If you can only forward x steps in the history and steps > x, you will forward only x steps. Return the current url after forwarding in history at most steps.
'''
class BrowserHistory:

    def __init__(self, homepage: str):
        self.visited_list = [homepage]
        self.cursor = 0
        self.bound = 0

    def visit(self, url: str) -> None:
        self.cursor += 1
        if self.cursor == len(self.visited_list):
            self.visited_list.append(url)
        else:
            self.visited_list[self.cursor] = url
        self.bound = self.cursor 

    def back(self, steps: int) -> str:
        self.cursor = max(0, self.cursor - steps)
        return self.visited_list[self.cursor]
        

    def forward(self, steps: int) -> str:
        self.cursor = min(self.bound, self.cursor + steps)
        return self.visited_list[self.cursor]
        


# Your BrowserHistory object will be instantiated and called as such:
# obj = BrowserHistory(homepage)
# obj.visit(url)
# param_2 = obj.back(steps)
# param_3 = obj.forward(steps)