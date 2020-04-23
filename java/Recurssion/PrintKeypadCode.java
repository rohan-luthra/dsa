import java.util.Scanner;

public class PrintKeypadCode {

    static String[] table= {"","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        printKeypadCode(n, "");
    }

    public static void printKeypadCode(int n, String out){
        if(n==0) {
            System.out.println(out);
            return;
        }

        String nStr = table[n%10 -1];
        for(char c: nStr.toCharArray()){
            printKeypadCode(n/10, c+out);
        }
        
    }
}