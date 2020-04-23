package Algorithms.Easy;

import java.io.*;
import java.util.*;

public class ClosestNumber {

    // Complete the closestNumbers function below.
    static int[] closestNumbers(int[] a) {

        // sorting the array first
        Arrays.sort(a);
        
        // minimum differnece can be calculated within consecutive elements
        // finding the minimum difference and count of such pairs
        long min = Long.MAX_VALUE;
        int minCount = 0;
        for(int i=0;i<a.length-1;i++){
            if( (a[i+1]-a[i]) < min ) { min = a[i+1] - a[i]; minCount = 1;}
            else if( a[i+1]-a[i] == min ) minCount++;
        }
        
        // adding pairs with difference min to result array
        int[] arr = new int[minCount*2];
        int k = 0;
        for(int i=0; i<a.length-1;i++){
            if((a[i+1]-a[i]) == min ) {
                arr[k++] = a[i];
                arr[k++] = a[i+1];
            }
        }

        return arr;
        
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

        int[] result = closestNumbers(arr);

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
