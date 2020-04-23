import java.util.*;
public class PrintSubSequenceString {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        printSubSequenceString(s,"");
    }
    
    public static void  printSubSequenceString(String s, String out){
        if(s.length() == 0){
            System.out.println(out);
            return;
        }
        printSubSequenceString(s.substring(1), out);
        printSubSequenceString(s.substring(1), out+s.charAt(0));
    }

}