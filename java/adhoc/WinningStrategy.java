import java.util.*;

public class WinningStrategy {
	
	public static void main(String[] args) {
		/* Your class should be named Main.
 			* Read input as specified in the question.
 			* Print output as specified in the question.
		*/

		// Write your code here
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        int[] temp = new int[n];
            
        for(int i=0; i<n; i++){
            arr[i]=sc.nextInt();
            temp[i]=i+1;
        }

        
        int swapCount = 0;
        int flag = 0;
        int i = 0;
        while(i<n){
            // System.out.println(i+" "+Arrays.toString(arr)+" "+Arrays.toString(temp));
            if(arr[i]-temp[i] >2){ flag = 1; break; }
            if(arr[i]==temp[i]){ i++; continue;}
            if(arr[i] == temp[i+1] && arr[i+1] == temp[i]){
                // System.out.println("two");
                temp[i] += 1;
                temp[i+1] += -1;
                i+=2;
                swapCount += 1;
                continue;
            }
            if(arr[i] == temp[i+2] && arr[i+1]==temp[i] && arr[i+2]==temp[i+1]){
                // System.out.println("three");
                temp[i] += 2;
                temp[i+1] += -1;
                temp[i+2] += -2;
                i+=3;
                swapCount += 2;
            	continue;
            }
            flag = 1;
            break;
            
        }
        
        if(flag==1)
            System.out.println("NO");
        else{
            System.out.println("YES\n"+swapCount);
        }

	}

}