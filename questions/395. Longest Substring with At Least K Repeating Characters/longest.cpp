/*
395. Longest Substring with At Least K Repeating Characters
Given a string s and an integer k, return the length of the longest substring of s such that 
the frequency of each character in this substring is greater than or equal to k.

Example 1:

Input: s = "aaabb", k = 3
Output: 3
Explanation: The longest substring is "aaa", as 'a' is repeated 3 times.
Example 2:

Input: s = "ababbc", k = 2
Output: 5
Explanation: The longest substring is "ababb", as 'a' is repeated 2 times and 'b' is repeated 3 times.
*/
#include <iostream>
#include <string>
#include <vector>
using namespace std;
class longest{
public:
	int longestSub(string& txt, int k){
		vector<int> cou(26, 0);
		int n = 0, res = 0;
		for(char c: txt){
			if(cou[c-'a'] == 0)
				n++; 
			cou[c-'a']++;
		}
		for(int i = 1; i <= n; i++){
			vector<int> cur(26,0);
			int left = 0, right = 0, nolargerthank = 0, unique = 0;
			while(right < txt.size()){
				if(unique <= i){
					int idx = txt[right]-'a';
					if(cur[idx] == 0){
						unique++;
					}
					cur[idx]++;
					if(cur[idx] == k){
						nolargerthank++;
					}
					right++;
				}else{
					int idx = txt[left] - 'a';
					if(cur[idx] == k){
						nolargerthank--;
					}
					cur[idx]--;
					if(cur[idx] == 0){
						unique--;
					}
					left++;
				}
				if(unique == i && nolargerthank == unique){
					res = max(res, right - left);
				}
			}
		}
		return res;
	}
};
int main(){
	longest l;
	string c = "baaabcb";
	cout<< l.longestSub(c, 3);
}
