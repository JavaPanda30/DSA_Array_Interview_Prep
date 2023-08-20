// Return the longest length of subarray with given sum


//Brute Force(3 loops)

// public class Solution {
//     public static int longestSubarrayWithSumK(int []a, long k) {
//         // Write your code here
//         int max=Integer.MIN_VALUE;
//        for(int i=0;i<a.length;i++)
//        {
//            for(int j=i;j<a.length;j++)
//            {
//                int sum=0;
//                for(int m=i;m<=j;m++)
//                {
//                    sum+=a[m];
//                }
//                if(sum==k)
//                {
//                    max=Math.max(max,j-i+1);
//                }
//            }
//        }
//        return max;
//     }
// }


//Better Brute Approach(2 loops)

//  public class Solution {
//     public static int longestSubarrayWithSumK(int []a, long k) {
//         // Write your code here
//         int max=Integer.MIN_VALUE;
//        for(int i=0;i<a.length;i++)
//        {
//            int sum=0;
//            for(int j=i;j<a.length;j++)
//            {
//                sum+=a[j];
//                if(sum==k)
//                {
//                    max=Math.max(max,j-i+1);
//                }
//            }
//        }
//        return max;
//     }
// }

// Better Approach (using hashmap or Two Pointer)

// import java.util.HashMap;
// public class Solution {
//     public static int longestSubarrayWithSumK(int []a, long k) {
//         // Write your code here
//     int maxlen=0;
//     int prfxsum=0;
//     HashMap<Integer, Integer> ans=new HashMap<>();
//     for(int i=0;i<a.length;i++)
//     {
//         prfxsum+=a[i];
//         if(prfxsum==k)
//         {
//             maxlen=Math.max(maxlen, i+1);
//         }
//         int rem=prfxsum-(int)k;
//         if(ans.containsKey(rem))
//         {
//             maxlen=Math.max(maxlen,i-ans.get(rem));
//             ans.put(prfxsum, i);
//         }
//         else  if(!ans.containsKey(rem)&& a[i]!=0)
//         {
//             ans.put(prfxsum, i);
//         }
//     }
//     return maxlen;
//     }
// }


// Two Pointer

// public class Solution {
//     public static int longestSubarrayWithSumK(int []a, long k) {
//         // Write your code here
//     int high=0,low=0;
//     int maxlen=0;
//     int pref=a[0];
//     while(high<a.length)
//     {
//         while(low<=high && pref>k)
//         {
//             pref-=a[low];
//             low++;
//         }
//         if(pref==k)
//         {
//             maxlen=Math.max(maxlen, high-low+1);
//         }
//         high++;
//         if(high<a.length)
//         {
//             pref+=a[high];
//         }
//     }
//     return maxlen;
//     }
// }

