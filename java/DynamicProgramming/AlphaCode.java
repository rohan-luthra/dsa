import java.util.*;

public class AlphaCode {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while(true){
            String[] str = sc.nextLine().split("");
            if(str[0].equals("0")) break;
            
            int n = str.length;
            long[] dp = new long[n+1];
            dp[0]=dp[1]=1;
            for(int i=2;i<=n;i++){
                // cheking 0 at i-1 place
                if(Integer.parseInt(str[i-1]) != 0){
                    dp[i]=dp[i-1];
                }
                // checking 0 at i-2 place
                // and checking if prev elem also contibutes
                if( Integer.parseInt(str[i-2]) != 0 && (Integer.parseInt(str[i-2])*10 + Integer.parseInt(str[i-1])) <= 26){
                    dp[i] += dp[i-2];
                }
            }

            // System.out.println(Arrays.toString(dp));
            System.out.println(dp[n]);

        }
        sc.close();
        
    }

}