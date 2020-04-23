import java.util.*;

public class InterestingSecquence {

	
	public static void main(String[] args) {
		// Write your code here
        Scanner sc = new Scanner(System.in);
        String[] str = sc.nextLine().split(" ");
        int n = Integer.parseInt(str[0]);
        int k = Integer.parseInt(str[1]);
        int l = Integer.parseInt(str[2]);
        
        int[] arr = new int[n];
        
        int max = -1;
        int min = 1000;
        
        for(int i=0; i<n; i++){
            arr[i] = sc.nextInt();
            if(arr[i] > max) max = arr[i];
            if(arr[i] < min) min = arr[i];
        }
        
        int minCost = Integer.MAX_VALUE;
        for(int i = min; i<=max; i++){
            
            int inc = 0;
            int dec = 0;
            for(int j=0; j<n; j++){
                if(arr[j] > i) dec+= ( arr[j] -i);
                if(arr[j] < i) inc+= ( i - arr[j]);
            }
            
            if(inc<dec) continue;
            int cost = (dec)*k + (inc-dec)*l;
            if(cost < minCost) minCost = cost;
            
        }
        
        System.out.println(minCost);

	}

}