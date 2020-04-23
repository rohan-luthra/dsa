package Algorithms.Easy;
import java.util.*;

public class InsertionSort1 {

    // Complete the insertionSort1 function below.
    static void insertionSort1(int n, int[] arr) {
    

        // starting from the last element
        for(int i=n-1;i>=1;i--){
            // comparing the i and i-1 element
            // if yes swap and print
            if(arr[i] < arr[i-1]){
                for(int j=0;j<n;j++){
                    // printing the bigger number
                    if(j==i) System.out.print(arr[i-1]+" ");
                    else System.out.print(arr[j]+" ");
                }
                // swapping
                int temp = arr[i];
                arr[i]=arr[i-1];
                arr[i-1]=temp;
                System.out.println();


            }else{
                // else breal
                break;
            }
        }

        for(int i=0;i<n;i++)
            System.out.print(arr[i]+" ");     

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

        insertionSort1(n, arr);

        scanner.close();
    }
}
