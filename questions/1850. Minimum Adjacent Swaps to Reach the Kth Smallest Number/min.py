'''
You are given a string num, representing a large integer, and an integer k.

We call some integer wonderful if it is a permutation of the digits in num and is greater in value than num. There can be many wonderful integers. However, we only care about the smallest-valued ones.

For example, when num = "5489355142":
The 1st smallest wonderful integer is "5489355214".
The 2nd smallest wonderful integer is "5489355241".
The 3rd smallest wonderful integer is "5489355412".
The 4th smallest wonderful integer is "5489355421".
Return the minimum number of adjacent digit swaps that needs to be applied to num to reach the kth smallest wonderful integer.

The tests are generated in such a way that kth smallest wonderful integer exists.
'''
class Solution:
    def getMinSwaps(self, num: str, k: int) -> int:  
        ori = num
        while k:
            newstr = self.nextPermutation(list(num))
            #print(newstr)
            num = newstr
            k -= 1
        #print(num)
        
        return self.calculate(list(num), list(ori))
    def calculate(self, num:List, ori:List) -> int:
        res = 0
        for i in range(len(num)):
            if num[i] == ori[i]: continue
            idx = i
            #print(idx)
            while i < len(num) and ori[idx] != num[i]:
                i += 1
            #print(i)
            while i < len(num) and idx != i:
                #print(idx)
                tmp = num[i - 1]
                num[i - 1] = num[i]
                num[i] = tmp
                i -= 1
                res += 1
        return res
        
        
    def nextPermutation(self, num: List)-> str:
        end = len(num) - 1
        idx = 0
        
        while end > 0 and num[end - 1] >= num[end]:
            end -= 1
        idx = end - 1
        end = len(num) - 1
        
        while end > 0 and num[end] <= num[idx]:
            end -= 1
        
        tmp = num[idx]
        num[idx] = num[end]
        num[end] = tmp
        
        half = "".join(num[:idx + 1])
        secondhalf = "".join(sorted(num[idx + 1:]))
              
        return half + secondhalf