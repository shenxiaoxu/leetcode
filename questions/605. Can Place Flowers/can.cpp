/*
605. Can Place Flowers
Easy

You have a long flowerbed in which some of the plots are planted, and some are not. However, flowers cannot be planted in adjacent plots.

Given an integer array flowerbed containing 0's and 1's, where 0 means empty and 1 means not empty, and an integer n, 
return if n new flowers can be planted in the flowerbed without violating the no-adjacent-flowers rule.

 

Example 1:

Input: flowerbed = [1,0,0,0,1], n = 1
Output: true
*/
class Solution {
public:
	bool canPlaceFlowers(vector<int>& a, int n){
        if(n == 0) return true;
		if(a.size() == 0 || n > a.size()) return false;
		if(a.size() == 1) return a[0]==0;
		int count = 0;
		for(int i = 0; i < a.size() && count < n; i++){
			if(a[i]==0){
				if(i == 0 && i + 1 < a.size() && a[i + 1] != 1){
					count += 1;
					a[i] = 1;
				}else if(i == a.size() - 1 && i - 1 >= 0 && a[i - 1] != 1){
					count += 1;
					a[i] = 1;
				}else if(i > 0 && i != a.size() - 1 && a[i - 1] != 1 && a[i + 1] != 1){
					count += 1;
					a[i] = 1;
				}
			}
		}
		return count == n;		
	}
};
