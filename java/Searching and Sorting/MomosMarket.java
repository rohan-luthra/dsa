import java.util.*;

public class MomosMarket {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();
        int[] prr = new int[n];
        for(int i=0;i<n;i++) prr[i]=sc.nextInt();
        int q = sc.nextInt();
        
        int[] prefix = new int[n];
        int sum = 0;
        for(int i=0;i<n;i++) {
            sum += prr[i];
            prefix[i]=sum;
        }
        
        // System.out.println(Arrays.toString(prefix));
        for(int i=0;i<q;i++){
            
            int x = sc.nextInt();
            if(sum<=x){
                System.out.println(n+" "+(x-sum));
            }else{    
                int start = 0;
                int end = n-1;
                int index = -1;
                while(start<end){
                    int mid = (start+end)/2;
                    if(prefix[mid]<=x){
                        index = mid;
                        start = mid + 1;
                    }else{
                        end = mid;
                    }
                }
                
                if(index == -1){
                    System.out.println("0 "+x);
                }else{
                    System.out.println((index+1)+" "+( x-prefix[index]));
                }
            }
            
        }
		
	}
}