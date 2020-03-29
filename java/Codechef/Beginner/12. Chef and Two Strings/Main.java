import java.util.*;

public class Main{

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine();

        while(t-->0){
            String s1 = sc.nextLine();
            String s2 = sc.nextLine();
            int max = 0;
            int min = 0;
            for(int i=0;i<s1.length();i++){
                if( s1.charAt(i) == '?' && s2.charAt(i) == '?'){
                    max++;
                }else if( s1.charAt(i) == '?' && s2.charAt(i) != '?' ){
                    max++;
                }else if( s1.charAt(i) != '?' && s2.charAt(i) == '?' ){
                    max++;
                }else{
                    if( s1.charAt(i) != s2.charAt(i) ){
                        max++; min++;
                    }
                }
            }
            System.out.println(min+" "+max);
        }
        sc.close();
    }
}