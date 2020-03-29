import java.util.*;

public class Main{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-->0){
            int n = sc.nextInt();
            int[] a = new int[n];
            for(int i=0; i<n;i++){
                a[i] = sc.nextInt();
            }

            int count = 0;
            for(int i=0;i<n;i++){
                for(int j=i;j<n;j++){
                    long sum = 0, mul = 1;
                    for(int k=i; k<=j; k++){
                        sum+=a[k];
                        mul*=a[k];
                    }
                    if(sum==mul) count++;
                }
            }
            System.out.println(count);
        }
        sc.close();
    }
}