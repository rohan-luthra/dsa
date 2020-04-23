import java.util.*;
public class PowerOf2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        // if N & N-1 == 0
        // Bitwise operations
        if( (n & (n-1))==0) System.out.println("YES");
        else System.out.println("NO"); 
    }


}