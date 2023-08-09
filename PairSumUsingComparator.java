import java.io.*;
import java.util.* ;

public class Solution{
    public static List<int[]> pairSum(int[] arr, int s) {
        // Write your code here.
        List<int[]> anslist = new ArrayList<int[]>();
        for(int i=0;i<arr.length;i++)
        {
            for(int j=i+1;j<arr.length;j++)
            {
            if(arr[i]+arr[j]==s)
            {
                int ans[]={arr[i],arr[j]};
                Arrays.sort(ans);
                anslist.add(ans);
            }
            }
        }
        //comparator is used in this
         anslist.sort(new Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                return Integer.compare(a[0], b[0]);
            }
        });

        return anslist;
    }
}

/*
 * In this optimized code:

We use a HashMap numCount to store the frequency of numbers encountered in the array.
We iterate through the array once. For each number, we calculate its complement (s - num) and check if it exists in the numCount map. If it does and its frequency is greater than 0, we add the pair to anslist.
After checking for a valid pair, we decrease the frequency of the complement in the map.
Finally, we increase the frequency of the current number in the map.
This optimized solution reduces the time complexity to O(n) by avoiding the nested loops and using a hashmap for efficient lookup of complements.

public class Solution {
    public static List<int[]> pairSum(int[] arr, int s) {
        List<int[]> anslist = new ArrayList<>();
        Map<Integer, Integer> numCount = new HashMap<>();

        for (int num : arr) {
            int complement = s - num;

            if (numCount.containsKey(complement) && numCount.get(complement) > 0) {
                int ans[] = { Math.min(num, complement), Math.max(num, complement) };
                anslist.add(ans);
                numCount.put(complement, numCount.get(complement) - 1);
            }

            numCount.put(num, numCount.getOrDefault(num, 0) + 1);
        }

        return anslist;
    }
 */