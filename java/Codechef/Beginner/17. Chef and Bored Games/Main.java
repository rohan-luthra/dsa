import java.util.*;

public class Main{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while(t-->0){
            int n = sc.nextInt();
            int count = 0;
            for(int i=0;i<n;i++){
                if(i%2==0) count += (n-i)*(n-i);
            }
            System.out.println(count);
        }
        sc.close();
    }
}