package Algorithms.Easy;
import java.io.*;
import java.util.*;

public class QuickSort1 {

    // Complete the quickSort function below.
    static int[] quickSort(int[] arr) {

        // sorting array arr
        quickSortArray(arr, 0, arr.length-1);
        return arr;

    }

    // quick sort function takes low and high
    static void quickSortArray(int[] arr, int low, int high){

        if(low<high){
            int pivot = partition(arr, low, high);
            quickSortArray(arr, low, pivot-1);
            quickSortArray(arr, pivot+1, high);
        }

    }

    // aranges the array and return the pivot position
    static int partition(int[] a, int low, int high){

        // taking first element as the pivot
        int pivot = a[low];

        // fining all the smaller numbers that pivot
        int small = 0;
        for(int i=low+1; i<=high; i++){
            if(a[i]<pivot) small++;
        }
        // put pivot in its correct position
        int pivotIndex = small+low;
        int temp = a[pivotIndex];
        a[pivotIndex] = a[low];
        a[low] = temp;
        // double pointer apprach to swap elements
        // i->0 j->n-1 until they reach pivot
        // swap elements to follow order
        int i=low, j=high;
        while(i<pivotIndex && j>pivotIndex){
            // chekcing the positions about of elements
            // smaller should be on the left
            // greater on right
            if(a[i]>pivot && a[j]<pivot ){
                // swaping i and j element
                int t = a[i];
                a[i]=a[j];
                a[j]=t;
                i++;j--;
            }else if(a[i] < pivot){
                i++;
            }else if(a[j] > pivot ){
                j--;
            }
        }
        System.out.println(pivotIndex+" "+Arrays.toString(a));
        return pivotIndex;



    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] arr = new int[n];

        String[] arrItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int arrItem = Integer.parseInt(arrItems[i]);
            arr[i] = arrItem;
        }

        int[] result = quickSort(arr);

        for (int i = 0; i < result.length; i++) {
            bufferedWriter.write(String.valueOf(result[i]));

            if (i != result.length - 1) {
                bufferedWriter.write(" ");
            }
        }

        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
