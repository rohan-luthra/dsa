package Algorithms.Easy;

import java.util.*;

public class MiniMaxSum {

    // Complete the miniMaxSum function below.
    static void miniMaxSum(int[] arr) {

        long sum = 0;
        long maxSum = Long.MIN_VALUE;
        long minSum = Long.MAX_VALUE;

        // Calculating the total sum
        for(int i=0; i<arr.length; i++){
            sum += arr[i];
        }

        /**
        *   Calculate the sum without each object 
        *   i.e. sum - arr[i]
        *   Then comparing with MaxSum and MinSum to get the values.
        */
        for(int i=0; i<arr.length; i++){
            long tempSum = sum - arr[i];
            if (tempSum > maxSum) maxSum = tempSum;
            if (tempSum < minSum) minSum = tempSum;
        }

        System.out.print(minSum + " " + maxSum);
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int[] arr = new int[5];

        String[] arrItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < 5; i++) {
            int arrItem = Integer.parseInt(arrItems[i]);
            arr[i] = arrItem;
        }

        miniMaxSum(arr);

        scanner.close();
    }
}
