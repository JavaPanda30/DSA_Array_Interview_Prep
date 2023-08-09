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
         anslist.sort(new Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                return Integer.compare(a[0], b[0]);
            }
        });

        return anslist;
    }
}
