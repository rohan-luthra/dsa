import java.util.*;

public class AggressiveCows {

	
	public static void main(String[] args) {
		// Write your code here

        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-->0){
        
            int n = sc.nextInt();
            int c = sc.nextInt();
            int[] a = new int[n];
            int max = 0;
            for(int i=0; i<n; i++){
                a[i] = sc.nextInt();
            }
            Arrays.sort(a);
            int h = a[n-1];
            int l = 0;
            int mid = (l+h)/2;
            // System.out.println(l + " " + mid + " " + h);
            System.out.println( minDist(a,l, mid, h-1, c) );   
        }
	}
    
    public static int minDist(int[] a, int low, int mid, int high, int cows){
        // System.out.println(low + " " + mid + " " + high);
        if(low>high) return mid;
        int d = 1;
        int prevI = 0;
        for(int i=1; i<a.length; i++){
            if( a[i] - a[prevI] >= mid ) { d++; prevI = i; }
            if(d==cows) break;
        }
        // System.out.println(d+" "+cows+"\n");
        if(d >= cows){
            int l = mid+1;
            int h = high;
            int m = (l+h)/2;
            return minDist(a, l ,m, h, cows);
        }else{
            int l = low;
            int h = mid-1;
            int m = (l+h)/2;
            return minDist(a, l, m, h, cows);
        }
    }

}