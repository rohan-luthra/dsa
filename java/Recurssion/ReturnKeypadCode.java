import java.util.*;
public class ReturnKeypadCode {

    static String[] table= {"","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        String[] str = keypad(n);
        System.out.println(Arrays.toString(str));
    }

    public static String[] keypad(int n){

        if(n==0) return new String[]{};
        String[] arr = keypad(n/10);
        int currN = n%10;
        String nStr = table[currN-1];

        System.out.println(Arrays.toString(arr));
        System.out.println(nStr);


        if(arr.length == 0){
            String[] res = new String[nStr.length()];
            int k = 0;
            for(char c: nStr.toCharArray()){
                res[k++] = c+"";
            }
            return res;
        }else{

            String[] res = new String[nStr.length()*arr.length];
            int k = 0;
            for(char c: nStr.toCharArray()){
                for(String s: arr){
                    res[k++] = s+c;
                }
            }
            return res;

        }

    }

}