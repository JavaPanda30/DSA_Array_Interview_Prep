import java.util.* ;
import java.io.*; 
import java.util.ArrayList;

public class Solution {

    public static int[] missingAndRepeating(ArrayList<Integer> arr, int n) {
        // Write your code here
        int ans[]=new int[2];
        int sum=(n*(n+1))/2;
        int csum=0;
        HashMap<Integer,Integer> a = new HashMap<>();
        for(int i=0;i<arr.size();i++)
        {
            csum+=arr.get(i);
            if(a.containsKey(arr.get(i)))
            {
                a.put(arr.get(i),a.get(arr.get(i))+1);
            }
            else
            {
                a.put(arr.get(i),1);
            }
        }
        for(Map.Entry<Integer, Integer> E: a.entrySet())
        {
            if(E.getValue()==2)
            {
            ans[1]=E.getKey();
            break;
            }
        }
        ans[0]=Math.abs(sum-(csum-ans[1]));
        //System.gc();
        return ans;
    }
}

//Using math
// for(int i=1;i<=arr.size();i++)
//         {
//             if(!arr.contains(i))
//             {
//                 ans[0]=i;
//                 sum-=i;
//             }
//         }
//         for(int i: arr)
//         {
//             sum-=i;
//         }
//         ans[1]=Math.abs(sum);
//         return ans;


//Most Optimal Approach




// import java.util.*;

// public class tUf {

//     public static int[] findMissingRepeatingNumbers(int[] a) {
//         long n = a.length; // size of the array
//         // Find Sn and S2n:
//         long SN = (n * (n + 1)) / 2;
//         long S2N = (n * (n + 1) * (2 * n + 1)) / 6;

//         // Calculate S and S2:
//         long S = 0, S2 = 0;
//         for (int i = 0; i < n; i++) {
//             S += a[i];
//             S2 += (long)a[i] * (long)a[i];
//         }

//         //S-Sn = X-Y:
//         long val1 = S - SN;

//         // S2-S2n = X^2-Y^2:
//         long val2 = S2 - S2N;

//         //Find X+Y = (X^2-Y^2)/(X-Y):
//         val2 = val2 / val1;

//         //Find X and Y: X = ((X+Y)+(X-Y))/2 and Y = X-(X-Y),
//         // Here, X-Y = val1 and X+Y = val2:
//         long x = (val1 + val2) / 2;
//         long y = x - val1;

//         int[] ans = {(int)x, (int)y};
//         return ans;
//     }

//     public static void main(String[] args) {
//         int[] a = {3, 1, 2, 5, 4, 6, 7, 5};
//         int[] ans = findMissingRepeatingNumbers(a);
//         System.out.println("The repeating and missing numbers are: {"
//                            + ans[0] + ", " + ans[1] + "}");
//     }
// }
