import java.util.*;

public class Main{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while(t-->0){
            int n = sc.nextInt();
            int res = 0;
            for(int i=1;i<=n;i++){
                int x = sc.nextInt();
                int y = sc.nextInt();
                res=res^i;
            }
            System.out.println(res);
        }
        sc.close();
    }
}