/*
Given an array arr of positive integers sorted in a strictly increasing order, and an integer k.

Find the kth positive integer that is missing from this array.
*/
class Solution {
    public int findKthPositive(int[] arr, int k) {
        int lo = 0, hi = arr.length;
        while(lo < hi){
            int mid = lo + (hi - lo)/2;
            if(arr[mid] - (mid + 1) < k){
                lo = mid + 1;
            }else{
                hi = mid;
            }
        }
        return lo + k;
    }
}