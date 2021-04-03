'''
Given a file and assume that you can only read the file using a given method read4, implement a method read to read n characters. Your method read may be called multiple times.

Method read4:

The API read4 reads four consecutive characters from file, then writes those characters into the buffer array buf4.

The return value is the number of actual characters read.

Note that read4() has its own file pointer, much like FILE *fp in C.
'''
# The read4 API is already defined for you.
# def read4(buf4: List[str]) -> int:

class Solution:
    def __init__(self):
        self.queue = []
    def read(self, buf: List[str], n: int) -> int:
        i = 0
        while i < n:
            if self.queue:
                buf[i] = self.queue.pop(0)
                i += 1
            else:
                buf4 = ['']*4
                v = read4(buf4)
                if not v:
                    break
                self.queue += buf4[:v]
            
        return i