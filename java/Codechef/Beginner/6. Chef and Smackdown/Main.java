import java.util.*;

public class Main{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while(t-->0){
            int n = sc.nextInt();
            if(n==2019 || n==2017 || n==2016 || n==2015 || n==2010){
                System.out.println("HOSTED");
            }else{
                System.out.println("NOT HOSTED");
            }
        }
        sc.close();
    }
}