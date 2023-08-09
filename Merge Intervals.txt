/*
 *Question
 *Given an array of intervals, merge all the overlapping intervals and return an array of non-overlapping intervals.
 */

// BRUTE FORCE

import java.util.Arrays;
import java.util.List;
import java.util.*;

public class Solution {
    public static List< List< Integer > > mergeOverlappingIntervals(int [][]arr){
        // Write your code here.
        int n=arr.length;
        Arrays.sort(arr, new Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                return a[0] - b[0];
            }
        });
        List< List< Integer > > ans = new ArrayList<>();
        for(int i=0;i<n;i++)
        {
            int start = arr[i][0];
            int end = arr[i][1];
            if(!ans.isEmpty() && end<=ans.get(ans.size()-1).get(1))
            {continue;}
            for(int j=i+1;j<n;j++)
            {
                if(arr[j][0]<=end)
                {
                    end=Math.max(end,arr[j][1]);
                }
                else
                {break;}
            }
            ans.add(Arrays.asList(start,end));
        }
        return ans;

    }
}


// OPTIMAL CODE

import java.util.Arrays;
import java.util.List;
import java.util.*;

public class Solution {
    public static List< List< Integer > > mergeOverlappingIntervals(int [][]arr){
        // Write your code here.
        int n=arr.length;
        Arrays.sort(arr, new Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                return a[0] - b[0];
            }
        });
        List< List< Integer > > ans = new ArrayList<>();
        for(int i=0;i<n;i++)
        {
            if(ans.isEmpty() || arr[i][0]>ans.get(ans.size()-1).get(1))
            {
                ans.add(Arrays.asList(arr[i][0],arr[i][1]));
            }
            else {
                ans.get(ans.size() - 1).set(1,Math.max(ans.get(ans.size() - 1).get(1), arr[i][1]));
            }
        }
        return ans;

    }
}