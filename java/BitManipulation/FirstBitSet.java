import java.util.*;

public class FirstBitSet {
    public static void main(String[] args) {
     
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        System.out.println(returnFirstSetBit(n));

    }

    public static int returnFirstSetBit(int n) {
        //Write your code here
        

        // for(int i=0;i<32;i++){
        //     if( (n& (1<<i)) !=0 ) return (1<<i);
        // }
        // return 0;


        return n & (-1 * n);
	}

}