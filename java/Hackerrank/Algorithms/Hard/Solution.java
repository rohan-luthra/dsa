package Algorithms.Hard;

import java.util.*;

public class Solution {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while(t-->0){
            int n = sc.nextInt();
            int[] arr = new int[n];
            for(int i=0; i<n; i++){
                arr[i] = sc.nextInt();
            }
            System.out.println(inversionCount(arr, 0 ,n-1));
        }

    }


    /**
     * Solution:
     * A Variation of merger sort.
     * Splitting the problem into smaller problems - i.e. 2 Arrays
     * Getting Soltion for boht the arrays and sorting them
     * Merging the Arrays, and return count the number of smaller items at the left
     * 
     * @param a
     * @param low
     * @param high
     * @return
     */

    static long inversionCount(int[] a, int low, int high){
        long count = 0;
        if(low<high){
            int mid = (low+high)/2;
            // solution of the first array
            count += inversionCount(a, low, mid);
            // solution of the second array
            count += inversionCount(a, mid+1, high);
            // getting count on merging
            count += mergeCount(a, low, mid+1, high);
        }
        return count;

    }
    

    // merging function

    static long mergeCount(int[] a, int left, int mid, int right){
    
        int i=left, j=mid, k=0;
        int[] t = new int[ (right-left+1)];
        long count = 0;
        while( i<mid && j<=right){
            if(a[i]<=a[j]) t[k++] = a[i++];
            else{
                t[k++] = a[j++];
                // number of items smaller jth element = mid- i
                count += (mid - i);
            }
        }

        while(i<mid) t[k++] = a[i++];
        while(j<=right) t[k++] = a[j++];

        for( i=left, k=0; i<=right; i++, k++ ){
            a[i]=t[k];
        }
        return count;
    }

}