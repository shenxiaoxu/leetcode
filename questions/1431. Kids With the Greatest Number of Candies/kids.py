'''
Given the array candies and the integer extraCandies, where candies[i] represents the number of candies that the ith kid has.

For each kid check if there is a way to distribute extraCandies among the kids such that he or she can have the greatest number of candies among them. Notice that multiple kids can have the greatest number of candies.
'''
class Solution:
    def kidsWithCandies(self, candies: List[int], extraCandies: int) -> List[bool]:
        num_max = max(candies)
        res = [False]*len(candies)
        for i,c in enumerate(candies):
            if c + extraCandies >= num_max:
                res[i] = True
        return res