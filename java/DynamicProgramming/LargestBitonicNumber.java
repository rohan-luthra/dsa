import java.util.*;

public class LargestBitonicNumber{

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int arr[] = new int[n];
		for(int i = 0 ; i < n; i++){
			arr[i] = s.nextInt();
		}
		
		System.out.println(longestBitonicSubarray(arr));
    }


    public static int longestBitonicSubarray(int[] arr){

        /* Your class should be named Solution.
         * Don't write main() function.
         * Don't read input, it is passed as function argument.
         * Return output and don't print it.
         * Taking input and printing output is handled automatically.
         */
            int n = arr.length;
            int[] dpInc = new int[n];
            int[] dpDec = new int[n];
            dpInc[0]=1;
            for(int i=1 ; i<n; i++){
                dpInc[i]=1;
                for(int j=i-1; j>=0; j--){
                    if(arr[i] <= arr[j] ) { continue; }
                    dpInc[i] = Math.max( dpInc[i], dpInc[j]+1 );
                }
                dpInc[i] = dpInc[i]%1000000007;
            }
            
            dpDec[n-1]=1;
            for(int i=n-2; i>=0; i--){
                dpDec[i]=1;
                for(int j=i+1; j<n;j++){
                    if(arr[i] <= arr[j] ) { continue; }
                    dpDec[i] = Math.max( dpDec[i], dpDec[j]+1 );
                }
                dpDec[i] = dpDec[i]%1000000007;
            }
            
            
            // System.out.println(Arrays.toString(dpInc));
            // System.out.println(Arrays.toString(dpDec));
            int max = 0;
            for(int i=0;i<n;i++)
                max = Math.max(max, (dpInc[i]+dpDec[i]-1)%1000000007);
            return max;
            
            
        }
}