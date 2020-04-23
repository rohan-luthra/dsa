package Algorithms.Easy;
import java.util.*;

public class InsertionSort2 {

    // Complete the insertionSort2 function below.
    static void insertionSort2(int n, int[] arr) {

        // insertion sort

        // breaking array into two parts
        // starting with a[0] and a[1...n]
        for(int i=0; i<n-1;i++){
            for(int j=i+1; j>=1; j--){
                // if lower index element (j-1) is greater than j 
                // then swap else break
                if(arr[j-1]>arr[j]){
                    int temp = arr[j-1];
                    arr[j-1]=arr[j];
                    arr[j]=temp;
                }
            }

            // prinitng after each iteration
            for(int k=0;k<n;k++){
                System.out.print(arr[k]+" ");
            }
            System.out.println();
        }

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] arr = new int[n];

        String[] arrItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int arrItem = Integer.parseInt(arrItems[i]);
            arr[i] = arrItem;
        }

        insertionSort2(n, arr);

        scanner.close();
    }
}
