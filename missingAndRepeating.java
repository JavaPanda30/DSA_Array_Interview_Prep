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