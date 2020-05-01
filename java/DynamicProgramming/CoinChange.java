import java.util.*;
public class CoinChange {
    static long[][] dp;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();
        }
        int N = sc.nextInt();

        dp = new long[n+1][N+1];
        
        System.out.println(coinChange_i(N, arr, n));
    }
    

    private static long coinChange(int N, int[] arr , int n) {
        if(N==0) return 1;
        if(n==0) return 0;
        if(N<0) return 0;
        if(dp[n][N]>0) return dp[n][N];
        long output = coinChange(N-arr[n-1], arr, n) + coinChange(N, arr, n-1);
        dp[n][N] = output;
        return output;
    }
    
    private static long coinChange_i(int N, int[] arr, int n) {

       long[][] dp = new long[N+1][n];
        for(int i=0;i<n;i++){
            dp[0][i]=1;
        }
        for(int i=1;i<=N;i++){
            for(int j=0;j<n;j++){
                long x = ( i - arr[j]>=0 )? dp[i - arr[j]][j] : 0;
                long y = ( j>0 ) ? dp[i][j-1]: 0;
                dp[i][j]=x+y;
            }
        }
        for(int i=0;i<=N;i++){
            System.out.println(Arrays.toString(dp[i]));
        }
        return dp[N][n-1];
    }
}