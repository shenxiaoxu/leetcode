/*
4. Median of Two Sorted Arrays
Hard

There are two sorted arrays nums1 and nums2 of size m and n respectively.

Find the median of the two sorted arrays. The overall run time complexity should be O(log (m+n)).

You may assume nums1 and nums2 cannot be both empty.

Example 1:

nums1 = [1, 3]
nums2 = [2]

The median is 2.0
Example 2:

nums1 = [1, 2]
nums2 = [3, 4]

The median is (2 + 3)/2 = 2.5

*/

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
public class FindMedianSortedArray
{

    public static void main(String[] args)
    {
        int[] array1 = {3,5,10,11,17};
        int[] array2 = {9,13,20,21,23,27};
        System.out.println(findMedianSortedArray(array1, array2,0,array1.length - 1,0,array2.length - 1));
    }
    public static int findMedianSortedArray(int[] array1, int[] array2, int startA, int endA, int startB, int endB){

       int m = array1.length;
       int n = array2.length;
       if(array1[m - 1] < array2[0]){
           if((m + n)%2 == 1){
              return array2[(m + n + 1)/2 - m - 1];
           }else{
              return (array2[(m + n + 1)/2 - m - 1] + array2[(m + n + 1)/2 - m])/2;
           }
       }
       if(array2[n - 1] < array1[0]){
           if((m + n)%2 == 1){
              return array1[(m + n + 1)/2 - n - 1];
           }else{
              return (array1[(m + n + 1)/2 - n - 1] + array1[(m + n + 1)/2 - n])/2;
           }        
       }
       int i = (startA + endA)/2;
       int j = (m + n + 1)/2 - i - 2;
       if(j < 0){
          j = 0;
       }
       int result = 0;
       if((m + n)% 2 == 1){
          if(array1[i + 1] > array2[j] && array2[j + 1] > array1[i]){;
            return Math.max(array1[i], array2[j]);
          }else if(array1[i + 1] < array2[j]){
              return findMedianSortedArray(array1, array2, i, m, 0, j);
          }else if (array2[j + 1] < array1[i]){
              return findMedianSortedArray(array1, array2, 0, i, j, n);
          }
       }else{
          if(array1[i + 1] > array2[j] && array2[j + 1] > array1[i]){
            result = (Math.max(array1[i], array2[j]) + Math.min(array1[i + 1], array2[j + 1]))/2;
            return result;
          }
          else if(array1[i + 1] < array2[j]){
              return findMedianSortedArray(array1, array2, i, m, 0, j);
          }else if (array2[j + 1] < array1[i]){
              return findMedianSortedArray(array1, array2, 0, i, j, n);
          }          
       }
       return result;
    }
}