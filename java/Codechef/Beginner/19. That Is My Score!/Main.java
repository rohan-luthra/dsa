import java.util.*;

public class Main{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while(t-->0){
            int n = sc.nextInt();
            int[] a = new int[11];
            Arrays.fill(a, 0);
            for(int i=0; i<n; i++){
                int p = sc.nextInt();
                int s = sc.nextInt();
                if( p < 9){
                        if( s > a[p-1] ) a[p-1]=s;
                }
            }
            int sum = 0;
            for(int i=0; i<11; i++){
                sum+=a[i];
            }
            System.out.println(sum);
        }
        sc.close();
    }
}