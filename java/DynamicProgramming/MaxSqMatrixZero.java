import java.util.*;

public class MaxSqMatrixZero{

    public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s=new Scanner(System.in);
		int n=s.nextInt();
		int m=s.nextInt();
		int arr[][]=new int[n][m];
		for(int i=0;i<n;i++)
			for(int j=0;j<m;j++)
				arr[i][j]=s.nextInt();
		System.out.println(findMaxSquareWithAllZeros(arr));
    }
    
    public static int findMaxSquareWithAllZeros(int[][] arr){
		
            int n = arr.length;
            int m = arr[0].length;
            int[][] dp = new int[n][m];
            
            for(int i=0; i<n; i++) dp[i][0] = (arr[i][0] == 0)?1 : 0;
            for(int i=0; i<m; i++) dp[0][i] = (arr[0][i] == 0)?1 : 0;
            
            // System.out.println(Arrays.toString(dp[0]));
            
            for(int i=1;i<n;i++){
                for(int j=1; j<m; j++){
                    if(arr[i][j]==1) dp[i][j]=0;
                    else {
                        dp[i][j] = Math.min( dp[i-1][j-1], Math.min( dp[i-1][j], dp[i][j-1] ) ) +1;
                    }
                }
            }
            
            int max = 0;
            for(int i=0;i<n;i++){
                for(int j=0; j<m; j++)
                    max = Math.max(dp[i][j], max);
            }
            return max;
    
        }
}