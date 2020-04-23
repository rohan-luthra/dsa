import java.util.*;

public class DistributeCandies {

	public static void main(String[] args) {
		// Write your code here

        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-->0){
            int n = sc.nextInt();
            int k = sc.nextInt();
            int[] arr = new int[n];
            for(int i=0;i<n;i++){
                arr[i]=sc.nextInt();
            }
            
            Arrays.sort(arr);
            int start = 0;
            int end = arr[n-1];
            int max = 0;
            // System.out.println(start);
            while(start<end){
                    
                int curr = (start + end)/2;
                
                // System.out.println(start+" "+curr+" "+end);
                
                int temp = k;
                for(int i=0;i<n;i++){
                    temp -= arr[i]/curr;
                    if(temp<=0) break;
                }
                if(temp<=0){
                    max = curr;
                    start = curr+1;
                }else{
                    end = curr;
                }
            }
            System.out.println(max);
        }
	}

}