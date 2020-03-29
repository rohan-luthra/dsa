import java.util.*;

public class Main{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-->0){
            int d = sc.nextInt();
            int n = sc.nextInt();
            System.out.println(sumD(d, n));
        }
        sc.close();
    }

    static int sumD(int d, int n){
        if(d==1)
            return sum(n);
        else{
            return sumD(d-1, sum(n));
        }
    }

    static int sum(int n){
        int s = 0;
        for(int i=1;i<=n;i++) s+=i;
        return s;
    }
}