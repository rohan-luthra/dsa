
import java.util.*;

public class ChangeFirstSetbit {
    public static void main(String[] args) {
     
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        System.out.println(returnFirstSetBit(n));

    }

    public static int returnFirstSetBit(int n) {
        //Write your code here
        
        return n - (n & (-1 * n));
	}

}