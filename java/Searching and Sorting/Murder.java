import java.util.*;

public class Murder{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-->0){
            int n = sc.nextInt();
            int[] arr = new int[n];
            for(int i=0;i<n;i++){
                arr[i]=sc.nextInt();
            }
            System.out.println(mergeSort(arr, 0, n-1));
        }
        sc.close();

    }

    static long mergeSort(int[] arr, int l, int h){
        if(l>=h) return 0;
        int mid = (l+h)/2;
        long sum = 0;
        sum += mergeSort(arr, l, mid);
        sum += mergeSort(arr, mid+1, h);
        sum += merge(arr, l, mid+1, h);
        return sum;
    }

    static long merge(int arr[], int l, int mid, int h){
        
        int i=l, j=mid, k=0;
        int[] temp = new int[h-l+1];
        long sum = 0;
        while(i<mid && j<=h){
            if(arr[i]<arr[j]){
                sum += arr[i]*(h-j+1);
                temp[k++]=arr[i++];
            }else{
                temp[k++]=arr[j++];
            }
        }
        while(i<mid) temp[k++]=arr[i++];
        while(j<=h) temp[k++]=arr[j++];
        for(i=l,k=0; i<=h; i++, k++ ){
            arr[i]=temp[k];
        }
        return sum;

    }
}

