/*28. Implement strStr()
Easy

1286

1694

Add to List

Share
Implement strStr().

Return the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.

Example 1:

Input: haystack = "hello", needle = "ll"
Output: 2
Example 2:

Input: haystack = "aaaaa", needle = "bba"
Output: -1
Clarification:

What should we return when needle is an empty string? This is a great question to ask during an interview.

For the purpose of this problem, we will return 0 when needle is an empty string. This is consistent to C's strstr() and Java's indexOf().*/
class Solution {
    public int strStr(String haystack, String needle) {
       int L = needle.length();
       int n = haystack.length();
       int pn = 0;
       int pL = 0;
       while(pn < n - L + 1){
       	while(pn < n - L + 1 && haystack.charAt(pn) != needle.charAt(0)){
       		++pn;
       	}
       	int currenLen = 0;
       	pL = 0;
       	while(pn < n - L + 1 && pL < L && needle.charAt(pL) == haystack.charAt(pn)){
       		++currenLen;
       		++pn;
       		++pL;
       	}
       	if(currenLen == L) return pn - L;
       	pn = pn - currenLen + 1;
       }
       return -1;
    }
}