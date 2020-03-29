package Basic;

import java.util.*;

/**
 * Simple factorial function
 * Basic recurssion
 */

public class Factorial{

    public static void main(String[] args) {
        int n;
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        System.out.println(fact(n));
    }

    static int fact(int n){
        if(n==1)
        return 1;
        else
        return n * fact(n-1);
    }

}