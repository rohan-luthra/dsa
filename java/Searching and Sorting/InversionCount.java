import java.util.*;
public class InversionCount {
	
	static long solve(int[] A,int n){
        return inversionCount(A, 0, n-1);
	}
    
    static long inversionCount(int[] a, int low, int high){
        long count = 0;
        if(low<high){
            int mid = (low+high)/2;
            count += inversionCount(a, low, mid);
            count += inversionCount(a, mid+1, high);
            count += mergeCount(a, low, mid+1, high);
        }
        return count;

    }
    
    static long mergeCount(int[] a, int left, int mid, int right){
    
        int i=left, j=mid, k=0;
        
        int[] t = new int[ (right-left+1)];
        long count = 0;
        while( i<mid && j<=right){
            if(a[i]<=a[j]) t[k++] = a[i++];
            else{
                t[k++] = a[j++];
                count += (mid - i);
            }
        }
        while(i<mid) t[k++] = a[i++];
        while(j<=right) t[k++] = a[j++];
        // System.out.println(left+" "+mid+" "+count +" "+Arrays.toString(t));
        for( i=left, k=0; i<=right; i++, k++ ){
            a[i]=t[k];
        }
        return count;
    }

    static int MAXN = 100005;
	
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		int n;
		int[] A = new int[MAXN];
		n = scan.nextInt();
		for(int i = 0; i < n ; i++){
			A[i] = scan.nextInt();
		}
        System.out.println(solve(A,n));
        scan.close();

	}
	
}