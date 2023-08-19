// Given two non-decreasing sorted arrays, 'A' and 'B', having 'N' and 'M'
// elements, respectively. You must merge these arrays, 'A' and 'B', into a sorted
// array without using extra space. Of all the 'N + M' sorted elements, array 'A'
// should contain the first 'N' elements, and array 'B' should have the last 'M'
// elements.


//BRUTE FORCE

// public class Solution {
//     public static void mergeTwoSortedArraysWithoutExtraSpace(long []a, long []b){
//         // Write your code here.
//         long c[]=new long[a.length+b.length];
//         int l=0,r=0,m=0;
//         while(l<a.length && r<b.length)
//         {
//             if(a[l]<=b[r])
//             {
//             c[m++]=a[l];
//             l++;
//             }
//             else
//             {
//             c[m++]=b[r];
//             r++;
//             }
//         }
//         while(l<a.length)
//         {
//             c[m++]=a[l++];
//         }
//         while(r<b.length)
//         {
//             c[m++]=b[r++];
//         }
//         for(int i=0;i<a.length;i++)
//         {
//             a[i]=c[i];
//         }
//         int n=0;
//         for(int i=a.length;i<c.length;i++)
//         {
//             b[n++]=c[i];
//         }
//     }
// }



//OPTIMAL CODE

import java.util.Arrays;
public class Solution {
    public static void mergeTwoSortedArraysWithoutExtraSpace(long []a, long []b){
        // Write your code here.
        int last=a.length-1,first=0;
        while(a[last]>b[first])
        {
            long temp=a[last];
            a[last]=b[first];
            b[first]=temp;
            last--;first++;
        }
        Arrays.sort(a);
        Arrays.sort(b);
    }
}