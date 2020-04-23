package DataStructures.Easy;

import java.util.*;

public class RotateArray {



    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        String[] nd = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nd[0]);

        int d = Integer.parseInt(nd[1]);

        int[] a = new int[n];

        String[] aItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int aItem = Integer.parseInt(aItems[i]);
            a[i] = aItem;
        }

        scanner.close();


        // Using a temp array
        // Splitting the array into two parts
        // a[0..d] a[d..n]
        // final shifted array -> a[d..n]+a[0..d]

        // storing a[0..d] to temp
        int[] temp = new int[d];
        for(int i=0;i<d;i++){
            temp[i]=a[i];
        }

        // shifting array
        for(int i=0;i<n-d;i++){
            a[i]=a[i+d];
        }

        // add temp to arr
        for(int i=n-d, k=0 ;i<n && k<d; i++, k++){
            a[i]=temp[k];
        }

        for(int i=0;i<n;i++){
            System.out.print(a[i]+" ");
        }
        

    }
}
