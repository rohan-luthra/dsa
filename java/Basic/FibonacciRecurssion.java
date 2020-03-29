package Basic;

/**
 * BASIC FIBONACCI using RECURSSION
 * 
 */

import java.util.*;

public class FibonacciRecurssion{
    public static void main(final String[] args) {
        final Scanner sc = new Scanner(System.in);
        final int n = sc.nextInt();

        System.out.println(fibonacci(n));
    }

    static int fibonacci(final int n) {
        if(n<2){
            return n;
        }else{
            return fibonacci(n -1) + fibonacci(n-2);
        }

    }
}