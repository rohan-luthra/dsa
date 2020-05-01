import java.util.*;

public class MinimumCost{

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // int n = sc.nextInt();
        // int m = sc.nextInt();
        // int[][] arr = new int[n][m];
        // for(int i=0;i<n;i++){
        //     for(int j=0;j<m;j++){
        //         arr[i][j]=sc.nextInt();
        //     }
        // }

        int arr[][]= {{4, 3, 2}, 
                       {1, 8, 3}, 
                       {1, 1, 8}}; 
        
        System.out.println(minCost_dp_i(arr, 0, 0, 2, 2 ));
    }

    private static int minCost_rec(int[][] arr, int si, int sj, int ei, int ej) {

        if(si==ei && sj==ej) return arr[si][sj];
        if(si>ei || sj>ej ) return Integer.MAX_VALUE;

        int opt1 = minCost_rec(arr, si+1, sj, ei, ej);
        int opt2 = minCost_rec(arr, si, sj+1, ei, ej);
        int opt3 = minCost_rec(arr, si+1, sj+1, ei, ej);
        return Math.min(opt1, Math.min(opt2, opt3)) + arr[si][sj];
        
    }

    private static int minCost_dp_i(int[][] arr, int si, int sj, int ei, int ej) {

        int[][] dp = new int[ei+1][ej+1];
        dp[ei][ej] = arr[ei][ej];
        
        int sum = arr[ei][ej];
        for(int i=ei-1;i>=0;i--){
            sum += arr[i][ei];
            dp[i][ei] = sum;
        }

        sum = dp[ei][ej];
        for(int i=ej-1;i>=0;i--){
            sum += arr[ej][i];
            dp[ej][i] = sum;
        }
        for(int i=0;i<=ei;i++)
            System.out.println(Arrays.toString(dp[i]));

        for(int i=ei-1; i>=0; i--){
            for(int j=ej-1; j>=0; j--){
                dp[i][j] = Math.min(dp[i+1][j+1], Math.min(dp[i+1][j], dp[i][j+1])) + arr[i][j];
            }
        }

        for(int i=0;i<=ei;i++)
            System.out.println(Arrays.toString(dp[i]));

        return dp[0][0];

        
    }


}