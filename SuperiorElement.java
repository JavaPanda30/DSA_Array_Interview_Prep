//  Problem Statement
// There is an integer array 'A' of size 'N'.
// Suggest Edit
// An element is called a Superior Element if it is greater than all the elements
// present to its right.
// You must retum a sorted array of all Superior Elements in the array A'.

//Code
import java.util.*;
public class Solution {
    public static List< Integer > superiorElements(int []a) {
        // Write your code here.
        List< Integer > ans = new ArrayList<>();
        int min=a[a.length-1];
        ans.add(a[a.length-1]);
        for(int i=a.length-2;i>=0;i--)
        {
            if(a[i]>min)
            {
                min=a[i];
                ans.add(min);
            }
        }
        Collections.sort(ans);
        return ans;
    }
}
//https://www.codingninjas.com/studio/problems/superior-elements_6783446?utm_source=striver&utm_medium=website&utm_campaign=a_zcoursetuf&leftPanelTab=0