import java.util.*;

public class Main{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();

        int[] arr = new int[n];
        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();
        }
        int i = 0;
        int j = 1;
        int count = 0;
        Arrays.sort(arr);
        while(i<n && j<n){
            if(i==j) j++;
            else{
                if(arr[j]-arr[i]>=k){
                    count += n-j;
                    i++;
                }else{
                    j++;
                }

            }
        }
        System.out.println(count);
        sc.close();


    }
}