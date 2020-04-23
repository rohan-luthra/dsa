import java.util.*;

public class MergeSort{
    public static void main(String[] args) {
        
        int[] arr = new int[]{1,25,125,536,236,2362,77,5,7368382,484,8344,234,6,2,5,7,2,53,7,2,7,2};
        System.out.println(Arrays.toString(arr));
        mergeSort(arr, 0, arr.length-1);
        System.out.println(Arrays.toString(arr));

    }

    static void mergeSort(int[] a, int low, int high){

        if(low<high){
            int mid = (low+high)/2;
            mergeSort(a, low, mid);
            mergeSort(a, mid+1, high);
            merge(a, low, mid+1, high);
        }
        
    }

    static void merge(int[] a, int low, int mid, int high){

        int i=low, j=mid, k=0;
        int[] t = new int[ (high-low+1)];
        while( i<mid && j<=high){
            if(a[i]<=a[j]) t[k++] = a[i++];
            else t[k++] = a[j++];
        }
        while(i<mid) t[k++] = a[i++];
        while(j<=high) t[k++] = a[j++];
        for( i=low, k=0; i<=high; i++, k++ ) a[i]=t[k];

    }

}