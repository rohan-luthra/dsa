import java.util.*;

public class Equalize {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();

        String a = sc.nextLine();
        String b = sc.nextLine();
        int cost = 0;

        for(int i=0;i<n;i++){
            if(a.charAt(i) == b.charAt(i)) continue;
            if(i==n-1) {
                cost++;
            }else{

                if(a.charAt(i) != a.charAt(i+1) && a.charAt(i+1) != b.charAt(i+1)){
                    cost++;
                    i++;
                }else{
                    cost++;
                }
            }
        }
        System.out.println(cost);

    }

}