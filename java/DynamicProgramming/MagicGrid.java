import java.util.*;
public class MagicGrid {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-->0){
            int n = sc.nextInt();
            int m = sc.nextInt();
            int[][] arr = new int[n][m];
            for(int i=0; i<n; i++){
                for(int j=0; j<m; j++){
                    arr[i][j] = sc.nextInt();
                }
            }

            System.out.println(magicGrid_dp_iter(arr, n, m));

        }
    }


    private static int magicGrid_dp_iter(int[][] arr , int n, int m) {

        int[][] dp = new int[n][m];
        dp[n-1][m-1]=1;
        
        for(int i=n-2; i>=0; i--){
            dp[i][m-1] = dp[i+1][m-1] - arr[i+1][m-1];
            if(dp[i][m-1]<1) dp[i][m-1]=1;
        }

        for(int i=m-2; i>=0; i--){
            dp[n-1][i] = dp[n-1][i+1] - arr[n-1][i+1];
            if(dp[n-1][i]<1) dp[n-1][i]=1;
        }

        

        for(int i=n-2; i>=0; i--){
            for(int j=m-2; j>=0; j--){
                int opt1 = dp[i+1][j] - arr[i+1][j];
                if(opt1 < 1) opt1 = 1;
                int opt2 = dp[i][j+1] - arr[i][j+1];
                if(opt2 < 1) opt2 = 1;
                dp[i][j] = Math.min(opt1, opt2);
            }
        }

        for(int i=0;i<n;i++)
            System.out.println(Arrays.toString(dp[i]));
        

        return dp[0][0];
    }
}