package Algorithms.Easy;

import java.io.*;
import java.util.*;


public class IceCreamParlour {

    // Complete the icecreamParlor function below.
    static int[] icecreamParlor(int m, int[] a) {

        int[] b = Arrays.copyOf(a, a.length);
        Arrays.sort(a);
        int i=0, j=a.length-1;
        while(i<j){
            if((a[i]+a[j])==m) break;
            if((a[i]+a[j])<m) i++;
            if((a[i]+a[j])>m) j--;
        }
        int[] res = new int[2];
        // System.out.println(Arrays.toString(b));
        // System.out.println(a[i]+" "+a[j]);
        int t = -1;
        for(int k=0;k<b.length;k++){
            if(b[k]==a[i] || b[k]==a[j]){
                t=k;
                res[0]=k+1;
            }
        }
        for(int k=0;k<b.length;k++){
            if((b[k]==a[i] || b[k]==a[j]) && k!=t){
                res[1]=k+1;
            }
        }
        if(res[0]>res[1]){
            int temp = res[0];
            res[0]=res[1];
            res[1]=temp;
        }
        return res;

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int t = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int tItr = 0; tItr < t; tItr++) {
            int m = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            int n = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            int[] arr = new int[n];

            String[] arrItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int i = 0; i < n; i++) {
                int arrItem = Integer.parseInt(arrItems[i]);
                arr[i] = arrItem;
            }

            int[] result = icecreamParlor(m, arr);

            for (int i = 0; i < result.length; i++) {
                bufferedWriter.write(String.valueOf(result[i]));

                if (i != result.length - 1) {
                    bufferedWriter.write(" ");
                }
            }

            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}
