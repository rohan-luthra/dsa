import java.util.Scanner;

public class Main{

    static int[] matches = new int[]{6, 2, 5, 5, 4, 5, 6, 3, 7, 6};

    public static void main(String[] args) {
        
        Scanner sc =  new Scanner(System.in);
        int t = sc.nextInt();
        while(t-->0){
            int a = sc.nextInt();
            int b = sc.nextInt();
            int n = a + b;
            int count = 0;
            while(n>0){
                count+=matches[n%10];
                n/=10;
            }
            System.out.println(count);
        }
        sc.close();
    }
}