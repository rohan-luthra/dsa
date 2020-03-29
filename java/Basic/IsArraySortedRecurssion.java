package Basic;

/**
 * Check if array is sorted using Recurssion
 * 
 * Sol-
 *      check if a[start] < a[start+1]
 *      and check if the rest of the array is sorted or not
 * 
 */

import java.util.*;

public class IsArraySortedRecurssion{
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        for(int i=0; i<n ; i++){
            a[i] = sc.nextInt();
        }
        if(isSorted(a, 0, a.    ))
            System.out.println("Yes");
        else
            System.out.println("No");
    }

    static boolean isSorted(int a[], int s, int n){
        System.out.println(s);
        if(n <= 1)
            return true;
        else if(a[s] > a[s+1])
            return false;
        else
            return isSorted(a, s+1, n-1);
    }

}